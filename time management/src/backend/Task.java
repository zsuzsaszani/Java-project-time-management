package backend;

import java.util.ArrayList;

public class Task extends Timeblock {
    
    private int times = 0;
    private TYPE type;
    private DAYTIME daytime;
    private int priority;

    // Args concerning sleep
    private boolean sleep = false;
    private boolean polisleep;
    private int numberOfSleeps;
    private int lengthOfSleep;

    // Args concerning eating
    private boolean eating = false;
    private int numberOfMeals;
    private ArrayList<Timeblock> startTimeOfMeals = new ArrayList<>();
    private ArrayList<Timeblock> endTimeOfMeals = new ArrayList<>();

    // Getters and Setters

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public DAYTIME getDaytime() {
        return daytime;
    }

    public void setDaytime(DAYTIME daytime) {
        this.daytime = daytime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isPolisleep() {
        return polisleep;
    }

    public void setPolisleep(boolean polisleep) {
        this.polisleep = polisleep;
    }

    public int getNumberOfSleeps() {
        return numberOfSleeps;
    }

    public void setNumberOfSleeps(int numberOfSleeps) {
        this.numberOfSleeps = numberOfSleeps;
    }

    public int getLengthOfSleep() {
        return lengthOfSleep;
    }

    public void setLengthOfSleep(int lengthOfSleep) {
        this.lengthOfSleep = lengthOfSleep;
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public ArrayList<Timeblock> getStartTimeOfMeals() {
        return startTimeOfMeals;
    }

    public void setStartTimeOfMeals(ArrayList<Timeblock> startTimeOfMeals) {
        this.startTimeOfMeals = startTimeOfMeals;
    }

    public ArrayList<Timeblock> getEndTimeOfMeals() {
        return endTimeOfMeals;
    }

    public void setEndTimeOfMeals(ArrayList<Timeblock> endTimeOfMeals) {
        this.endTimeOfMeals = endTimeOfMeals;
    }

    @Override
    public String toString() {
        return this.name;
    }
}