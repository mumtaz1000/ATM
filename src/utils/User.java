package utils;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {
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

    public void requestUserInfo(){
        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name");
        input = scanner.nextLine();
        setFullname(input);
        System.out.println("Enter your user name");
        input = scanner.nextLine();
        setUsername(input);
        System.out.println("Enter password");
        input = scanner.nextLine();
        setPassword(input);
        System.out.println("User info is successfully taken!!!");
    }
    public static boolean nameAlreadyExist(List<String> inputList, String search){
        boolean found = false;
        for (String name: inputList) {
            if(Objects.equals(name, search))
            {found = true;
                break;}
        }
        return found;
    }
}
