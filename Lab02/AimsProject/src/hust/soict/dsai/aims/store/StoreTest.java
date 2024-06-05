package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("LOTR");
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Doraemon");
        store.addMedia(dvd2);

        store.print();

        store.removeMedia(dvd1);
        store.removeMedia(new DigitalVideoDisc("Man"));
    }
}
