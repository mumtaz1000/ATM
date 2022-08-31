package utils;

import java.io.IOException;
import java.io.File;
public class FileHandler {

    public static void createFile(String filename){
        File file = new File(filename);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
