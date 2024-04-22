package Lab02.AimsProject.src.hust.soict.dsai.aims.cart;

import Lab02.AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full. Cannot add new disc.");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full.");
			} else {
				System.out.println("The disc has been added.");
			}
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc[] temp = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		int i = 0;
		for (DigitalVideoDisc orderedDisc : itemsOrdered) {
			if (orderedDisc == disc) {
				System.out.println("Removed disc.");
			} else {
				temp[i] = orderedDisc;
				i++;
			}
		}
		itemsOrdered = Arrays.copyOf(temp, MAX_NUMBERS_ORDERED);
		qtyOrdered--;
	}
	public float totalCost() {
		float cost = 0;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null) {
				cost += disc.getCost();
			}
        }
		return cost;
	}

	public void print() {
		List<String> cartPrint = new LinkedList<>();
		cartPrint.add("Ordered Items:");
		int maxPrintLength = 0;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null) {
				maxPrintLength = Math.max(maxPrintLength, disc.toString().length());
				cartPrint.add(disc.toString());
			}
		}
		int halfPrintLength = (maxPrintLength - 4) / 2;
		cartPrint.add("Total cost: " + totalCost());
		cartPrint.addFirst("*".repeat(halfPrintLength) + "CART" + "*".repeat(maxPrintLength - 4 - halfPrintLength));
		cartPrint.add("*".repeat(maxPrintLength));

		System.out.println(String.join("\n", cartPrint));
	}

	public DigitalVideoDisc searchByTitle(String title) {
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null && disc.isMatch(title)) {
				return disc;
			}
		}
		System.out.println("DVD titled " + title + ": No match is found.");
		return null;
	}
}
