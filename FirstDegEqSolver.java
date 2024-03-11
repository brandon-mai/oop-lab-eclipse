// Example 2.2.6 part 1: First-degree equation with one variable solver

import javax.swing.JOptionPane;

public class FirstDegEqSolver {
    public static void main(String[] args) {
        String strA, strB;
        String strNotification = "Your first-degree equation with one variable is: ";

        strA = JOptionPane.showInputDialog(null,
                "Please input value of a: ", "Input value of a",
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);

        strB = JOptionPane.showInputDialog(null,
                "Please input value of b: ", "Input value of b",
                JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strB);

        strNotification += strA + "x + " + strB + " = 0\n";

        if (a == 0) {
            if (b == 0) {strNotification += "All x satisfies.";}
            else {strNotification += "No x satisfies.";}
        } else {
            double x = -b / a;
            strNotification += "x is " + x;
        }

        JOptionPane.showMessageDialog(null, strNotification,
                "First-degree one-variable solver", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
