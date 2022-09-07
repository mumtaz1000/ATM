package signup;

import utils.FileHandler;
import utils.PasswordHandler;
import utils.PrintHandler;
import utils.User;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Signup extends User{
    public Signup() throws IOException, NoSuchAlgorithmException {
        requestUserInfo();
        createNewAccount();
    }
    public void createNewAccount() throws IOException, NoSuchAlgorithmException {
        FileHandler fileHandlerObject = new FileHandler();
        List<String> nameList = new ArrayList<>();
        String nameNumberString, crypticPassword;
        boolean found;
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(fileHandlerObject.fileName,"rw");

        fileHandlerObject.createFile();
        while(randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()){
            nameNumberString = randomAccessFileObj.readLine();
            nameList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString),0));
        }
        found = User.nameAlreadyExist(nameList, getFullname());
        if (!found){
            crypticPassword = PasswordHandler.createCrypticPassword(getPassword());
            nameNumberString = getFullname()+","+getUsername()+","+crypticPassword+",0";
            randomAccessFileObj.writeBytes(nameNumberString);
            randomAccessFileObj.writeBytes(System.lineSeparator());
            randomAccessFileObj.close();
            System.out.println("A new user is successfully created");
        } else {
            randomAccessFileObj.close();
        }
    }


}
