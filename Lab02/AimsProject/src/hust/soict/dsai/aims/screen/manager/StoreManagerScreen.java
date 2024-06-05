package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class StoreManagerScreen extends JFrame {
    protected Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        ButtonListener btnListener = new ButtonListener();
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store")
        {{
            addActionListener(btnListener);
        }});

        JMenu smUpdateStore = new JMenu("Update Store");
        List<JMenuItem> updateStoreItems = List.of(
                new JMenuItem("Add Book"),
                new JMenuItem("Add CD"),
                new JMenuItem("Add DVD")
        );
        for (JMenuItem item : updateStoreItems) {
            item.addActionListener(btnListener);
            smUpdateStore.add(item);
        }
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            try {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } catch (IndexOutOfBoundsException e) {
                center.add(new JPanel());
            }
        }

        return center;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            switch (button) {
                case "Play":
                    System.out.println("Playing...");
                    return;
                case "View store":
                    Arrays.stream(Window.getWindows()).forEach(Window::dispose);
                    new StoreManagerScreen(store);
                    return;
                case "Add Book":
                    new AddBookToStoreScreen(StoreManagerScreen.this);
                    break;
                case "Add CD":
                    new AddCDToStoreScreen(StoreManagerScreen.this);
                    break;
                case "Add DVD":
                    new AddDVDToStoreScreen(StoreManagerScreen.this);
                    break;
            }
            StoreManagerScreen.this.dispose();
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("Joan"));
        store.addMedia(new CompactDisc("Aladdin"));
        store.addMedia(new Book("Cars"));
        store.addMedia(new DigitalVideoDisc("Popeye"));

        new StoreManagerScreen(store);
    }
}
