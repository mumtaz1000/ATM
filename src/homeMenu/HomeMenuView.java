package homeMenu;

import utils.PrintHandler;

import java.util.List;

public class HomeMenuView {
    public HomeMenuView(List<String> menuOptions){
        PrintHandler.clearScreen();
        PrintHandler.menuOptionList(menuOptions);
        printRequest();
    }
    public void printInvalidOption() {
        PrintHandler.printMessage.accept("⚠️ Invalid option");
    }
    public void printRequest() {
        PrintHandler.printMessage.accept("Choose an option press enter: ");
    }
}
