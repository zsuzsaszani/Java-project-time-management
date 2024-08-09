package backend;
import java.util.ArrayList;

public class ReservedTime extends Timeblock{
public ReservedTime() {
	super();
}
private static ArrayList<Timeblock> ReservedTimes=new ArrayList<>();
public static void setReservedTimes(Timeblock activity) 
	{
		ReservedTimes.add(activity);
	}
}
