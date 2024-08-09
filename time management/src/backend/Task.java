package backend;

public abstract class Task extends Timeblock {
	public Task() {super();}
public int times=0;
public String type="";
public String daytime="";
public int priority;
public void giving(int times, String type, int priority) {
	
	this.times=times;
	this.type=type;
	this.priority=priority;
	
}
public void giving(int times) {
	this.times=times;
	
}
public void giving(String type) {
	this.type=type;	
}
//priority missing

}
