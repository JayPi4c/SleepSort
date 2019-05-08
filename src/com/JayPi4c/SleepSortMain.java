package com.JayPi4c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SleepSortMain {

	private static int currentPos;
	private static int[] array;
	private static Runnable[] SLO;
	public static int[] result;
	private static boolean finished = false;
	private static int maxVal;
	// private static String Input;

	private static double timeStart;
	private static double currentTime;

	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);
	private static Random random = new Random();

	public static void main(String args[]) throws IOException {

		int[] numbers = { 2, 6, 3, 11, 9, 2, 5, 1, 0, 8 };
		SleepSort.SleepSortAndPrint(numbers);

		currentPos = 0;

		System.out.println("wie viele Zahlen sollen sortiert werden?");
		array = new int[Integer.parseInt(br.readLine())];
		result = new int[array.length];
		SLO = new Runnable[array.length];

		/*
		 * System.out.println("User oder Random?"); do{ Input = br.readLine();
		 * System.out.println(Input); }while(!Input.equalsIgnoreCase("user") ||
		 * !Input.equalsIgnoreCase("random")); System.out.println("geschafft!");
		 * if(Input.equalsIgnoreCase("Random")) useRandom(10, 50); else useInput();
		 */

		// useInput();

		useRandom(10, 50);

		for (int i = 0; i < array.length; i++) {
			SLO[i] = new SleepSortObject(array[i]); // erschaffe neue Objekte und übergebe die Werte
		}

		for (Runnable slo : SLO) {
			new Thread(slo).start();
		}

		timeStart = System.currentTimeMillis();

		while (!finished) {
			currentTime = System.currentTimeMillis();
			System.out.println("läuft jetzt schon " + ((currentTime - timeStart) / 1000) + " Sekunden");
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println("Zahl: " + result[i]);
		}

		System.out.println("Runtime: " + ((currentTime - timeStart) / 1000) + " Sekunden!");
		System.out.println("SleepTime: " + SleepSortObject.getSleep() + " millis");
		System.out.println("Fertig!");

	}

	/**
	 * Fülle das Array mit Zahlen des Users
	 */
	/*
	 * private static void useInput()throws IOException{ for(int i = 0; i <
	 * array.length; i++){ System.out.println("Bitte gebe nun eine Zahl ein!"); int
	 * input = Integer.parseInt(br.readLine()); array[i] = input; //fülle das Array
	 * mit Zahlen, die vom User kommen sollen if(input > maxVal) maxVal = input; } }
	 */

	/**
	 * Fülle das Array mit Random Zahlen
	 * 
	 * @param min minBounds für die Zufahlszahlen
	 * @param max maxBounds für die Zufahlszahlen
	 */
	private static void useRandom(int min, int max) {
		for (int i = 0; i < array.length; i++) {
			int input = random.nextInt(max - min) + min;
			array[i] = input;
			if (input > maxVal)
				maxVal = input;
		}
	}

	public static int getMaxValue() {
		return maxVal;
	}

	public static void isFinished() {
		// finished = true;
	}

	/**
	 * setzte den Wert des sortierten Arrays (result) an dem index auf den Wert
	 * value
	 * 
	 * @param index index an dem der Arraywert geändert werden soll
	 * @param value Wert, den das Array an der Stelle haben soll
	 */
	public static void setResult(int index, int value) {
		result[index] = value;
		updateCurrentPos();
	}

	/**
	 * 
	 * @return gibt die momentane index position des result arrays zurück
	 */
	public static int getCurrentPos() {
		return currentPos;
	}

	private static void updateCurrentPos() {
		currentPos++;
	}

}