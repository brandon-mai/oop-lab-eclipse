package Lab02.AimsProject.src.hust.soict.dsai.aims.store;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Store {
    private final List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added " + media.getTitle() + " to store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed " + media.getTitle() + " from store.");
        } else {
            System.out.println(media.getTitle() + " not found in store.");
        }
    }

    public void print() {
        List<String> storePrint = new LinkedList<>();
        storePrint.add("Store Items:");
        int maxPrintLength = 0;
        for (Media media : itemsInStore) {
            if (media != null) {
                maxPrintLength = Math.max(maxPrintLength, media.toString().length());
                storePrint.add(media.toString());
            }
        }
        maxPrintLength = Math.max(maxPrintLength, 5);
        int halfPrintLength = (maxPrintLength - 5) / 2;
        storePrint.addFirst("*".repeat(halfPrintLength) + "STORE" + "*".repeat(maxPrintLength - 5 - halfPrintLength));
        storePrint.add("*".repeat(maxPrintLength));

        System.out.println(String.join("\n", storePrint));
    }

    public Media searchByTitle(String title) {
        return itemsInStore
                .stream()
                .filter(m -> m.getTitle().equals(title))
                .findFirst().orElse(null);
    }
}
