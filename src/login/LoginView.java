package login;

import utils.PrintHandler;

import java.util.List;

public class LoginView {
    public LoginView(){
        PrintHandler.clearScreen();
    }
    public void displayAtmMenu(List<String> menuOptions){
        PrintHandler.clearScreen();
        System.out.println("Main menu options:");
        PrintHandler.menuOptionList(menuOptions);
    }
}
