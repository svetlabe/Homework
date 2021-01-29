package no.dnb.OnlineRetailer;

// Menu to communicate with user
// practicing switch and do-while loop

public class Menu {

    public void menuStart() {
        Inventory inventory = new Inventory();
        int userChoice;
        System.out.println("\n WELCOME\n -------------------------");

        do {
            userChoice = User.getInt("\n What do you want to do? \n 1: Add product\n 2: Show product\n 3: Check stock \n 4: See the tax\n 5: Exit \n");
            switch (userChoice) {

                case 1:
                    inventory.addProduct();
                    break;

                case 2:
                    inventory.productToShow();
                    break;

                case 3:
                    inventory.checkStock();
                    break;

                case 4:
                    inventory.seeTaxRate();
                    break;
            }
        }
        while (userChoice != 5);
    }
}
