package backend;

public abstract class Task extends Timeblock {
public int times=0;
public String type="";
public String daytime="";
public int priority;
public void giving(String name, int times, String type, int priority) {
	this.name=name;
	this.times=times;
	/*while(type.equals("Active") || type.equals("Passive") || type.equals("Fun")) {
		this.type=type;
	}
	while(type.equals("Active") || type.equals("Passive") || type.equals("Fun")) {
		this.priority=priority;
		
	}*/
	
	
	
}
public void giving(String name, int times) {
	this.name=name;
	this.times=times;
	
}
public void giving(String name, String type) {
	this.name=name;
	this.type=type;
	
}


}
