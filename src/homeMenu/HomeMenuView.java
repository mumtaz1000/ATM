package homeMenu;

import utils.MenuMessages;
import utils.PrintHandler;

import java.util.List;

public class HomeMenuView extends MenuMessages {
    public HomeMenuView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Main menu options: ");
        PrintHandler.optionList(menuOptions);
        printRequest();
    }
}
