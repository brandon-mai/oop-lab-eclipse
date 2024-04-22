package Lab02.AimsProject.src.hust.soict.dsai.aims.store;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.Arrays;

public class Store {
    DigitalVideoDisc[] itemsInStore;

    public void addDVD(DigitalVideoDisc disc) {
        if (itemsInStore == null) {
            itemsInStore = new DigitalVideoDisc[1];
            itemsInStore[0] = disc;
        } else {
            DigitalVideoDisc[] newItemsInStore = new DigitalVideoDisc[itemsInStore.length + 1];
            for (int i = 0; i < itemsInStore.length; i++) {
                newItemsInStore[i] = itemsInStore[i];
            }
            newItemsInStore[itemsInStore.length] = disc;
            itemsInStore = newItemsInStore;
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        if (itemsInStore != null) {
            DigitalVideoDisc[] temp = new DigitalVideoDisc[itemsInStore.length];
            int i = 0;
            for (DigitalVideoDisc storedDisc : itemsInStore) {
                if (storedDisc == disc) {
                    found = true;
                } else {
                    temp[i] = storedDisc;
                    i++;
                }
            }
            if (found) {
                itemsInStore = Arrays.copyOf(temp, itemsInStore.length - 1);
                System.out.println("Disc removed");
                return;
            }
        }
        System.out.println("Disc not found");
    }
}
