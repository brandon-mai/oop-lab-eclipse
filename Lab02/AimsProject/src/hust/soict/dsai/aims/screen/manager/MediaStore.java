package Lab02.AimsProject.src.hust.soict.dsai.aims.screen.manager;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Media;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Play")) {
                // Create a new JDialog
                JDialog dialog = new JDialog();

                // Add a JLabel to the JDialog with the information you want to display
                dialog.add(new JLabel("Playing " + media.getTitle()));

                // Set the size of the JDialog
                dialog.setSize(200, 100);

                // Center the JDialog on the screen
                dialog.setLocationRelativeTo(null);

                // Make the JDialog visible
                dialog.setVisible(true);
            }
        }
    }
}
