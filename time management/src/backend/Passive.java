package backend;

import java.util.ArrayList;

public class Passive extends Task{
/*public Boolean sleep;
public Boolean polisleep;
public int numberOfSleeps;
public int lenghtOfSleep;
public Boolean eating;
public int numberOfMeals;
public ArrayList<Integer> startTimeOfMeals; 
public ArrayList<Integer> endTimeOfMeals; 
*/
private Boolean sleep;
private Boolean polisleep;
private int numberOfSleeps;
private int lengthOfSleep;
private Boolean eating;
private int numberOfMeals;
private ArrayList<Integer> startTimeOfMeals = new ArrayList<>();
private ArrayList<Integer> endTimeOfMeals = new ArrayList<>();


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

public ArrayList<Integer> getStartTimeOfMeals() {
    return startTimeOfMeals;
}

public void setStartTimeOfMeals(ArrayList<Integer> startTimeOfMeals) {
    this.startTimeOfMeals = startTimeOfMeals;
}

public ArrayList<Integer> getEndTimeOfMeals() {
    return endTimeOfMeals;
}

public void setEndTimeOfMeals(ArrayList<Integer> endTimeOfMeals) {
    this.endTimeOfMeals = endTimeOfMeals;
}
}
