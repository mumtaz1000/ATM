package account;

import utils.MenuMessages;
import utils.PrintHandler;

import java.util.List;

public class AccountView extends MenuMessages {
    public AccountView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Main menu options: ");
        PrintHandler.optionList(menuOptions);
        printRequest();
    }
}
