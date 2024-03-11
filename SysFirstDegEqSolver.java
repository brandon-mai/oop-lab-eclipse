// Example 2.2.6 part 2: System of first-degree equations with two variables solver

import java.util.Scanner;

public class SysFirstDegEqSolver {
    public static void main(String[] args) {
        System.out.println("\n~~ System of first-degree equations with two variables solver ~~\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Each equation takes the form: ax1 + bx2 = c");

        System.out.println("Enter a1, b1, c1 separated by whitespace:");
        String line1 = scan.nextLine();
        String[] para1 = line1.trim().split("\\s+");

        System.out.println("Enter a2, b2, c2 separated by whitespace:");
        String line2 = scan.nextLine();
        String[] para2 = line2.trim().split("\\s+");

        double a1 = Double.parseDouble(para1[0]);
        double b1 = Double.parseDouble(para1[1]);
        double c1 = Double.parseDouble(para1[2]);
        double a2 = Double.parseDouble(para2[0]);
        double b2 = Double.parseDouble(para2[1]);
        double c2 = Double.parseDouble(para2[2]);

        System.out.println("\nYour system of equation is:");
        System.out.println(a1 + "x1 + " + b1 + "x2 = " + c1);
        System.out.println(a2 + "x1 + " + b2 + "x2 = " + c2);

        if (a1 / a2 == b1 / b2) {
            if (a1 / a2 == c1 / c2) {System.out.println("Infinite solution.");}
            else {System.out.println("No solution.");}
        } else {
            double D = a1 * b2 - a2 * b1;
            double D1 = b1 * c2 - b2 * c1;
            double D2 = c1 * a2 - c2 * a1;
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution is tuple (" + x1 + ", " + x2 + ")\n");
        }
    }
}
