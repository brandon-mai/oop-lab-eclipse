package Lab02.AimsProject.src.hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public abstract class AddItemToStoreScreen extends JFrame {
    StoreManagerScreen storeManagerScreen;
    public AddItemToStoreScreen(StoreManagerScreen storeManagerScreen) {
        this.storeManagerScreen = storeManagerScreen;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(storeManagerScreen.createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Item to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    abstract JPanel createCenter();

    abstract void addButtonAction();

    protected class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add")) {
                addButtonAction();
            }
            dispose();
            new StoreManagerScreen(storeManagerScreen.store);
        }
    }
}
