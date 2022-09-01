package login;

import utils.FileHandler;
import utils.PrintHandler;
import utils.User;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static utils.PasswordHandler.createCrypticPassword;

public class LoginModel extends User {
    Scanner scanner = new Scanner(System.in);
    private final List<String> menuOptions = List.of("View balance", "Withdraw money", "Deposite", "Transfer money", "Logout");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> System.out.println("View balance");
            case 2 -> System.out.println("Withdraw");
            case 3 -> System.out.println("Deposite");
            case 4 -> System.out.println("Transfer");
            case 5 -> System.out.println("Logout");
            default -> throw new IndexOutOfBoundsException();
        }
    }
    public void requestToLogin() throws IOException, NoSuchAlgorithmException {
        List<String> nameList = new ArrayList<>();
        List<String> passwordList = new ArrayList<>();
        String nameNumberString, crypticPassword;
        boolean found;
        String input;
        String filename = "assets/AtmUserData.txt";
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(filename,"rw");

        requestUserInfo();
        FileHandler.createFile(filename);
        while(randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()){
            nameNumberString = randomAccessFileObj.readLine();
            nameList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString),0));
            passwordList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString),2));
        }
        found = User.nameAlreadyExist(nameList, getFullname());
        if (found){
            crypticPassword = createCrypticPassword(getPassword());
            found = User.nameAlreadyExist(passwordList, crypticPassword);
            if(found){
                System.out.println("User is logged in!!!");

            }
        } else {
            randomAccessFileObj.close();
        }
    }
    public void chooseAtmOption() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {

            chooseAtmOption();
        }
    }
}
