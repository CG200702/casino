/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author tim
 */
public class filehandling {


    public static String folderDirectory = System.getProperty("user.dir") + "\\playerList.txt";

    public static void writeFile(ArrayList<player>playerList) {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < playerList.size(); i++) {
                printToFile.println(playerList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<player>readFile() {
        ArrayList<player>playerList=new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] playerDetails = lineFromFile.split(", ");
                //String name, String ISBN, String author, double price, String releaseDate, String genre
                
                
                player myPlayers = new player(playerDetails[0]);
                myPlayers.setWinnings(Double.parseDouble(playerDetails[1]));
                
                playerList.add(myPlayers);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return playerList;
    }
}


    

