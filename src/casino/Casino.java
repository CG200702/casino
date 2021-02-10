/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tim
 */
public class Casino {

    private static ArrayList<player> playerList = new ArrayList<>();
    private static ArrayList<player> myPlayers = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        mainMenu();
    }

    public static void bubbleSort() {
        int n = playerList.size();
        boolean swapped = false;
        while (swapped == false) {
            swapped= true;
            for (int i = 0; i < n-1; i++) {

//            int i = j - 1;
                if ((playerList.get(i).getWinnings() > playerList.get(i + 1).getWinnings())) {
//                playerList.set(i + 1, playerList.get(i));
                    Collections.swap(playerList, i, i+ 1);
                    swapped = false;
                    
//i--;
                }
//            playerList.set(i + 1, playerList.get(j));
            }
        }
    }

    public static void mainMenu() {
        playerList = filehandling.readFile();
        System.out.println("Top scores:");
        if (playerList.isEmpty()) {
            System.out.println("Sorry, there are no scores at the moment");
        } else {
            bubbleSort();

            for (int i = playerList.size()-1; i >= playerList.size()-5; i--) {
                System.out.println(playerList.get(i).toString());
            }
        }
        System.out.println("");
        System.out.println("Please type in your name");
        String name = input.next();

        double money = 200;
        double winnings = 0;
        while (money > 0) {
            System.out.println("Welcome to the casino. What game would you like to play");
            System.out.println("You have £" + money + " to spend.");
            System.out.println("1 - Higher or lower");
            System.out.println("2 - Roulette");
            System.out.println("3 - Slot machine");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();
            double bet = 0;

            switch (userChoice) {
                case 1:
                    System.out.println("You are now playing higher or lower");
                    String[] suits = {"clubs", "hearts", "spades", "diamonds"};
                    String[] cardnumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
                    System.out.println("How much do you want to bet?");
                    bet = input.nextDouble();
                    money = money - bet;
                    int randsuit1 = random.nextInt(suits.length);
                    int randnum1 = random.nextInt(cardnumber.length);
                    System.out.println("The first card is: " + (cardnumber[randnum1]) + " of " + (suits[randsuit1]));
                    System.out.println("Higher or lower?");
                    String useranswer = input.next();
                    int randsuit2 = random.nextInt(suits.length);
                    int randnum2 = random.nextInt(cardnumber.length);
                    double win = 0;
                    System.out.println("The next card is: " + (cardnumber[randnum2]) + " of " + (suits[randsuit2]));

                    if ((useranswer.toLowerCase().equals("higher")) && (randnum1 < randnum2)) {
                        win = bet * 2;
                        money = win + money;
                        System.out.println("Congratulations you win!");
                        winnings = winnings + win;
                    }
                    if ((useranswer.toLowerCase().equals("lower")) && (randnum1 > randnum2)) {
                        win = bet * 2;
                        money = win + money;
                        winnings = winnings + win;
                        System.out.println("Congratulations you win!");
                    }
                    if (randnum1 == randnum2) {
                        System.out.println("The numbers were the same so you don't lose or win any money");
                        money = money + bet;
                    }
                    if (!((useranswer.toLowerCase().equals("higher")) && (randnum1 < randnum2))) {
                        if (!((useranswer.toLowerCase().equals("lower")) && (randnum1 > randnum2))) {
                            if (!(randnum1 == randnum2)) {

                                System.out.println("Sorry you lose");

                            }
                        }
                    }

                    System.out.println("You now have £" + money);
                    System.out.println("");
                    break;

                case 2:
                    String usercolour = "";
                    String colourwheel = "";
                    String half = "";
                    int userhalf = 0;
                    int userrow = 0;
                    int usercol = 0;
                    int max = 36;
                    int min = 0;
                    int randnum = random.nextInt(((max - min) + 1) + min);
                    int userentry = 0;
                    String evenodd = "";
                    String row = "";
                    String column = "";
                    win = 0;
                    String oddeven = "";
                    System.out.println("You are now playing roulette");
                    System.out.println("How much do you want to bet?");
                    bet = input.nextDouble();
                    money = money - bet;
                    System.out.println("Would you like to bet on a colour?");
                    String colour = input.next();
                    if (colour.toLowerCase().equals("yes")) {
                        System.out.println("What colour do you want to bet on?");
                        usercolour = input.next();
                    }

                    if (colour.toLowerCase().equals("no")) {
                        System.out.println("Would you like to bet on an even or odd?");
                        evenodd = input.next();
                        if (evenodd.toLowerCase().equals("yes")) {
                            System.out.println("Are you betting odd or even?");
                            oddeven = input.next();
                        }

                        if (evenodd.equals("no")) {
                            System.out.println("Would you like to bet on a row?");
                            row = input.next();
                            if (row.equals("yes")) {
                                System.out.println("Which row 1-12?");
                                userrow = input.nextInt();
                            }

                            if (row.equals("no")) {
                                System.out.println("Would you like to bet on a column?");
                                column = input.next();
                                if (column.equals("yes")) {
                                    System.out.println("Which column 1-3?");
                                    usercol = input.nextInt();
                                }
                                if (column.equals("no")) {

                                    System.out.println("Would you like to bet on a half?");
                                    half = input.next();
                                    if (half.equals("yes")) {
                                        System.out.println("Which half 1 or 2?");
                                        userhalf = input.nextInt();
                                    }

                                    System.out.println("What number do you want to bet on?");
                                    userentry = input.nextInt();
                                    for (int i = 0; (!(userentry < 36 && userentry > 0)); i++) {

                                        System.out.println("What number do you want to bet on?");
                                        userentry = input.nextInt();
                                    }
                                }
                            }

                        }
                    }

                    System.out.println("*****************************************************************************************************");
                    System.out.println("**************************************** WHEEL SPINNING *********************************************");
                    System.out.println("*****************************************************************************************************");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");

                    if (randnum == 0) {
                        colourwheel = "green";
                    } else {
                        if (randnum % 2 == 0) {
                            colourwheel = "red";
                        } else {
                            colourwheel = "black";
                        }
                    }
                    System.out.println("The ball landed on " + randnum + " on the colour " + colourwheel);
                    if (colour.toLowerCase().equals("no")) {
                        if (evenodd.toLowerCase().equals("no")) {
                            if (row.toLowerCase().equals("no")) {
                                if (column.toLowerCase().equals("no")) {
                                    if (randnum == userentry) {
                                        win = bet * 35;
                                        money = money + win;
                                        System.out.println("You got the number correct!");
                                        System.out.println("You win £" + win);
                                    }
                                }
                            }
                        }
                    }
                    if ((colour.toLowerCase().equals("yes"))) {
                        if ((usercolour.toLowerCase().equals(colourwheel))) {

                            win = bet * 2;
                            money = money + win;
                            System.out.println("You got the number correct!");

                        }
                    }
                    if (evenodd.toLowerCase().equals("yes")) {
                        if ((oddeven.toLowerCase().equals("even")) && (randnum % 2 == 0)) {
                            win = bet * 2;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            winnings = winnings + win;
                        }
                    }
                    if (evenodd.toLowerCase().equals("yes")) {
                        if ((oddeven.toLowerCase().equals("odd")) && (!(randnum % 2 == 0))) {
                            win = bet * 2;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            winnings = winnings + win;
                        }
                    }
                    if (evenodd.toLowerCase().equals("yes")) {
                        if (randnum == 0) {

                            money = money + bet;
                            System.out.println("The number it landed on was 0 so you don't lose your bet or win");

                        }
                    }

                    if (row.toLowerCase().equals("yes")) {
                        if ((((4 <= randnum) && (randnum <= 6)) && (userrow == 2))) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((1 <= randnum) && (randnum <= 3) && (userrow == 1)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((7 <= randnum) && (randnum <= 9) && (userrow == 3)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((10 <= randnum) && (randnum <= 12) && (userrow == 4)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((13 <= randnum) && (randnum <= 15) && (userrow == 5)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((16 <= randnum) && (randnum <= 18) && (userrow == 6)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((19 <= randnum) && (randnum <= 21) && (userrow == 7)) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (column.toLowerCase().equals("yes")) {
                        if (((randnum == 1) || (randnum == 4) || (randnum == 7) || (randnum == 10) || (randnum == 13) || (randnum == 16) || (randnum == 19) || (randnum == 22) || (randnum == 25) || (randnum == 28) || (randnum == 31) || (randnum == 34)) && (usercol == 1)) {
                            win = bet * 3;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                        if (((randnum == 2) || (randnum == 5) || (randnum == 8) || (randnum == 11) || (randnum == 14) || (randnum == 17) || (randnum == 20) || (randnum == 23) || (randnum == 26) || (randnum == 29) || (randnum == 32) || (randnum == 35)) && (usercol == 2)) {
                            win = bet * 3;
                            money = money + win;

                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                        if (((randnum == 3) || (randnum == 6) || (randnum == 9) || (randnum == 12) || (randnum == 15) || (randnum == 18) || (randnum == 21) || (randnum == 24) || (randnum == 26) || (randnum == 30) || (randnum == 33) || (randnum == 36)) && (usercol == 3)) {
                            win = bet * 3;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    if (half.toLowerCase().equals("yes")) {
                        if ((randnum <= 18) && (userhalf == 1)) {
                            win = bet * 2;
                            money = money + win;
                            System.out.println("You win £" + win);
                            winnings = winnings + win;
                        }
                    }
                    System.out.println("You now have £" + money);
                    System.out.println("");
                    break;

                case 3:
                    int maxj = 500;
                    int minj = 150;
                    int JACKPOT = random.nextInt((maxj - minj) + 1) + minj;
                    System.out.println("You are now playing the slot machine");
                    System.out.println("It costs £10 a play");
                    System.out.println("");
                    System.out.println("Rules:");
                    System.out.println("BAR = bar, P = plum, M = watermelon, L = lemon, O = orange, B = Bell, C = cherry & D = diamond");
                    System.out.println("");
                    System.out.println("Scores:");
                    System.out.println("1 x C = 2, 2 x C = 5, 3 x C = 15");
                    System.out.println("3 x L = 30");
                    System.out.println("3 x O = 45");
                    System.out.println("3 x P = 60");
                    System.out.println("3 x B = 75");
                    System.out.println("3 x M = 90");
                    System.out.println("3 x BAR = 105");
                    System.out.println("3 x D = JACKPOT");
                    System.out.println("The jackpot right now is: £" + JACKPOT);
                    bet = 10;
                    money = money - bet;

                    String[] slots = {"BAR", " P ", " M ", " L ", " O ", " B ", " C ", " D "};
                    int slot1 = random.nextInt(slots.length);
                    int slot2 = random.nextInt(slots.length);
                    int slot3 = random.nextInt(slots.length);

                    System.out.println("[   ] [   ] [   ]");
                    System.out.println("[" + slots[slot1] + "] [" + slots[slot2] + "] [" + slots[slot3] + "]");
                    if ((slot1 == slot2) && (slot2 == slot3) && (slot1 == slot3)) {
                        if (slot1 == 0) {
                            money = money + 105;
                            System.out.println("You won £105");
                            winnings = winnings + 105;
                        }
                        if (slot1 == 1) {
                            money = money + 60;
                            System.out.println("You won £60");
                            winnings = winnings + 60;
                        }
                        if (slot1 == 2) {
                            money = money + 90;
                            System.out.println("You won £90");
                            winnings = winnings + 90;
                        }
                        if (slot1 == 3) {
                            money = money + 30;
                            System.out.println("You won £30");
                            winnings = winnings + 30;
                        }
                        if (slot1 == 4) {
                            money = money + 45;
                            System.out.println("You won £45");
                            winnings = winnings + 45;
                        }
                        if (slot1 == 5) {
                            money = money + 75;
                            System.out.println("You won £75");
                            winnings = winnings + 75;
                        }
                        if (slot1 == 6) {
                            money = money + 15;
                            System.out.println("You won £15");
                            winnings = winnings + 15;
                        }
                        if (slot1 == 7) {
                            money = money + JACKPOT;
                            System.out.println("*************************************************************************************");
                            System.out.println("************************************JACKPOT******************************************");
                            System.out.println("*************************************************************************************");
                            System.out.println("");
                            System.out.println("You won £" + JACKPOT);
                            winnings = winnings + JACKPOT;

                        }
                    }
                    if ((slot1 == 6) && (slot2 == 6) && (!(slot3 == 6))) {
                        money = money + 5;
                        System.out.println("You won £5");
                        winnings = winnings + 5;
                    }
                    if ((slot3 == 6) && (slot2 == 6) && (!(slot1 == 6))) {
                        money = money + 5;
                        System.out.println("You won £5");
                        winnings = winnings + 5;
                    }
                    if ((slot1 == 6) && (slot3 == 6) && (!(slot2 == 6))) {
                        money = money + 5;
                        System.out.println("You won £5");
                        winnings = winnings + 5;
                    }
                    if ((slot1 == 6) && (!(slot2 == 6)) && (!(slot3 == 6))) {
                        money = money + 2;
                        System.out.println("You won £2");
                        winnings = winnings + 2;
                    }
                    if ((slot2 == 6) && (!(slot1 == 6)) && (!(slot3 == 6))) {
                        money = money + 2;
                        System.out.println("You won £2");
                        winnings = winnings + 2;
                    }
                    if ((slot3 == 6) && (!(slot2 == 6)) && (!(slot1 == 6))) {
                        money = money + 2;
                        System.out.println("You won £2");
                        winnings = winnings + 2;
                    }

                    System.out.println("You now have £" + money);
                    System.out.println("");
                    break;

                case 0:
                    System.out.println("You left with £" + money);
                    System.out.println("Your total winnings today: £" + winnings);

                    player myPlayer = new player(name);
                    myPlayer.setWinnings(winnings);

                    playerList.add(myPlayer);
                    filehandling.writeFile(playerList);

//                    playerList = filehandling.readFile();
//                    if (playerList.isEmpty()) {
//                        playerList.add(myPlayer);
//                    } else {
//                        for (int i = 0; i < playerList.size(); i++) {
//                            if (winnings>)
//
//                        }
//                        String lineFromFile = null;
//                        String[] playerDetails = lineFromFile.split(", ");
//                        for (int i = 0; i < playerList.size(); i++) {
//                       if (winnings>Double.parseDouble(playerDetails[1])){
//                        playerList.add(myPlayer);
//                        filehandling.writeFile(playerList);
//                    }}}
                    System.exit(0);
            }

        }
        System.out.println("Sorry but you've got no money left");
        System.out.println("You've been kicked out");
    }

}
