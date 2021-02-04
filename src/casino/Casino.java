/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tim
 */
public class Casino {

    /**
     * @param args the command line arguments
     */
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to my library system");
        boolean play = true;
        double money = 200;
        while (play = true) {
            System.out.println("Welcome to the casino. What game would you like to play");
            System.out.println("You have £"+money+" to spend.");
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
                    }
                    if ((useranswer.toLowerCase().equals("lower")) && (randnum1 < randnum2)) {
                        win = bet * 2;
                        money = win + money;
                        System.out.println("Congratulations you win!");
                    }
                    if (randnum1 == randnum2) {
                        System.out.println("The number were the same so you don't lose or win");
                    } else {
                        money = money - bet;
                        System.out.println("Sorry you lose");

                    }

                    System.out.println("You now have £" + money);

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
                        colourwheel.equals("green");
                    } 
                    else {
                        if (randnum % 2 == 0) {
                            colourwheel.equals("red");
                        } else {
                            colourwheel.equals("black");
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
                            System.out.println("You win £" + win);
                        }
                    }
                    if (evenodd.toLowerCase().equals("yes")) {
                        if (((oddeven.toLowerCase().equals("even")) && (randnum % 2 == 0)) || ((oddeven.toLowerCase().equals("odd")) && ((!(randnum % 2 == 0)) || (randnum == 0)))) {
                            win = bet * 2;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                        }
                    }
                    if (row.toLowerCase().equals("yes")) {
                        if ((((1 <= randnum) || (randnum <= 3)) && (userrow == 1)) || (((4 <= randnum) || (randnum <= 6)) && (userrow == 2)) || (((7 <= randnum) || (randnum <= 9)) && (userrow == 3)) || (((10 <= randnum) || (randnum <= 12)) && (userrow == 4)) || (((13 <= randnum) || (randnum <= 15)) && (userrow == 5)) || (((16 <= randnum) || (randnum <= 18)) && (userrow == 6)) || (((19 <= randnum) || (randnum <= 21)) && (userrow == 7)) || (((22 <= randnum) || (randnum <= 24)) && (userrow == 8)) || (((25 <= randnum) || (randnum <= 27)) && (userrow == 9)) || (((28 <= randnum) || (randnum <= 30)) && (userrow == 10)) || (((31 <= randnum) || (randnum <= 33)) && (userrow == 11)) || (((34 <= randnum) || (randnum <= 36)) && (userrow == 12))) {

                            win = bet * 11;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                        }
                    }

                    if (column.toLowerCase().equals("yes")) {
                        if (((randnum == 1) || (randnum == 4) || (randnum == 7) || (randnum == 10) || (randnum == 13) || (randnum == 16) || (randnum == 19) || (randnum == 22) || (randnum == 25) || (randnum == 28) || (randnum == 31) || (randnum == 34)) && (usercol == 1)) {
                            win = bet * 3;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                            if (((randnum == 2) || (randnum == 5) || (randnum == 8) || (randnum == 11) || (randnum == 14) || (randnum == 17) || (randnum == 20) || (randnum == 23) || (randnum == 26) || (randnum == 29) || (randnum == 32) || (randnum == 35)) && (usercol == 2)) {
                                win = bet * 3;
                                money = money + win;
                            }
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                        }
                        if (((randnum == 3) || (randnum == 6) || (randnum == 9) || (randnum == 12) || (randnum == 15) || (randnum == 18) || (randnum == 21) || (randnum == 24) || (randnum == 26) || (randnum == 30) || (randnum == 33) || (randnum == 36)) && (usercol == 3)) {
                            win = bet * 3;
                            money = money + win;
                            System.out.println("You got the number correct!");
                            System.out.println("You win £" + win);
                        }
                    }
                    if (half.toLowerCase().equals("yes")) {
                        if ((randnum <= 18) && (userhalf == 1)) {
                            win = bet * 2;
                            money = money + win;
                            System.out.println("You win £" + win);
                        }
                    }
                    System.out.println("You now have £" + money);
                    break;

                case 3:
                    System.out.println("You are now playing the slot machine");
                    break;

                case 0:
                    System.out.println("You left with £" + money);
                    System.exit(0);

            }

        }
    }
}
