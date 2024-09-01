package backend;

public class Timeblock {
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    public String name;
    public int day;

    public void setTimeblock(int startHour, int startMin, int endHour, int endMin, int day) {
        if (startMin < 60 && startMin >= 0 && startHour >= 0 && startHour < 24) {
            this.startHour = startHour;
            this.startMin = startMin;
        } else {
            System.out.println("Invalid start time!");
        }
        if (endMin < 60 && endMin >= 0 && endHour >= 0 && endHour < 24) {
            this.endHour = endHour;
            this.endMin = endMin;
        } else {
            System.out.println("Invalid end time!");
        }
        if(day>=0 && day<7) {
        	this.day=day;
        }else System.out.println("Invalid day");}
    

    // Getters and Setters
    public void setStart(int startHour, int startMin) {
        if (startMin < 60 && startMin >= 0 && startHour >= 0 && startHour < 24) {
            this.startHour = startHour;
            this.startMin = startMin;
        } else {
            System.out.println("Invalid start time!");
        }
    }

    public void setEnd(int endHour, int endMin) {
        if (endMin < 60 && endMin >= 0 && endHour >= 0 && endHour < 24) {
            this.endHour = endHour;
            this.endMin = endMin;
        } else {
            System.out.println("Invalid end time!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public int getStartMin() {
        return this.startMin;
    }

    public int getEndHour() {
        return this.endHour;
    }

    public int getEndMin() {
        return this.endMin;
    }
    public void setDay(int day) {
    	this.day=day;{
}
    }
    public int getDay(){
    return this.day;
    }
}
