// Example 2.2.6 part 3: Second-degree equation with one variable solver

import javax.swing.JOptionPane;

public class SecondDegEqSolver {
    public static void main(String[] args) {
        String strA, strB, strC;
        String strNotification = "Your second-degree equation with one variable is: ";

        strA = JOptionPane.showInputDialog(null,
                "Please input value of a: ", "Input value of a",
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);

        strB = JOptionPane.showInputDialog(null,
                "Please input value of b: ", "Input value of b",
                JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strB);

        strC = JOptionPane.showInputDialog(null,
                "Please input value of c: ", "Input value of c",
                JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(strC);

        strNotification += strA + "x^2 + " + strB + "x + " + strC + " = 0\n";

        if (a == 0) {
            if (b == 0 && c == 0) {strNotification += "All x satisfies.";}
            else if (b == 0) {strNotification += "No x satisfies.";}
            else {
                double x = -c / b;
                strNotification += "Solution is " + x;
            }
        } else {
            double D = Math.pow(b, 2) - 4 * a * c;
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            if (x1 == x2) {
                strNotification += "Solution is double root " + x1;
            } else if (Double.isNaN(x1)) {
                strNotification += "Solution is not real.";
            } else {
                strNotification += "Solutions are " + x1 + " and " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, strNotification,
                "Second-degree one-variable solver", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
