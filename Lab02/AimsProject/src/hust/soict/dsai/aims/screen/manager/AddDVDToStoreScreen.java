package Lab02.AimsProject.src.hust.soict.dsai.aims.screen.manager;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    JTextField titleField;

    public AddDVDToStoreScreen(StoreManagerScreen storeManagerScreen) {
        super(storeManagerScreen);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        ButtonListener btnListener = new ButtonListener();

        JLabel titleLabel = new JLabel("Title of the DVD:");
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
        storeManagerScreen.store.addMedia(new DigitalVideoDisc(titleField.getText()));
    }
}
