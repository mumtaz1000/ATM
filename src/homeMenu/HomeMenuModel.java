package homeMenu;

import signup.Signup;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HomeMenuModel {
    private final List<String> menuOptions = List.of("Login", "Signup");

    public List<String> getMenuOptions() {
            return menuOptions;
        }

        public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException, NoSuchAlgorithmException {

            switch (selectedOption) {
                case 1 -> System.out.println("Login");
                case 2 -> new Signup();
                default -> throw new IndexOutOfBoundsException();
            }
        }
    }