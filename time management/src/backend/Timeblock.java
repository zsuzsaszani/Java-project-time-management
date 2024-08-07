package backend;

import java.time.LocalTime;

public abstract class Timeblock {
public LocalTime start;
public LocalTime end;
public String name="";
public void SetTimeBlock(LocalTime start, LocalTime end, String name){
	
	this.start=start;
	this.end=end;	
	this.name=name;
	
}
}

