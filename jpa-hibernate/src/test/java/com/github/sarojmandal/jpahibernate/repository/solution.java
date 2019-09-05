package com.github.sarojmandal.jpahibernate.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class solution {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("in.txt"));
		int t = sc.nextInt();
		for (int ti = 0; ti < t; ti++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			String[][] arr = new String[m][n];
			for (int ri = 0; ri < m; ri++) {
				for (int ci = 0; ci < n; ci++) {
					arr[ri][ci] = sc.next();
				}
			}
			findStreaks(arr, k);
		}
	}

	private static void findStreaks(String[][] arr, int streakLength) {
		int x = 0;
		int o = 0;
		int colx = 0;
		int colo = 0;
		int rowx = 0;
		int rowo = 0;
		int dig1x = 0;
		int dig1o = 0;
		int dig2x = 0;
		int dig2o = 0;
		int rowStart = 0;
		int colStart = 0;
		int squareCount = 0;
		while (rowStart >= 0 && colStart >= 0) {
			int tempRowCount = 0;
			boolean colMatch = true;
			boolean diagonal1match = true;
			boolean diagonal2match = true;
			for (int ri = rowStart; ri < arr.length; ri++, tempRowCount++) {
				if (tempRowCount >= streakLength) {
					break;
				}
				int tempColCount = 0;
				boolean rowMatch = true;
				for (int ci = colStart; ci < arr[ri].length; ci++, tempColCount++) {
					if (tempColCount >= streakLength) {
						break;
					}
					System.out.print(arr[ri][ci]);
					// find row streak match
					if (rowMatch && tempColCount > 0 && !arr[ri][ci - 1].equals(arr[ri][ci])) {
						rowMatch = false;
					}
					if (tempRowCount > 0) {
						// find Column streak match
						if (colMatch && !arr[ri - 1][colStart].equals(arr[ri][colStart])) {
							colMatch = false;
						}

						// find left diagonal streak match
						if (diagonal1match && tempColCount >= 1) {
							if (!arr[ri - 1][ci - 1].equals(arr[ri][ci])) {
								diagonal1match = false;
							}
						}

						// find right diagonal streak match
						if (diagonal2match && tempColCount == streakLength - tempRowCount - 1) {
							if (!arr[ri - 1][ci + 1].equals(arr[ri][ci])) {
								diagonal2match = false;
							}
						}

					}
				}
				if (rowMatch) {
					if (arr[ri][colStart].equals("x")) {
						rowx++;
						x++;
					} else if (arr[ri][colStart].equals("o")) {
						rowo++;
						o++;
					}
				}
				System.out.println();
			}
			if (colMatch) {
				if (arr[rowStart][colStart].equals("x")) {
					colx++;
					x++;
				} else if (arr[rowStart][colStart].equals("o")) {
					colo++;
					o++;
				}
			}
			if (diagonal1match) {
				if (arr[rowStart][colStart].equals("x")) {
					dig1x++;
					x++;
				} else if (arr[rowStart][colStart].equals("o")) {
					dig1o++;
					o++;
				}
			}
			if (diagonal2match) {
				if (arr[rowStart + streakLength - 1][colStart].equals("x")) {
					dig2x++;
					x++;
				} else if (arr[rowStart + streakLength - 1][colStart].equals("o")) {
					dig2o++;
					o++;
				}
			}
			System.out.println();
			System.out.println("rowx = " + rowx + ", rowo = " + rowo);
			System.out.println("colx = " + colx + ", colo = " + colo);
			System.out.println("dig1x = " + dig1x + ", dig1o = " + dig1o);
			System.out.println("dig2x = " + dig2x + ", dig2o = " + dig2o);
			squareCount++;
			if (squareCount == arr.length - streakLength + 1) {
				rowStart++;
				colStart = 0;
				squareCount = 0;
			} else {
				colStart++;
			}
			if (rowStart > arr.length - streakLength) {
				rowStart = -1;
			}
		}
		System.out.println((x > 0 ? x : "") + " " + (o > 0 ? o : ""));

	}
}