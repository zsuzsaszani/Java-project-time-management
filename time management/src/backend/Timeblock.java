package backend;


public abstract class Timeblock {
private int startHour;
private int startMin;
private int endHour;
private int endMin;
private String name;

public void setStart(int startHour, int startMin) {
	if(startMin<60 && startMin<=0 && startHour>=0 && startMin<24) {
		this.startHour=startHour;
		this.startMin=startMin;
	}
	else {System.out.println("Invalid time!");}
}
public void setEnd(int endHour, int endMin) {
	if(endMin<60 && endMin<=0 && startHour>=0 && startMin<24) {
		this.endHour=endHour;
		this.endMin=endMin;
	}
	else {System.out.println("Invalid time!");}
}
public void setName(String name) {this.name=name;}
public int getStartHour() {return this.startHour;}
public int getStartMin() {return this.startMin;}
public int getEndHour() {return this.endHour;}
public int getEndMin() {return this.endMin;}
}

