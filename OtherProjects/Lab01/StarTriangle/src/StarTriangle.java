// Exercise 6.3: Draw an isosceles triangle from stars with entered height

import java.util.Scanner;

public class StarTriangle {

	public static void main(String[] args) {
		System.out.println("Height of star triangle: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			char[] line = new char[2*n-1];
			for (int j = 0; j < 2*n-1; j++) {
				if (j > n-1-i && j < n-1+i) {
					line[j] = '*';
				} else {
					line[j] = ' ';
				}
			}
			System.out.println(line);
		}
	}
	
}
