package account;

import utils.FileHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static utils.PrintHandler.splitFileString;

public class AccountModel {
    FileHandler fileHandlerObject = new FileHandler();
    Scanner scanner = new Scanner(System.in);
    private final List<String> menuOptions = List.of("View balance", "Withdraw", "Deposite", "Transfer");
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption, String nameNumberString) throws IndexOutOfBoundsException, IOException {
        String updateString;

        switch (selectedOption) {
            case 1 -> viewBalance(nameNumberString);
            case 2 -> {
                updateString = withDrawMoney(nameNumberString,getRequiredAmount());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            case 3 -> {
                updateString = depositeMoney(nameNumberString,getRequiredAmount());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            case 4 -> {
                String userData = fileHandlerObject.accountExist(getTransferAccountName());
                if( userData != null)
                {
                    updateString = depositeMoney(userData,getRequiredAmount());
                    fileHandlerObject.updateFile(userData, updateString);
                }
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
    protected void viewBalance(String personInformation) {
        int totalBalance = Integer.parseInt(splitFileString(Collections.singletonList(personInformation),3));
        System.out.println("Your total balance is "+totalBalance);
    }
    public int getRequiredAmount(){

        System.out.println("Enter the amount ");
        return scanner.nextInt();
    }
    public String getTransferAccountName(){

        System.out.println("Enter the user name of the person to whom you want to transfer money");
        return scanner.next();
    }
    public String withDrawMoney(String dataString, int amount){
        int totalBalance = Integer.parseInt(splitFileString(List.of(dataString),3));

        totalBalance -= amount;
        return fileHandlerObject.createRequiredString(dataString, String.valueOf(totalBalance));
    }
    public String depositeMoney(String dataString, int amount){
        int totalBalance = Integer.parseInt(splitFileString(List.of(dataString),3));

        totalBalance += amount;
        return fileHandlerObject.createRequiredString(dataString, String.valueOf(totalBalance));
    }
}
