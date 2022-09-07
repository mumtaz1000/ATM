package utils;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static utils.PrintHandler.splitFileString;

public class FileHandler {
    public final String fileName = "assets/AtmUserData.txt";
    public final String temporaryFilePath = "assets/TemporaryFile.txt";
    public void createFile(){
        File file = new File(fileName);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateFile(String searchUser,String updatedString) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        File temporaryFile = new File(temporaryFilePath);
        RandomAccessFile temporaryRandomAccessFile = new RandomAccessFile(temporaryFile,"rw");
        String nameNumberString;

        randomAccessFile.seek(0);
        while(randomAccessFile.getFilePointer() < randomAccessFile.length()){
            nameNumberString = randomAccessFile.readLine();

            if(Objects.equals(searchUser,nameNumberString)){
                System.out.println("Required person data found to update!!");
                nameNumberString = updatedString;
            }
            temporaryRandomAccessFile.writeBytes(nameNumberString);
            temporaryRandomAccessFile.writeBytes(System.lineSeparator());
        }
        randomAccessFile.seek(0);
        temporaryRandomAccessFile.seek(0);
        while(temporaryRandomAccessFile.getFilePointer() < temporaryRandomAccessFile.length()) {
        randomAccessFile.writeBytes(temporaryRandomAccessFile.readLine());
        randomAccessFile.writeBytes(System.lineSeparator());
        }
        randomAccessFile.setLength(temporaryRandomAccessFile.length());
        temporaryRandomAccessFile.close();
        randomAccessFile.close();
        temporaryFile.delete();
        System.out.println("Your balance is updated");
    }
    public String accountExist(String userName) throws IOException{
        String nameNumberString, result = null;
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(fileName,"rw");

        createFile();
        while(randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()){
            nameNumberString = randomAccessFileObj.readLine();
            if(Objects.equals(userName,splitFileString(List.of(nameNumberString),1))){
                System.out.println("Account exists!");
                result = nameNumberString;
            }
        }
        return result;
    }

    public String createRequiredString(String dataString, String amount){
        String updatedString = splitFileString(List.of(dataString),0)+","+
                                splitFileString(List.of(dataString),1)+","+
                                splitFileString(List.of(dataString),2)+","+
                                amount;
        return updatedString;
    }
}
