package aims;

import java.util.ArrayList;

public class Cart {

    private static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.size() + 1 > MAX_NUMBERS_ORDERED) {
            System.out.println("----<!> The cart is almost full!----");
        } else {
            itemsOrdered.add(disc);
            System.out.println("----The disc \"" + disc.getTitle() + "\" has been added!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.size() == 0) {
            System.out.println("----<!> The cart is empty!----");
        } else {
            boolean fl = itemsOrdered.remove(disc);
            if (fl) {
                System.out.println("----The disc \"" + disc.getTitle() + "\" has been removed!");
            } else {
                System.out.println("----<!> This disc does not exist in the cart!----");
            }
        }
    }
    public void showOrder(int blank, String str) {
        int cBlank = blank - str.length();
        if (cBlank % 2 == 0) {
            for (int i = 1; i <= cBlank / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(str);
            for (int i = 1; i <= cBlank / 2; i++) {
                System.out.print(" ");
            }
        } else {
            for (int i = 1; i <= cBlank / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(str);
            for (int i = 1; i <= cBlank / 2 + 1; i++) {
                System.out.print(" ");
            }
        }
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            cost += itemsOrdered.get(i).getCost();
        }
        return ((int) (cost * 100)) / 100f;
    }
    public void displayCart() {
        if (itemsOrdered.size() == 0) {
            System.out.println("----The cart is empty!");
        } else {
            System.out.println("\n----Your Cart: ");
            System.out.println("|    |                _Title_                |      _Category_      |   _Director_   |    _Length_    |  _Cost_  |");
            for (int i = 0; i < itemsOrdered.size(); i++) {
                String order = String.valueOf(i + 1);
                showOrder(5, order);
                itemsOrdered.get(i).displayDVD();
            }
            System.out.print("==== Total");
            showOrder(16, String.valueOf(totalCost()));
            System.out.println("");
        }
    }
}
