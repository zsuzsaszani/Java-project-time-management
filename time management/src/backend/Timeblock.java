package backend;

//review getters setters
public class Timeblock {
	private int startHour;
	private int startMin;
	private int endHour;
	private int endMin;
	public String name;
	
	public void setTimeblock(int startHour, int startMin, int endHour, int endMin) {
		if(startMin<60 && startMin<=0 && startHour>=0 && startMin<24) 
		{
			this.startHour=startHour;
			this.startMin=startMin;
		}
	else {System.out.println("Invalid time!");}
	if(endMin<60 && endMin<=0 && startHour>=0 && startMin<24) 
		{
			this.endHour=endHour;
			this.endMin=endMin;
		}
	else {System.out.println("Invalid time!");}
    }
	//getters, setters
	public void setStart(int startHour, int startMin) 
		{
			if(startMin<60 && startMin<=0 && startHour>=0 && startMin<24) 
				{
					this.startHour=startHour;
					this.startMin=startMin;
				}
			else {System.out.println("Invalid time!");}
		}
	public void setEnd(int endHour, int endMin) 
		{
			if(endMin<60 && endMin<=0 && startHour>=0 && startMin<24) 
			{
				this.endHour=endHour;
				this.endMin=endMin;
			}
			else {System.out.println("Invalid time!");}
	}
	public void setName(String name) 
		{
			this.name=name;
		}
	public String getName() 
	{
		return this.name;
	}
	public int getStartHour() 
		{
			return this.startHour;
		}
	public int getStartMin() 
		{
			return this.startMin;
		}
	public int getEndHour() 
		{
			return this.endHour;
		}
	public int getEndMin() 
		{
			return this.endMin;
		}
	
}

