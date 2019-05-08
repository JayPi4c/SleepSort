package com.JayPi4c;

public class SleepSortObject implements Runnable {

	private int value;
	private boolean isMax;
	private static int sleep = 500;

	/**
	 * 
	 * @param val Wert der dem Objekt zugewiesen werden soll
	 */
	public SleepSortObject(int val) {
		isMax = false;
		value = val;
		if (value == SleepSortMain.getMaxValue())
			isMax = true;
	}

	@Override
	public void run() {
		for (int i = 0; i < value; i++) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		SleepSortMain.setResult(SleepSortMain.getCurrentPos(), value);

		// System.out.println("jetzt muss: " + value + " ins array" + isMax);

		if (isMax)
			SleepSortMain.isFinished();

		Thread.currentThread().interrupt();

	}

	public static int getSleep() {
		return sleep;
	}

}