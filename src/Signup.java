import utils.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Signup extends User {
    public void requestSignUpInput() throws IOException, NoSuchAlgorithmException {

        requestUserInfo();
        createNewUserInFile();
    }
    public void createNewUserInFile() throws IOException, NoSuchAlgorithmException {
        List<String> nameList = new ArrayList<>();
        String nameNumberString, crypticPassword;
        boolean found;
        String filename = "assets/AtmUserData.txt";
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(filename,"rw");

        FileHandler.createFile(filename);
        while(randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()){
            nameNumberString = randomAccessFileObj.readLine();
            nameList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString),0));
        }
        found = User.nameAlreadyExist(nameList, getFullname());
        if (!found){
            crypticPassword = PasswordHandler.createCrypticPassword(getPassword());
            nameNumberString = getFullname()+","+getUsername()+","+crypticPassword;
            randomAccessFileObj.writeBytes(nameNumberString);
            randomAccessFileObj.writeBytes(System.lineSeparator());
            randomAccessFileObj.close();
            System.out.println("A new user is successfully created");
        } else {
            randomAccessFileObj.close();
        }
    }
}
