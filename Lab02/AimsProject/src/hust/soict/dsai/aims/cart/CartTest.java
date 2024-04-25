package Lab02.AimsProject.src.hust.soict.dsai.aims.cart;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Book;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "Georgey Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation",18.99f);
        cart.addMedia(dvd3);

        // Test the print method
        cart.print();

        // Test the search method
        System.out.println(cart.searchByTitle("Adalin"));

        // Test the toString methods
        List<Media> mediae = new ArrayList<>();

        mediae.add(new CompactDisc("Disch"));
        mediae.add(new DigitalVideoDisc("Whaet"));
        mediae.add(new Book("Boob"));

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
