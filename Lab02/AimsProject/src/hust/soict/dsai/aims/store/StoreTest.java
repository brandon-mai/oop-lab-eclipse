package Lab02.AimsProject.src.hust.soict.dsai.aims.store;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("LOTR");
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Doraemon");
        store.addDVD(dvd2);

        store.removeDVD(dvd1);
        store.removeDVD(new DigitalVideoDisc("Man"));
    }
}
