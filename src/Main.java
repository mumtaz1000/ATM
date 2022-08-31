import homeMenu.HomeMenu;
import signup.Signup;
import utils.PrintHandler;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        PrintHandler.printMessage.accept("Welcome to atm project");
        new HomeMenu();

    }
}
