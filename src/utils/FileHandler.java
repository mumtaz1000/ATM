package utils;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;

import static utils.PrintHandler.splitFileString;

public class FileHandler {
    public static final String fileName = "assets/AtmUserData.txt";
    public static void createFile(){
        File file = new File(fileName);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateFile(String newName, int amount) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        File temporaryFile = new File("TemporaryFile.txt");
        RandomAccessFile temporaryRandomAccessFile = new RandomAccessFile(temporaryFile,"rw");
        String nameNumberString, name;
        int index;

        randomAccessFile.seek(0);
        while(randomAccessFile.getFilePointer() < randomAccessFile.length()){
            nameNumberString = randomAccessFile.readLine();
            index = nameNumberString.indexOf(",");
            name = nameNumberString.substring(0,index);
            System.out.println("Index "+index+" name "+name);

            if(name.equals(newName)){
                String requiredString = nameNumberString;
                System.out.println("Required data "+requiredString);
                System.out.println("After spliting"+splitFileString(Collections.singletonList(requiredString),3));

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
        System.out.println("Info updated");
    }
}
