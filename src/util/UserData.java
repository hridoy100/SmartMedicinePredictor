package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    public static String username="root";
    public static String password="admin";
    public static String fileName;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserData.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserData.password = password;
    }

    public static ArrayList<String> readFromFile(){
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        ArrayList<String> entries = new ArrayList<>();
        File file = new File(currentDirectory+"/loginData.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                entries.add(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public static void writeToFile(String text, String fileName){
        String path = System.getProperty("user.dir")+"/"+fileName;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
            writer.append('\n');
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkIfUserExists(String username, String password) {
        ArrayList<String> entries = readFromFile();
        for (String entry: entries){
            if(entry.equals(username+":"+password)){ //the entries are saved like "username:password"
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfUsernameAlreadyExists(String username) {
        ArrayList<String> entries = readFromFile();
        for (String entry: entries){
            String usernameDB = entry.substring(0,entry.indexOf(":"));
            if(usernameDB.equals(username)){ //the entries are saved like "username:password"
                return true;
            }
        }
        return false;
    }

}
