package backend;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Map;

public class Combination {
	  ArrayList<task> tasks;
	    Map<DayOfWeek, ArrayList<task>> schedule;

	    public void combinations(ArrayList<task> tasks) {
	        this.tasks = tasks;
	        schedule = new EnumMap<>(DayOfWeek.class);
	        for (DayOfWeek day : DayOfWeek.values()) {
	            weeklySchedule.put(day, new ArrayList<>());
	        }
}
