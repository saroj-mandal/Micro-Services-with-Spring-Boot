package com.github.sarojmandal.jpahibernate.entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Solution {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(4);

		Runnable r1 = () -> {
			System.out.println("Inside r1");
			try {
				TimeUnit.SECONDS.sleep(2);
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable r2 = () -> {
			System.out.println("Inside r2");
			try {
				TimeUnit.SECONDS.sleep(2);
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// allPassed = false;
			// throw new RuntimeException("Exception thrown");
		};
		Runnable r3 = () -> {
			System.out.println("Inside r3");
			try {
				TimeUnit.SECONDS.sleep(2);
				//System.out.println(1 / 0);
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable r4 = () -> {
			System.out.println("Start r4");
			ExecutorService executor = Executors.newFixedThreadPool(3);
			executor.submit(r1);
			executor.submit(r2);
			executor.submit(r3);
			executor.shutdown();
			try {
				cb.await(12, TimeUnit.SECONDS);
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Waiting for termination");
				executor.awaitTermination(100, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (!cb.isBroken()) {
				System.out.println("Inside r4");
			} else {
				System.out.println("Error occured can't execute r4");
			}
		};

		new Thread(r4).start();

	}
}