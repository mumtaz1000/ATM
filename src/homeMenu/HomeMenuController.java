package homeMenu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HomeMenuController {
    private final HomeMenuView view;
    private final HomeMenuModel model;
    private final Scanner scanner;

    public HomeMenuController(HomeMenuModel model, HomeMenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.printRequest();
            requestUserInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
