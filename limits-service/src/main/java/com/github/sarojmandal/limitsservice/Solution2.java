package com.github.sarojmandal.limitsservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("input.txt"));
		int t = sc.nextInt();
		for (int n = 0; n < t; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String line = sc.next();
			String[] firstArr = line.split("");
			int germCount = 0;
			for (int i = 1; i < a; i++) {
				line = sc.next();
				String[] secondArr = line.split("");
				for (int j = 0; j < b; j++) {
					if (firstArr[j].equals("r")) {
						if (secondArr[j].equals("x")) {
							secondArr[j] = "o";
						}
						if (j + 1 < b && secondArr[j + 1].equals("x")) {
							secondArr[j + 1] = "o";
						}
						if (j - 1 > 0 && secondArr[j - 1].equals("x")) {
							secondArr[j - 1] = "o";
						}
						if (j + 1 < b && firstArr[j + 1].equals("x")) {
							firstArr[j + 1] = "o";
						}
					} else if (firstArr[j].equals("b")) {
						if (secondArr[j].equals("x")) {
							secondArr[j] = "o";
						}
						if (j + 1 < b && firstArr[j + 1].equals("x")) {
							firstArr[j + 1] = "o";
						}
					} else if (firstArr[j].equals("x")) {
						if (((j + 1 < b && !secondArr[j + 1].equals("r")) || j + 1 == b) && secondArr[j].equals("x")
								&& (j + 1 == b || (j + 1 < b
										&& (firstArr[j + 1].equals("x") || firstArr[j + 1].equals("o"))))) {
							germCount++;
						} else {
							firstArr[j] = "o";
						}
						if (secondArr[j].equals("r") && j + 1 < b && firstArr[j + 1].equals("x")) {
							firstArr[j + 1] = "o";
						}
					}
				}
				System.out.println(Arrays.asList(firstArr));
				firstArr = secondArr;
			}
			System.out.println(Arrays.asList(firstArr));
			for (int i = 0; i < firstArr.length; i++) {
				if (firstArr[i].equals("x")) {
					germCount++;
				}
			}
			System.out.println(germCount);
		}

	}
}