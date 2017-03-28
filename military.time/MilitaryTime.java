import java.util.*;

/** 
 * The MilitaryTime class calculates the largest possible military time 
 * given four integers n, such that n is non-negative and less than ten.
*/

public class MilitaryTime {
	final static String invalid = "Not Possible";
	List<Integer> table = new ArrayList<Integer>(); 

	/** Constructor if using comman line */
	public MilitaryTime(String[] args) {
		for (String number : args) {
			try {
				table.add(Integer.parseInt(number));
			} catch (NumberFormatException e) {
				System.out.println("Must use intergers.");
				System.exit(0);
			}
		}
		Collections.sort(table);
		StringBuilder sb = new StringBuilder();
		sb.append("Sorted numbers: ");
		for (int num : table) {
			sb.append(num);
		}
		System.out.println(sb);
	}

	/** Constructor if using scanner */
	public MilitaryTime(int a, int b, int c, int d) {
		table.add(a);
		table.add(b);
		table.add(c);
		table.add(d);
		Collections.sort(table);
		StringBuilder sb = new StringBuilder();
		for (int num : table) {
			sb.append(num);
		}
		System.out.println(sb);
	}
	
	/** Finds valid first digit then calls helper function
		to find second digit */
	public String getTime() {
		if (!checkIfValidTimePossible()) {
			return invalid;
		}		
		int firstDigit;
		if (table.contains(2) && checkIfTwoPossible()) {
			firstDigit = 2;	
		} else if (table.contains(1)) {
			firstDigit = 1;
		} else {
			firstDigit = 0;
		}
		table.remove(table.indexOf(firstDigit));
		return (Integer.toString(firstDigit) + findSecondDigit(firstDigit));
	}

	/** Finds valid second digit then calls helper function
		to find last two digits */
	public String findSecondDigit(int i) {
		int secondDigit = -1;
		if (i==2) {	
			for (int num : table) {
				if (num < 4) {
					secondDigit = num;
				}
			}
			table.remove(table.indexOf(secondDigit));
		} else {
			secondDigit = table.get(table.size()-1);
			table.remove(table.size()-1);
		}
		return (Integer.toString(secondDigit) + findLastTwoDigits());
	}
	/** Finds valid combination for last two digits */
	public String findLastTwoDigits() {
		if (table.get(1) < 6){
			return (":" + Integer.toString(table.get(1)) + Integer.toString(table.get(0)));
		} else {
			return (":" + Integer.toString(table.get(0)) + Integer.toString(table.get(1)));
		}
	}

	/** Basic check to see if any time from 00:00 to 23:59
		can be constructed */
	public boolean checkIfValidTimePossible() {
		if (table.get(0)>2 || table.get(0)<0) {
			return false;
		} else if (table.get(0)==2 && (table.get(1)>3 || table.get(2)>5)) {
			return false;
		} else if (table.get(0)<2 && table.get(1)>5) {
			return false;
		} else {
			return true;
		}
	}

	/** Additional check to see if any time from 20:00 to 23:59
		can be constructed 
		
		This check is intended for examples such as 1249, where 
		a valid time of 19:42 exists, but a better time of 21:49
		can be made
		*/
	public boolean checkIfTwoPossible() {
		int index = table.indexOf(2);
		// if (table.get((index+1)%4) > 3 || table.get((index+2)%4) > 5) {
		if (index == 1 && table.get((index+1)%4) > 5) {
			return false;
		} else {
			return true;
		} 
	}

	/** Use of command line to get arguments but scanner implemention
		below is also shown */
	public static void main(String[] args) {	

		MilitaryTime time = new MilitaryTime(args);
		System.out.println(time.getTime());

		// Scanner reader = new Scanner(System.in);
		// while(true) {
		// 	int a = Integer.parseInt(reader.nextLine());
		// 	int b = Integer.parseInt(reader.nextLine());
		// 	int c = Integer.parseInt(reader.nextLine());
		// 	int d = Integer.parseInt(reader.nextLine());
		// 	MilitaryTime time = new MilitaryTime(a,b,c,d);
		// 	System.out.println(time.getTime());
		// 	System.out.println("Again?");
		// 	if (reader.nextLine().equals("exit")) {
		// 		System.exit(0);
		// 	}
		// }
	}
}