package Lab02.AimsProject.src.hust.soict.dsai.aims;

import Lab02.AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import Lab02.AimsProject.src.hust.soict.dsai.aims.media.*;
import Lab02.AimsProject.src.hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
	public static void showMenu(Store store, Cart cart) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean backed;

		do {
			System.out.println("\nAIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");

			choice = Integer.parseInt(scanner.nextLine());
			backed = false;

			while (choice != 0 && !backed) {
				switch (choice) {
					case 1:
						store.print();
						storeMenu(store, cart);
						backed = true;
						break;
					case 2:
						System.out.println("Confirm store update operation? (A)dd/(R)emove");
						String option = scanner.nextLine();
						if (option.equalsIgnoreCase("A")) {
							System.out.println("Enter the title of the media to be added: ");
							String title = scanner.nextLine();
							System.out.println("Enter the type of media to be added: (B)ook/(C)D/(D)VD");
							String mediaType = scanner.nextLine();
							if (mediaType.equalsIgnoreCase("B")) {
								store.addMedia(new Book(title));
							} else if (mediaType.equalsIgnoreCase("C")) {
								store.addMedia(new CompactDisc(title));
							} else if (mediaType.equalsIgnoreCase("D")) {
								store.addMedia(new DigitalVideoDisc(title));
							} else {
								System.out.println("Invalid media type.");
							}
						} else if (option.equalsIgnoreCase("R")) {
							System.out.println("Enter the title of the media to be removed: ");
							Media mediaToRemove = store.searchByTitle(scanner.nextLine());
							if (mediaToRemove != null) {
								store.removeMedia(mediaToRemove);
							} else {
								System.out.println("Media not found.");
							}
						} else {
							System.out.println("Invalid option.");
						}
						backed = true;
						break;
					case 3:
						cart.print();
						cartMenu(cart);
						backed = true;
						break;
					default:
						System.out.println("Invalid choice. Please choose again.");
						choice = Integer.parseInt(scanner.nextLine());
						break;
				}
			}
		} while (backed);
		System.out.println("Exiting...");
	}

	public static void storeMenu(Store store, Cart cart) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean backed;

		do {
			System.out.println("\nOptions: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");

			choice = Integer.parseInt(scanner.nextLine());
			backed = false;

			while (choice != 0 && !backed) {
				switch (choice) {
					case 1:
						System.out.println("Enter the title of the media to be viewed: ");
						Media mediaToView = store.searchByTitle(scanner.nextLine());
						if (mediaToView != null) {
							System.out.println(mediaToView);
							mediaDetailsMenu(mediaToView, cart);
						} else {
							System.out.println("Media not found.");
						}
						backed = true;
						break;
					case 2:
						System.out.println("Enter the title of the media to be added: ");
						Media mediaToAdd = store.searchByTitle(scanner.nextLine());
						if (mediaToAdd != null) {
							cart.addMedia(mediaToAdd);
							System.out.println("Cart is holding " + cart.getItemsOrdered().size() + " items.");
						} else {
							System.out.println("Media not found.");
						}
						backed = true;
						break;
					case 3:
						System.out.println("Enter the title of the media to be played: ");
						Media mediaToPlay = store.searchByTitle(scanner.nextLine());
						if (mediaToPlay instanceof Playable) {
							((Playable) mediaToPlay).play();
						} else if (mediaToPlay != null) {
							System.out.println("Media is not playable.");
						} else {
							System.out.println("Media not found.");
						}
						backed = true;
						break;
					case 4:
						cart.print();
						cartMenu(cart);
						backed = true;
						break;
					default:
						System.out.println("Invalid choice. Please choose again.");
						choice = Integer.parseInt(scanner.nextLine());
						break;
				}
			}
		} while (backed);
	}

	public static void mediaDetailsMenu(Media media, Cart cart) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean backed;
		boolean isPlayable = media instanceof Playable;

		do {
			System.out.println("\nOptions: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			if (isPlayable) {
				System.out.println("2. Play");
			}
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1" + (isPlayable ? "-2" : ""));

			choice = Integer.parseInt(scanner.nextLine());
			backed = false;

			while (choice != 0 && !backed) {
				switch (choice) {
					case 1:
						cart.addMedia(media);
						System.out.println("Cart is holding " + cart.getItemsOrdered().size() + " items.");
						backed = true;
						break;
					case 2:
						if (isPlayable) {
							((Playable) media).play();
							backed = true;
							break;
						}
					default:
						System.out.println("Invalid choice. Please choose again.");
						choice = Integer.parseInt(scanner.nextLine());
						break;
				}
			}
		} while (backed);
	}

	public static void cartMenu(Cart cart) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean backed;

		do {
			System.out.println("\nOptions: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter media in cart");
			System.out.println("2. Sort media in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");

			choice = Integer.parseInt(scanner.nextLine());
			backed = false;

			while (choice != 0 && !backed) {
				switch (choice) {
					case 1:
						System.out.println("Confirm filtering option? (I)d/(T)itle");
						String filterOption = scanner.nextLine();
						if (filterOption.equalsIgnoreCase("I")) {
							System.out.println("Filtering option in development.");
						} else if (filterOption.equalsIgnoreCase("T")) {
							System.out.println("Filtering option in development.");
						} else {
							System.out.println("Invalid option.");
						}
						backed = true;
						break;
					case 2:
						System.out.println("Confirm sorting preference? (C)ost/(T)itle");
						String sortOption = scanner.nextLine();
						if (sortOption.equalsIgnoreCase("C")) {
							cart.sortByCostTitle();
						} else if (sortOption.equalsIgnoreCase("T")) {
							cart.sortByTitleCost();
						} else {
							System.out.println("Invalid option.");
						}
						backed = true;
						break;
					case 3:
						System.out.println("Enter the title of the media to be removed: ");
						Media mediaToRemove = cart.searchByTitle(scanner.nextLine());
						if (mediaToRemove != null) {
							cart.removeMedia(mediaToRemove);
						} else {
							System.out.println("Media not found.");
						}
						backed = true;
						break;
					case 4:
						System.out.println("Enter the title of the media to be played: ");
						Media mediaToPlay = cart.searchByTitle(scanner.nextLine());
						if (mediaToPlay instanceof Playable) {
							((Playable) mediaToPlay).play();
						} else if (mediaToPlay != null) {
							System.out.println("Media is not playable.");
						} else {
							System.out.println("Media not found.");
						}
						backed = true;
						break;
					case 5:
						System.out.println("Order created. Cart is now empty.");
						cart.clear();
						backed = true;
						break;
					default:
						System.out.println("Invalid choice. Please choose again.");
						choice = Integer.parseInt(scanner.nextLine());
						break;
				}
			}
		} while (backed);
	}

	public static void main(String[] args) {

		// Create a new cart
		Cart anOrder = new Cart();
		Store store = new Store();

		Aims.showMenu(store, anOrder);
	}

}
