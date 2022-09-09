package authentication;

import account.Account;
import utils.FileHandler;
import utils.User;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static utils.PasswordHandler.createCrypticPassword;
import static utils.PrintHandler.splitFileString;

public class Authentication extends User {
    public static boolean dataExist(List<String> inputList, String search){
        boolean found = false;
        for (String name: inputList) {
            if(Objects.equals(name, search))
            {found = true;
                break;}
        }
        return found;
    }
    public boolean userNamePasswordExists(String userNameList, String passwordList, String userName, String password)
            throws NoSuchAlgorithmException {
        String crypticPassword;
        boolean found = false;

        crypticPassword = createCrypticPassword(password);
        if(dataExist(Collections.singletonList(userNameList), userName) &&
                dataExist(Collections.singletonList(passwordList), crypticPassword))
        {
                System.out.println("Welcome "+userName+ "!!!");
                found = true;
            }
        return found;
    }
    public boolean homeMenuAuthentication() throws IOException, NoSuchAlgorithmException {
        FileHandler fileObj = new FileHandler();
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(fileObj.fileName, "rw");
        String nameNumberString, userNameList, passwordList;
        boolean found = false;

        requestUserNamePassword();
        fileObj.createFile();
        while (randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()) {
            nameNumberString = randomAccessFileObj.readLine();
            userNameList = (splitFileString(Collections.singletonList(nameNumberString), 1));
            passwordList = (splitFileString(Collections.singletonList(nameNumberString), 2));
            found = userNamePasswordExists(userNameList, passwordList, getUsername(), getPassword());
            if(found) {
                randomAccessFileObj.close();
                new Account(nameNumberString);
                break;}
        }
        randomAccessFileObj.close();
        return found;
    }


}
