// Exercise 6.4: Display number of days of inputed year and month

//package OtherProjects.Lab01.NumberOfDays.src;

import java.util.Scanner;

public class NumberOfDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter year:");
		String strYear = sc.nextLine();
		int year = Integer.parseInt(strYear);
		while (year <= 0) {
			System.out.println("Enter a VALID year:");
			year = sc.nextInt();
		}
		boolean isLeap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		int numDay = 0;

		System.out.println("Enter month:");
		String month = sc.nextLine();
		boolean invalidMonth = true;

		while (invalidMonth) {
			invalidMonth = false;
			switch (month) {
				case "January":
				case "Jan.":
				case "Jan":
				case "1":
				case "March":
				case "Mar.":
				case "Mar":
				case "3":
				case "May":
				case "5":
				case "July":
				case "Jul":
				case "7":
				case "August":
				case "Aug.":
				case "Aug":
				case "8":
				case "October":
				case "Oct.":
				case "Oct":
				case "10":
				case "December":
				case "Dec.":
				case "Dec":
				case "12":
					numDay = 31;
					break;
				case "April":
				case "Apr.":
				case "Apr":
				case "4":
				case "June":
				case "Jun":
				case "6":
				case "September":
				case "Sept.":
				case "Sep":
				case "9":
				case "November":
				case "Nov.":
				case "Nov":
				case "11":
					numDay = 30;
					break;
				case "February":
				case "Feb.":
				case "Feb":
				case "2":
					numDay = isLeap ? 29 : 28;
					break;
				default:
					System.out.println("Enter a VALID month:");
					month = sc.nextLine();
					invalidMonth = true;
			}
		}
		System.out.println("The month of the year you entered has " + numDay + " days");
	}

}
