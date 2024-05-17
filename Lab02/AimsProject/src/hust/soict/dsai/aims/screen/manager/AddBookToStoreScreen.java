package Lab02.AimsProject.src.hust.soict.dsai.aims.screen.manager;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Book;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    JTextField titleField;

    public AddBookToStoreScreen(StoreManagerScreen storeManagerScreen) {
        super(storeManagerScreen);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        ButtonListener btnListener = new ButtonListener();

        // Create and enlarge a label for the title
        JLabel titleLabel = new JLabel("Title of the Book:");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create and enlarge a text field for the title input
        titleField = new JTextField(20);
        titleField.setFont(new Font(titleField.getFont().getName(), Font.PLAIN, 20));
        titleField.setMaximumSize(titleField.getPreferredSize());

        // Create 'cancel' and 'add' buttons
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(btnListener);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(btnListener);

        // Create a new panel for the buttons with FlowLayout set to center alignment
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);

        // Add the label, text field, and button panel to the center panel with spacing
        center.add(titleLabel);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(titleField);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(buttonPanel);

        return center;
    }

    @Override
    void addButtonAction() {
        storeManagerScreen.store.addMedia(new Book(titleField.getText()));
    }
}
