package utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class AtmUser {
    public static void createNewUser(String filename, String name, String username, String password) throws IOException {
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(filename,"rw");

        String nameNumberString = name+","+username+","+password;
        randomAccessFileObj.writeBytes(nameNumberString);
        randomAccessFileObj.writeBytes(System.lineSeparator());
        System.out.println("A new friend added to list");
        randomAccessFileObj.close();
    }
    public static boolean nameAlreadyExist(List<String> nameList, String nameSearch){
        boolean found = false;
        for (String name: nameList) {
            if(name.contains(nameSearch))
            {found = true;
                System.out.println("Required name found");
                break;}
        }
        return found;
    }
}
