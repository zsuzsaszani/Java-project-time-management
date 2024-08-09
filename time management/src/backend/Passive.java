package backend;

import java.util.ArrayList;

public class Passive extends Task{

private Boolean sleep;
private Boolean polisleep;
private int numberOfSleeps;
private int lengthOfSleep;
private Boolean eating;
private int numberOfMeals;
private ArrayList<Timeblock> startTimeOfMeals = new ArrayList<>();
private ArrayList<Timeblock> endTimeOfMeals = new ArrayList<>();


public Passive() {
    super(); 
}

public Boolean getSleep() {
    return sleep;
}

public void setSleep(Boolean sleep) {
    this.sleep = sleep;
}

public Boolean getPolisleep() {
    return polisleep;
}

public void setPolisleep(Boolean polisleep) {
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

public Boolean getEating() {
    return eating;
}

public void setEating(Boolean eating) {
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

public void setStartTimeOfMeals(Timeblock startTime) {
    this.startTimeOfMeals.add(startTime);
}

public ArrayList<Timeblock> getEndTimeOfMeals() {
    return endTimeOfMeals;
}

public void setEndTimeOfMeals(Timeblock endTime) {
    this.endTimeOfMeals.add(endTime);
}
}
