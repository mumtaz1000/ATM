package login;

import account.Account;
import authentication.Authentication;
import utils.FileHandler;
import utils.User;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Objects;

import static utils.PrintHandler.splitFileString;

public class Login extends User {
    Authentication authenticationObject = new Authentication();
    public Login() throws IOException, NoSuchAlgorithmException {
        findUserFromData();
    }
    public boolean findUserFromData() throws IOException, NoSuchAlgorithmException {
        FileHandler fileObj = new FileHandler();
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(fileObj.fileName, "rw");
        String nameNumberString;
        boolean found = false;

        requestUserInfo();
        fileObj.createFile();
        while (randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()) {
            nameNumberString = randomAccessFileObj.readLine();
            found = checkCredentials(nameNumberString, getFullname(), getUsername(), getPassword());
            if(found) {
                randomAccessFileObj.close();
                new Account(nameNumberString);
                break;}
        }
        randomAccessFileObj.close();
        return found;
    }
    private boolean checkCredentials(String credentialList, String fullname, String userName, String password) throws NoSuchAlgorithmException {
        String searchName, searchUsername, searchPassword;
        boolean found = false;

        searchName = (splitFileString(Collections.singletonList(credentialList), 0));
        searchUsername = (splitFileString(Collections.singletonList(credentialList), 1));
        searchPassword = (splitFileString(Collections.singletonList(credentialList), 2));
        if (Objects.equals(searchName, fullname)) {
            System.out.println("Required name exist!!!");

            found = authenticationObject.userNamePasswordExists(searchUsername, searchPassword, userName, password);

        }
        return found;
    }
}