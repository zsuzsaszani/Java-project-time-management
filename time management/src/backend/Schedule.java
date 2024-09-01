package backend;

import java.util.*;

public class Schedule {
    private Map<String, List<Task>> weeklySchedule;

    public Schedule() {
        weeklySchedule = new LinkedHashMap<>();
        for (String day : Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")) {
            weeklySchedule.put(day, new ArrayList<>());
        }
    }

     boolean canAddTask(Task task) {
        int totalHours = task.getTimes();
        int lengthOfTask = task.getLength(); 
        int blocksNeeded = (int) Math.ceil((double) totalHours / lengthOfTask);

        for (int i = 0; i < blocksNeeded; i++) {
            if (!scheduleBlock(task)) {
                System.out.println("Could not schedule task: " + task.getName() + " on " + getDayName(task.getDay()));
                return false;
            }
        }

        return true;
    }

    public boolean scheduleBlock(Task task) {
        String dayName = getDayName(task.getDay());
        List<Task> daySchedule = weeklySchedule.get(dayName);

        Timeblock taskTimeblock = new Timeblock();
        taskTimeblock.setDay(task.getDay());

        // Find available time slot
        boolean scheduled = false;
        for (int startHour = 0; startHour < 24; startHour++) {
            for (int startMin = 0; startMin < 60; startMin += 60) { 
                int endHour = startHour + task.getLength();
                if (endHour > 23) {
                    break; 
                }
                int endMin = startMin;

                taskTimeblock.setTimeblock(startHour, startMin, endHour, endMin, task.getDay());

                if (canScheduleTimeblock(taskTimeblock, daySchedule)) {
                    // Schedule the block
                    daySchedule.add(task);
                    scheduled = true;
                    break; 
                }
            }
            if (scheduled) {
                break;
            }
        }

        return scheduled;
    }

    private boolean canScheduleTimeblock(Timeblock taskTimeblock, List<Task> daySchedule) {
        // Check for conflicts with reserved times
        for (Timeblock reservedTime : ReservedTime.getReservedTimes()) {
            if (taskTimeblock.getDay() == reservedTime.getDay() && timeblocksOverlap(reservedTime, taskTimeblock)) {
                return false;
            }
        }

        // Check for conflicts with already scheduled tasks
        for (Task scheduledTask : daySchedule) {
            if (timeblocksOverlap(scheduledTask, taskTimeblock)) {
                return false;
            }
        }

        return true;
    }

    private boolean timeblocksOverlap(Timeblock tb1, Timeblock tb2) {
        int tb1Start = tb1.getStartHour() * 60 + tb1.getStartMin();
        int tb1End = tb1.getEndHour() * 60 + tb1.getEndMin();
        int tb2Start = tb2.getStartHour() * 60 + tb2.getStartMin();
        int tb2End = tb2.getEndHour() * 60 + tb2.getEndMin();

        return tb1Start < tb2End && tb2Start < tb1End;
    }

    private String getDayName(int day) {
        switch (day) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return "Invalid Day";
        }
    }

    
    }

