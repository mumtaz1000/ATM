package account;

import java.io.IOException;
import java.util.Scanner;

public class AccountController {
    private final AccountView view;
    private final AccountModel model;
    private final Scanner scanner;

    public AccountController(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }
    public void requestUserInput(String nameNumberString) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption, nameNumberString);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.printRequest();
            requestUserInput(nameNumberString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
