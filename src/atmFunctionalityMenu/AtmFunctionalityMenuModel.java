package atmFunctionalityMenu;

import java.util.List;

public class AtmFunctionalityMenuModel {
    private final List<String> menuOptions = List.of("View balance", "Withdraw money", "Deposite", "Transfer money", "Logout");

        public List<String> getMenuOptions() {
            return menuOptions;
        }

        public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
            switch (selectedOption) {
                case 1 -> System.out.println("View balance");
                case 2 -> System.out.println("Withdraw");
                case 3 -> System.out.println("Deposite");
                case 4 -> System.out.println("Transfer");
                case 5 -> System.out.println("Logout");
                default -> throw new IndexOutOfBoundsException();
            }
        }
    }
