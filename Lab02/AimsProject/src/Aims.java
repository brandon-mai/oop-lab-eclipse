package Lab02.AimsProject.src;

public class Aims {

	public static void main(String[] args) {

		// Create a new cart
		Cart anOrder = new Cart();

		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		// Print total cost of the items in the cart
		System.out.println();
		System.out.println("The total cost is: " + anOrder.totalCost());

		// Remove a DVD from cart and recalculate the cost
		System.out.println();
		anOrder.removeDigitalVideoDisc(dvd3);
		System.out.println("The cost after removing dvd3 is: " + anOrder.totalCost());
	}

}
