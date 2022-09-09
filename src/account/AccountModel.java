package account;

import transaction.Transaction;
import utils.FileHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import static utils.PasswordHandler.createCrypticPassword;
public class AccountModel {
    FileHandler fileHandlerObject = new FileHandler();
    Transaction transactionObject = new Transaction();
    Scanner scanner = new Scanner(System.in);
    private final List<String> menuOptions = List.of("View balance", "Withdraw", "Deposite", "Transfer","Update Username","Update password");
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption, String nameNumberString)
            throws IndexOutOfBoundsException, IOException, NoSuchAlgorithmException {
        String updateString;

        switch (selectedOption) {
            case 1 -> transactionObject.viewBalance(nameNumberString);
            case 2 -> {
                updateString = transactionObject.withDrawMoney(nameNumberString, transactionObject.getRequiredAmount());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            case 3 -> {
                updateString = transactionObject.depositeMoney(nameNumberString,transactionObject.getRequiredAmount());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            case 4 -> {
                String userData = fileHandlerObject.accountExist(transactionObject.getTransferAccountName());
                if( userData != null)
                {
                    updateString = transactionObject.depositeMoney(userData,transactionObject.getRequiredAmount());
                    fileHandlerObject.updateFile(userData, updateString);
                }
            }
            case 5 -> {
                updateString = fileHandlerObject.createUpdateUsernameString(nameNumberString,handleUsernameUpdate());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            case 6 -> {
                updateString = fileHandlerObject.createUpdatePasswordString(nameNumberString,handlePasswordUpdate());
                fileHandlerObject.updateFile(nameNumberString, updateString);
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public String handleUsernameUpdate(){
        String username;

        System.out.println("Enter the updated user name");
        username = scanner.next();
        return username;
    }
    public String handlePasswordUpdate() throws NoSuchAlgorithmException {
        String password;

        System.out.println("Enter the updated password");
        password = scanner.next();
        return createCrypticPassword(password);
    }

}
