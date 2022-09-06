package homeMenu;

import login.Login;
import signup.Signup;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HomeMenuModel {
    final List<String> menuOptions = List.of("Login","SignUp");
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException, NoSuchAlgorithmException {

        switch (selectedOption) {
            case 1 -> new Login();
            case 2 -> new Signup();
            default -> throw new IndexOutOfBoundsException();
        }
    }


}
