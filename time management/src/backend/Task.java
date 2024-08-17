package backend;

import java.util.ArrayList;

public class Task extends Timeblock {
	public Task() {super();}
public int times=0;
public TYPE type;
public DAYTIME daytime;
public int priority;

// args concerning sleep
public boolean sleep;
public boolean polisleep;
public int numberOfSleeps;
public int lengthOfSleep;


//args concerning eating
public int numberOfMeals;
public ArrayList<Timeblock> startTimeOfMeals = new ArrayList<>();
public ArrayList<Timeblock> endTimeOfMeals = new ArrayList<>();







}
