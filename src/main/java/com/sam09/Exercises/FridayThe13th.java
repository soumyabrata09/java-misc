/*
 *
 * Given the month and year as numbers, check whether that month contains a 'Friday 13th'.
	Constraints:
	1.	January will be given as 1, February as 2, etc ...
	2.	Check Resources for some helpful tutorials on Python's datetime module.
	Input Format
	Two integer value of month & year
	Output Format
	Print 'True' if that month contains a 'Friday 13th' on the given year, otherwise print 'False'
	Sample Input 1
	3, 2020
	Sample Output 1
	True
	Sample Input 2
	10, 2017
	Sample Output 2
	True
	Sample Input 3
	1, 1985
	Sample Output 3
	False

 *
 */
package com.sam09.Exercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * @author soumyabrata
 *
 */
public class FridayThe13th {

	/*
	 * @param args for command line argument
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Month and Year : " );
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		
		String dateStr = month>=10 ? "13/"+month+"/"+year : "13/"+"0"+month+"/"+year; // constructing 13th of the given month and year 
		// Above adjustment is done in case of starting months 1~9 date should be created as 13/03/2020 if input is 3 and 2020[sample]
		System.out.println("DateStr : " + dateStr);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = simpleDateFormat.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			//checking for Friday , 6th day of the Week Alternate approach could be instead of specifying integer value Calendar.FRIDAY can also be used
			System.out.println("Output : " + Boolean.TRUE);
		}
		else {
			System.out.println("Output : " + Boolean.FALSE);
		}
	}

}
