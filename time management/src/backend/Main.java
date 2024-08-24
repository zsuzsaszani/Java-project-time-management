package backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		sleep.setSleep(true);
		sleep.setType(TYPE.PASSIVE);
		if(polisleep.equals("POLIPHASIC")) 
			{
				sleep.setPolisleep(true);
			}
		else
			{
				sleep.setPolisleep(false);
			}
		sleep.setName("sleep");
		
		if(sleep.isPolisleep())
			{
				print("How much phase do you sleep in?(Please enter in number, not with words!)");
				sleep.setNumberOfSleeps(scan.nextInt());

			
				print("How long are these sessions on average(measured in hours)?");
				sleep.setLengthOfSleep(scan.nextInt());
			}
		else 
			{
			sleep.setNumberOfSleeps(1);
			System.out.println("How much do you sleep a day on average(measured in hours)?");
			sleep.setLengthOfSleep(scan.nextInt());
			}
		taskList.add(sleep);
		
		//eating 
		
		Task eating=new Task();
		eating.setEating(true);
		 System.out.println("Let's move on to your eating habits.");
		 
	        print("How many times do you eat a day?");
	        eating.setNumberOfMeals(scan.nextInt());
	        scan.nextLine(); 

	        
	        
	        for (int i = 0; i < eating.getNumberOfMeals(); i++) {
	            System.out.printf("Please describe the time-range in which you have your %d. meal. Please use this format: 1800 2200 (from 6 pm till 10 pm).\n", i + 1);
	            String temporal[] = scan.nextLine().split(" ");

	            int startHour = Integer.parseInt(temporal[0].substring(0, 2)); // Extract hours correctly
	            int startMin = Integer.parseInt(temporal[0].substring(2, 4));  // Extract minutes correctly

	            int endHour = Integer.parseInt(temporal[1].substring(0, 2));   // Extract end hour correctly
	            int endMin = Integer.parseInt(temporal[1].substring(2, 4));    // Extract end minutes correctly

	            Timeblock eatingTimeblock=new Timeblock();
	            eatingTimeblock.setTimeblock(startHour, startMin, endHour, endMin);

	            eating.getStartTimeOfMeals().add(eatingTimeblock);  
	            eating.getEndTimeOfMeals().add(eatingTimeblock);
	        }
	        //reserved time
	        print("Please indicate your dedicated times on the table! In this version, with the given format: 0900 1330 (means: from 9 a.m. till 1:30 p.m.). If done with one block, press enter, if done with each, press Q"); //here:numbers, later: visual
	        while (true) {
	        	print("Timeframe: ");
	            String input = scan.nextLine().trim();

	            if (input.equalsIgnoreCase("Q")) {
	                break;
	            }

	            if (input.isEmpty()) {
	                continue;
	            }

	            String[] temporal = input.split(" ");
	            if (temporal.length < 2 || temporal[0].length() < 4 || temporal[1].length() < 4) {
	                System.out.println("Invalid input format. Please try again.");
	                continue;
	            }

	            int startHour = Integer.parseInt(temporal[0].substring(0, 2));
	            int startMin = Integer.parseInt(temporal[0].substring(2, 4));

	            int endHour = Integer.parseInt(temporal[1].substring(0, 2));
	            int endMin = Integer.parseInt(temporal[1].substring(2, 4));

	            Timeblock timeblockReserved = new Timeblock();
	            timeblockReserved.setTimeblock(startHour, startMin, endHour, endMin);

	            System.out.println("Now, please give a name to this activity: ");
	            timeblockReserved.setName(scan.nextLine());

	            ReservedTime.setReservedTimes(timeblockReserved);
	        }
	        
		
		
		//generating tasks and printing them
	        print("Now let's move on to your other activities, what you would like to implement into your schedule.");
	        print("Enter the details of the activities, then press Q. If you want to start, press enter!");

	        while (true) {
	            Task task = new Task();

	            System.out.print("What is the name of this activity? ");
	            String name = scan.nextLine();
	            if (name.equalsIgnoreCase("Q")) {
	                break;
	            }
	            task.setName(name);

	            print("How many hours would you like to spend on this activity per week? ");
	            int times = scan.nextInt();
	            task.setTimes(times);
	            scan.nextLine(); // Consume newline

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
	            task.setType(type);

	            print("What part of the day do you prefer to do it? Please enter dawn, morning, afternoon, evening, or night!");
	            String daytimeInput = scan.nextLine().toUpperCase();
	            DAYTIME daytime = null;
	            switch (daytimeInput) {
	                case "DAWN":
	                    daytime = DAYTIME.DAWN;
	                    break;
	                case "MORNING":
	                    daytime = DAYTIME.MORNING;
	                    break;
	                case "AFTERNOON":
	                    daytime = DAYTIME.AFTERNOON;
	                    break;
	                case "EVENING":
	                    daytime = DAYTIME.EVENING;
	                    break;
	                case "NIGHT":
	                    daytime = DAYTIME.NIGHT;
	                    break;
	                default:
	                    print("Unknown daytime. Please enter dawn, morning, afternoon, evening, or night!");
	                    continue;
	            }
	            task.setDaytime(daytime);

	            taskList.add(task);
	        }
	        
	        //organizing tasks according to importance
	        print("Now, please organise your activities, according to their importance, where the first is the most important, and the last is the least important. Please separate the activities with a space.");
	        print("For reminder: Your activities were these: ");
	        for(Task task:taskList)
	        {
	        	if(!task.isSleep()) {
	        		System.out.print(task+" ");
	        	}
	        	
	        }
	        
	        String[] temporal=scan.nextLine().split(" ");
	        ArrayList<Task> orderedTaskList=new ArrayList<Task>();
	        for(Task task:taskList)
	        {
	        	for(String input:temporal) {
	        		if(task.name.equals(input)) {
	        			orderedTaskList.add(task);
	        		}
	        	}
	        }
	        
	        //printing tasks to UserData.txt
	        try {
	            FileWriter writer = new FileWriter("UserData.txt");
	            for (Task task : orderedTaskList) {
	                writer.append(task.getName() + ": " + task.getTimes() + " hours/week, " +
	                              task.getType().name() + " type of activity, preferred daytime: " +
	                              task.getDaytime().name() + "\n");
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	scan.close();
	}

	public static void print(String print)
	{
	System.out.println(print);
	}

}
