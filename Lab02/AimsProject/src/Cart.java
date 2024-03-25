package Lab02.AimsProject.src;
import java.util.Arrays;

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
}
