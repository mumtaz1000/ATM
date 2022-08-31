package signup;

import utils.AtmUser;
import utils.FileHandler;
import utils.PasswordHandler;
import utils.PrintHandler;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignupModel {
    private final List<String> menuOptions = List.of("Full Name","User Name","Password");
    private String fullname;
    private String username;
    private String password;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void createNewUserInFile() throws IOException, NoSuchAlgorithmException {
        List<String> nameList = new ArrayList<>();
        String filename = "assets/AtmUserData.txt";
        String nameNumberString, crypticPassword;
        boolean found = false;
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(filename,"rw");

        FileHandler.createFile(filename);
        while(randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()){
            nameNumberString = randomAccessFileObj.readLine();
            nameList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString),0));
        }
        found = AtmUser.nameAlreadyExist(nameList, getFullname());
        if (found == false ){
            crypticPassword = PasswordHandler.createCrypticPassword(getPassword());
            AtmUser.createNewUser(filename,getFullname(), getUsername(),crypticPassword);
            System.out.println("A new user is successfully created");
        } else {
            randomAccessFileObj.close();
        }
    }
}
