package backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		//welcome
		Scanner scan=new Scanner(System.in);
		 ArrayList<Task> taskList=new ArrayList<Task>();	       
		print("Welcome to your new scheduling application! Let me give you a short introduction..."); //here comes the introduction text
		
		
		
		//questions/user input
		print("Let's start with a few details about you and your habbits.");
		
		//sleeping 
		print("First, let's talk about your sleeping routine.");
		
		print("Do you prefer monophasic or poliphasic sleep? Please type the answer: ");
		String polisleep=scan.nextLine().toUpperCase();
		Task sleep=new Task();
		sleep.sleep=true;
		sleep.type=TYPE.PASSIVE;
		if(polisleep.equals("POLIPHASIC")) 
			{
				sleep.polisleep=true;
			}
		else
			{
				sleep.polisleep=false;
			}
		sleep.setName("sleep");
		
		if(sleep.polisleep)
			{
				print("How much phase do you sleep in?(Please enter in number, not with words!)");
				sleep.numberOfSleeps=scan.nextInt();

			
				print("How long are these sessions on average(measured in hours)?");
				sleep.lengthOfSleep=scan.nextInt();
			}
		else 
			{
			sleep.numberOfSleeps=1;
			System.out.println("How much do you sleep a day on average(measured in hours)?");
			sleep.lengthOfSleep=scan.nextInt();
			}
		taskList.add(sleep);
		
		//eating --needs to be redesigned after using enum
		
		Task eating=new Task();
		 System.out.println("Let's move on to your eating habits.");
		 
	        print("How many times do you eat a day?");
	        eating.numberOfMeals=scan.nextInt();
	        scan.nextLine(); 
	        Timeblock timeblockEating = null;

	        for (int i = 0; i < eating.numberOfMeals; i++) //bug, still under solving
	        	{
	           		 System.out.printf("Please describe the time-range in which you have your %d. meal. Please use this format: 1800 2200 (from 6 pm. till 10 pm.)\n", i + 1);
	           		 String temporal[] = scan.nextLine().split(" ");
	           		 int startHour=Integer.parseInt(temporal[0].substring(0, 1));
	           		 int startMin=Integer.parseInt(temporal[0].substring(2, 3));
	           		 timeblockEating.setStart(startHour, startMin);
	           		 
	           		 int endHour=Integer.parseInt(temporal[0].substring(0, 1));
	           		 int endMin=Integer.parseInt(temporal[0].substring(2, 3));
	           		 timeblockEating.setEnd(endHour, endMin);
	            

	           		 eating.startTimeOfMeals.add(timeblockEating);
	           		eating.endTimeOfMeals.add(timeblockEating);
	        	}
	        
	        //reserved time
	        print("Please indicate your dedicated times on the table! In this version, with the given format: 0900 1330 (means: from 9 a.m. till 1:30 p.m.). If done with one block, press enter, if done with each, press Q"); //here:numbers, later: visual
	        
	        while(!scan.next().toUpperCase().equals("Q")) 
	        	{
	        	 	Timeblock timeblockReserved = null;
	        	 	String temporal[] = scan.nextLine().split(" ");
	           	 	int startHour=Integer.parseInt(temporal[0].substring(0, 1));
	           	 	int startMin=Integer.parseInt(temporal[0].substring(2, 3));
	           	 	timeblockReserved.setStart(startHour, startMin);
	            
	           	 	int endHour=Integer.parseInt(temporal[0].substring(0, 1));
	           	 	int endMin=Integer.parseInt(temporal[0].substring(2, 3));
	           	 	timeblockReserved.setEnd(endHour, endMin);
	           	 
		       	 	print("Now, please give a name to this activity: ");
		       	 	timeblockReserved.setName(scan.nextLine());
		       	 	ReservedTime.setReservedTimes(timeblockReserved);
	        	}

	        
		
		
		//generating tasks
	        print("Now let's move on to your other activities, what you would like to implement to your schedulde.");
	        print("Enter the details of the activities, then press Q");
	       
	        
	        
	        int numberOfActivities=0;
	        while (!scan.nextLine().toLowerCase().equals("q")) {
	        	Task task=new Task();
	            System.out.print("What is the name of this activity? ");
	            String name = scan.nextLine();
	            
	            if (name.equalsIgnoreCase("Q")) {
	                break;
	            }

	            print("How many hours would you like to spend on this activity per week? ");
	            int times = scan.nextInt();

	            print("What type of activity do you consider it? Active, passive, or fun? ");
	            String typeInput = scan.nextLine().toUpperCase();
	            
	            TYPE type = null;
	            switch (typeInput) {
	                case "ACTIVE":
	                    type = TYPE.ACTIVE;
	                    break;
	                case "PASSIVE":
	                    type = TYPE.PASSIVE;
	                    break;
	                case "FUN":
	                    type = TYPE.FUN;
	                    break;
	                default:
	                    print("Unknown type. Please enter Active, Passive, or Fun.");
	                    continue;
	            }
	            
	            
	            print("What part of the day do you prefer to do it? Please enter dawn, morning, afternoon, evening or night!");
	            String daytimeInput = scan.nextLine().toUpperCase();
	            
	            DAYTIME daytime = null;
	            switch (daytimeInput) {
	                case "DAWN":
	                    daytime=DAYTIME.DAWN;
	                    break;
	                case "MORNING":
	                	daytime=DAYTIME.MORNING;
	                    break;
	                case "AFTERNOON":
	                	daytime=DAYTIME.AFTERNOON;
	                    break;
	                case "EVENING":
	                	daytime=DAYTIME.EVENING;
	                    break;
	                case "NIGHT":
	                	daytime=DAYTIME.NIGHT;
	                    break;
	                default:
	                    print("Unknown type. Please enter dawn, morning, afternoon, evening or night!");
	                    continue;
	            }
	            numberOfActivities++;
	            taskList.add(task);
	            
	        }
	        print("Now, please organise your activities, according to their importance, where the first is the most important, and the last is the least important. Please separate the activities with a space.");
	        print("For reminder: Your activities were these: ");
	        
	}

	public static void print(String print)
	{
	System.out.println(print);
	}

}
