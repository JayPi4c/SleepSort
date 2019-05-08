package com.JayPi4c;

import java.util.concurrent.CountDownLatch;

public class SleepSort {

	public static void SleepSortAndPrint(int[] nums) {
		final CountDownLatch doneSignal = new CountDownLatch(nums.length);

		for (final int num : nums) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					doneSignal.countDown();
					try {
						Thread.sleep(num * 1000);
						System.out.println(num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}

}