package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void clear() {
		itemsOrdered.clear();
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Added " + media.getTitle() + " to cart.");
		} else {
			System.out.println("The cart is full.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed " + media.getTitle() + " from cart.");
		} else {
			System.out.println(media.getTitle() + " not found in cart.");
		}
	}

	public float totalCost() {
		return itemsOrdered.stream().map(Media::getCost).reduce(0f, Float::sum);
	}

	public void print() {
		List<String> cartPrint = new LinkedList<>();
		cartPrint.add("Ordered Items:");
		int maxPrintLength = 0;
		for (Media media : itemsOrdered) {
			if (media != null) {
				maxPrintLength = Math.max(maxPrintLength, media.toString().length());
				cartPrint.add(media.toString());
			}
		}
		maxPrintLength = Math.max(maxPrintLength, 4);
		int halfPrintLength = (maxPrintLength - 4) / 2;
		cartPrint.add("Total cost: " + totalCost());
		cartPrint.addFirst("*".repeat(halfPrintLength) + "CART" + "*".repeat(maxPrintLength - 4 - halfPrintLength));
		cartPrint.add("*".repeat(maxPrintLength));

		System.out.println(String.join("\n", cartPrint));
	}

	public Media searchByTitle(String title) {
		return itemsOrdered
				.stream()
				.filter(m -> m.getTitle().equals(title))
				.findFirst().orElse(null);
	}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
}
