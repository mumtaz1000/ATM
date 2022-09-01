package login;

import utils.FileHandler;
import utils.Menus;
import utils.PrintHandler;
import utils.User;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.PasswordHandler.createCrypticPassword;

public class Login extends User implements Menus {

    public Login(List<String> menuOptions) throws IOException, NoSuchAlgorithmException {
        requestToLogin();
    }
    @Override
    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException, NoSuchAlgorithmException {

        switch (selectedOption) {
            case 1 -> {}
            case 2 -> {}
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
}