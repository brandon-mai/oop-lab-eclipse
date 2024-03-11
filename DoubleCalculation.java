// Example 5: DoubleCalculation.java

import javax.swing.JOptionPane;

public class DoubleCalculation {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first double",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ", "Input the second double",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        strNotification += strNum2 + "\n";

        strNotification += "Sum: " + (num1 + num2) + "\n";
        strNotification += "Difference: " + (num1 - num2) + "\n";
        strNotification += "Product: " + (num1 * num2) + "\n";
        strNotification += "Quotient: " + (num1 / num2);

        JOptionPane.showMessageDialog(null, strNotification,
                "Double calculations", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
