import utils.PrintHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> homeMenuOptions = List.of("Login", "Signup");

        PrintHandler.printMessage.accept("Welcome to atm project");
        new HomeMenu(homeMenuOptions);

    }
}
