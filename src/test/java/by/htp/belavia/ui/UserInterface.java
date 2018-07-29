package by.htp.belavia.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.belavia.scanner.ScannerSingleton;
import by.htp.belavia.tests.InfoTest;

public class UserInterface {
	private static Scanner scanner = ScannerSingleton.getScanner();

	public static void run() {
		userInterraction();
	}

	private static void userInterraction() {
		int choice = 0;
		boolean repeat = true;
		while (repeat) {
			System.out.println("MAIN MENU\n " + "Choose a FLIGHT:\n 1 - ONE WAY\n 2 - RETURN\n 0 - EXIT APP");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0;
			}

			if (choice == 1) {
				repeat = oneWayTicket();
			} else if (choice == 2) {
				repeat = ReturnTicket();
			} else {
				scanner.close();
				System.out.println("I HOPE TO SEE YOU SOON!");
				break;
			}

		}
	}

	private static boolean oneWayTicket() {
		int choice = 0;
		int sorting = 0;
		boolean repeat = true;
		while (true) {
			System.out.println("ONE WAY FLIGHT\n "
					+ "Choose sorting:\n 1 - BY PRICE\n 2 - BY DEPARTURE DATE\n 0 - go to MAIN MENU");

			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0;
			}

			if (choice == 1) {
				sorting = 0;
				repeat = oneWaySteps(sorting);
				break;
			} else if (choice == 2) {
				sorting = 1;
				repeat = oneWaySteps(sorting);
				break;
			} else {
				break;
			}
		}
		return repeat;

	}

	private static boolean ReturnTicket() {
		int choice = 0;
		int sorting = 0;
		boolean repeat = true;
		while (true) {
			System.out.println("RETURN FLIGHT\n "
					+ "Choose sorting:\n 1 - BY PRICE\n 2 - BY DEPARTURE DATE\n 3 - BY RETURN DATE\n 0 - go to MAIN MENU");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0;
			}

			if (choice == 1) {
				sorting = 0;
				repeat = returnSteps(sorting);
				break;
			} else if (choice == 2) {
				sorting = 1;
				repeat = returnSteps(sorting);
				break;
			} else if (choice == 3) {
				sorting = 2;
				repeat = returnSteps(sorting);
				break;
			} else {
				break;
			}
		}
		return repeat;

	}

	private static boolean oneWaySteps(int sorting) {
		InfoTest infoTest = new InfoTest();
		infoTest.initDriver();
		infoTest.OneWayInfoTest(sorting);
		infoTest.stopDriver();
		return false;
	}

	private static boolean returnSteps(int sorting) {
		InfoTest infoTest = new InfoTest();
		infoTest.initDriver();
		infoTest.ReturnInfoTest(sorting);
		infoTest.stopDriver();
		return false;
	}

}
