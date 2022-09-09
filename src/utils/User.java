package utils;

import java.util.Scanner;

public class User {
    private String fullname;
    private String username;
    private String password;
    String input;
    Scanner scanner = new Scanner(System.in);
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

        System.out.println("Enter your full name");
        input = scanner.nextLine();
        setFullname(input);
        requestUserNamePassword();
        System.out.println("User info is successfully taken!!!");
    }
    public void requestUserNamePassword(){
        System.out.println("Enter your user name");
        input = scanner.nextLine();
        setUsername(input);
        System.out.println("Enter password");
        input = scanner.nextLine();
        setPassword(input);
    }

}
