package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    JTextField titleField;

    public AddCDToStoreScreen(StoreManagerScreen storeManagerScreen) {
        super(storeManagerScreen);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        ButtonListener btnListener = new ButtonListener();

        JLabel titleLabel = new JLabel("Title of the CD:");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titleField = new JTextField(20);
        titleField.setFont(new Font(titleField.getFont().getName(), Font.PLAIN, 20));
        titleField.setMaximumSize(titleField.getPreferredSize());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(btnListener);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(btnListener);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);

        center.add(titleLabel);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(titleField);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(buttonPanel);

        return center;
    }

    @Override
    void addButtonAction() {
        storeManagerScreen.store.addMedia(new CompactDisc(titleField.getText()));
    }
}
