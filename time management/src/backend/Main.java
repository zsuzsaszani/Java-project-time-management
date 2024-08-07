package backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Please enter the list of the areas you would like to concentrate on then press Q");
		Scanner scan=new Scanner(System.in);
		ArrayList<String> areas=new ArrayList<String>();
		while(!scan.equals("Q") || scan.equals("q")) //possible problem!
		{
			areas.add(scan.nextLine());
		}
		
		*/
		//welcome
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome to your new scheduling application! Let me give you a short introduction...");
		//reading intro
		try {
			FileReader reader=new FileReader("intro.txt");
			int readerData=reader.read();
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException f) {f.printStackTrace();}
		
		
		//questions/user input
		System.out.println("Let's start with a few details about you and your habbits.");
		
		//sleeping
		System.out.println("First, let's talk about your sleeping routine.");
		System.out.println("Do you prefer monophasic or poliphasic sleep? Please type the answer: ");
		String polisleep=scan.nextLine().toUpperCase();
		Passive sleep=new Passive();
		ArrayList<Passive> listPassive=new ArrayList<Passive>();
		if(polisleep.equals("POLIPHASIC")) {sleep.setPolisleep(true);}
		else{sleep.setPolisleep(false);}
		sleep.name="sleep";
		sleep.setSleep(true);
		
		if(sleep.getPolisleep()) {
			System.out.println("How much phase do you sleep in?(Please enter in number, not with words!)");
			sleep.setNumberOfSleeps(scan.nextInt());

			
			System.out.println("How long are these sessions on average(measured in hours)?");
			sleep.setLengthOfSleep(scan.nextInt());
		}
		else {
			sleep.setNumberOfSleeps(1);
			System.out.println("How much do you sleep a day on average(measured in hours)?");
			sleep.setLengthOfSleep(scan.nextInt());
		}
		listPassive.add(sleep);
		
		//eating
		
		Passive eating=new Passive();
		 System.out.println("Let's move on to your eating habits.");
	        System.out.println("How many times do you eat a day?");
	        eating.setNumberOfMeals(scan.nextInt());
	        scan.nextLine();  // Consume newline left-over

	        for (int i = 0; i < eating.getNumberOfMeals(); i++) {
	            System.out.printf("Please describe the time-range in which you have your %d. meal. Please use this format: 1800 2200 (from 6 pm. till 10 pm.)\n", i + 1);
	            String temporal[] = scan.nextLine().split(" ");
	            
	            int startTime = Integer.parseInt(temporal[0]);
	            int endTime = Integer.parseInt(temporal[1]);

	            eating.getStartTimeOfMeals().add(startTime);
	            eating.getEndTimeOfMeals().add(endTime);
	        }
		
		
		
	}



}
