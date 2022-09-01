import login.Login;
import utils.Menus;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HomeMenu implements Menus {
    final List<String> loginMenuOptions = List.of("View balance", "Withdraw money", "Deposite", "Transfer money", "Logout");
    public HomeMenu(List<String> menuOptions) {
        displayMenuOptions(menuOptions);
        requestUserInput();
    }
    @Override
    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException, NoSuchAlgorithmException {

        switch (selectedOption) {
            case 1 -> new Login(loginMenuOptions);
            case 2 -> {
                Signup signup = new Signup();
                signup.requestSignUpInput();
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
