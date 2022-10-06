/*Name: Vinicius Parzanini
Function: develop a game called Truco
Date:26/11/2020
*/

import java.util.Scanner;

public class Truco {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Array of cards
        String[] suit = {"C", "D", "H", "S"};
        String[] rank = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] deck = new String[36];

        //combining the cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = rank[i % 9] + suit[i / 9];
        }
        //Variables

        char menu = 'm';
        String User;
        String Player;
        int i;

        //While loop to start over the game as many time as the user wants.
        while (menu != 'e') {//display the main menu
            System.out.println("Welcome to Parzanini's truco!");
            System.out.println("Tell me what you want to do:");
            System.out.println("Press p if you want to Play the game.");
            System.out.println("Press r if you want to see the rules.");
            System.out.println("Press e if you want to exit the game.");
            //user decides what to do
            Player = scan.next();
            char user = Player.charAt(0);
            switch (user) {
            case 'r': {//rules of the game
                System.out.println("Here are the rules");
                System.out.println("---------------------------------------------------------");
                System.out.println("You are playing against BOT.");
                System.out.println("You will receive 3 different cards.");
                System.out.println("There are 2 different strengths in this game:");
                System.out.println("Card Ranking: You have cards from 1 to 9, 1 being the weakest and 9 being the strongest.");
                System.out.println("Suit Strength: In this case Clubs('C')is the weakest one -> Diamonds('D') -> Hearts('H') -> Spades('S') Being the strongest one. ");
                System.out.println("There are 3 rounds");
                System.out.println("Each round you play one card if your card is stronger you win the round");
                System.out.println("Whoever wins 2 rounds wins the game");
                System.out.println("To win a round is simple, you just need to place your card, if you card is stronger than the bot's card you win.");
                System.out.println("if you have the same rank as the bot, whoever has the better suit wins.");
                System.out.println("just be careful to not play your strong cards first! save it for a better moment.");
                System.out.println("And in this game BOT plays first in the first and third round('if there is third round')");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                Player = scan.next();
                menu = Player.charAt(0);
                break;
            }//end of rules
            //playing he game
            case 'p': {

                //points
                int userPoints = 0;
                int computerPoints = 0;

                //cards
                i = 1;
                while (i > 0) {
                    String card1 = deck[(int) (Math.random() * deck.length)];
                    String card2 = deck[(int) (Math.random() * deck.length)];
                    String card3 = deck[(int) (Math.random() * deck.length)];
                    String card4 = deck[(int) (Math.random() * deck.length)];
                    String card5 = deck[(int) (Math.random() * deck.length)];
                    String card6 = deck[(int) (Math.random() * deck.length)];
                    i = 0;

                    //This if is if the cards get repeated
                    if (card1.equals(card2) || card1.equals(card3) || card1.equals(card4) || card1.equals(card5) || card1.equals(card6) || card2.equals(card3) || card2.equals(card4) || card2.equals(card5)
                            || card2.equals(card6) || card3.equals(card4) || card3.equals(card5) || card3.equals(card6) || card4.equals(card5) || card4.equals(card6) || card5.equals(card6)) {
                        i = 1;
                    }

                    if (i == 0) {
                        //the game
                        System.out.println("Ok lets play the game!");
                        System.out.println("Your cards:");
                        System.out.println("---------------------------------------");
                        //Receiving the cards
                        System.out.println("a. " + card1);//player card 1
                        System.out.println("b. " + card2);//player card 2
                        System.out.println("c. " + card3);//player card 3
                        System.out.println("---------------------------------------");
                        System.out.println("Computer played " + card4);
                        System.out.println("Please enter your card: ");
                        User = scan.next();
                        char Card = User.charAt(0);
                        switch (Card) {
                        case 'a': {//user decides to play card a
                            int resulta1 = card1.compareTo(card4);
                            if (resulta1 > 0) {
                                System.out.println("You won this round");
                                userPoints++;
                            } else if (resulta1 < 0) {
                                System.out.println("BOT won this round");
                                computerPoints++;
                            }
                            System.out.println("Now round 2");
                            System.out.println("----------------------");
                            System.out.println("Your cards:");
                            System.out.println("---------------------------------------");
                            System.out.println("b. " + card2);
                            System.out.println("c. " + card3);
                            System.out.println("Please enter your card: ");
                            User = scan.next();
                            char rounda2 = User.charAt(0);
                            {
                                if (rounda2 == 'b') {//user decides to play card b
                                    System.out.println("You played " + card2);
                                    System.out.println("Computer played " + card5);
                                    int resultb1 = card2.compareTo(card5);
                                    if (resultb1 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    } else if (resultb1 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    } else if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //there is round 3 if the game is 1/1
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card3);
                                        int resultc1 = card3.compareTo(card6);//playing the last card
                                        if (resultc1 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        } else if (resultc1 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                }
                                if (rounda2 == 'c') {//user decides to play card c
                                    System.out.println("you played " + card3);
                                    System.out.println("BOT played " + card5);
                                    int resultc2 = card3.compareTo(card5);
                                    if (resultc2 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    } else if (resultc2 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    } else if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //there is a third round if the game is 1/1
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card2);
                                        int resultb2 = card2.compareTo(card6);
                                        if (resultb2 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                        if (resultb2 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                        case 'b': {//if the user decides to start with card b
                            System.out.println("You played " + card2);
                            int resultb3 = card2.compareTo(card4);
                            if (resultb3 > 0) {
                                System.out.println("You won this round");
                                userPoints++;
                            } else if (resultb3 < 0) {
                                System.out.println("BOT won this round");
                                computerPoints++;
                            }
                            System.out.println("Now round 2");//round 2
                            System.out.println("----------------------");
                            System.out.println("Your cards:");
                            System.out.println("---------------------------------------");
                            System.out.println("a. " + card1);
                            System.out.println("c. " + card3);
                            System.out.println("Please enter your card: ");
                            User = scan.next();
                            char roundb2 = User.charAt(0);
                            {
                                if (roundb2 == 'a') {//as the second card, this case is if the user decides to play card a
                                    int resulta2 = card1.compareTo(card5);
                                    System.out.println("You played " + card1);
                                    System.out.println("Computer played " + card5);
                                    if (resulta2 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    } else if (resulta2 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    } else if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //if the game is 1/1 there is a round 3
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card3);
                                        int resultc3 = card3.compareTo(card6);
                                        if (resultc3 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        } else if (resultc3 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                } else if (roundb2 == 'c') {//if the player decides to play card c
                                    int resultc4 = card3.compareTo(card5);
                                    System.out.println("you played " + card3);
                                    System.out.println("BOT played " + card5);
                                    if (resultc4 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    }
                                    if (resultc4 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //if the game is 1/1 there is a third round
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card1);
                                        int resulta3 = card1.compareTo(card6);
                                        if (resulta3 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                        if (resulta3 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                        case 'c': {//if the user decides to play card c
                            int resultc5 = card3.compareTo(card4);
                            System.out.println("You played " + card3);
                            if (resultc5 > 0) {
                                System.out.println("You won this round");
                                userPoints++;
                            } else if (resultc5 < 0) {
                                System.out.println("BOT won this round");
                                computerPoints++;
                            }
                            System.out.println("Now round 2");
                            System.out.println("----------------------");
                            System.out.println("Your cards:");
                            System.out.println("---------------------------------------");
                            System.out.println("a. " + card1);
                            System.out.println("b. " + card2);
                            System.out.println("Please enter your card: ");
                            User = scan.next();
                            char roundc2 = User.charAt(0);
                            {
                                if (roundc2 == 'b') {//if the user decides to play card b
                                    int resultb4 = card2.compareTo(card5);
                                    System.out.println("You played " + card2);
                                    System.out.println("Computer played " + card5);
                                    if (resultb4 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    } else if (resultb4 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    } else if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //if the game is 1/1 there is a third round
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card1);
                                        int resulta4 = card1.compareTo(card6);
                                        if (resulta4 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        } else if (resulta4 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                }
                                if (roundc2 == 'a') {//if the user decides to play a
                                    int resulta5 = card1.compareTo(card5);
                                    System.out.println("you played " + card1);
                                    System.out.println("BOT played " + card5);
                                    if (resulta5 > 0) {
                                        System.out.println("you won this round!");
                                        userPoints++;
                                    } else if (resulta5 < 0) {
                                        System.out.println("BOT won this round!");
                                        computerPoints++;
                                    }
                                    //Checking if either Player or BOT has 2 points
                                    if (userPoints == 2) {
                                        System.out.println("you won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    } else if (computerPoints == 2) {
                                        System.out.println("BOT won this match!");
                                        System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                        Player = scan.next();
                                        menu = Player.charAt(0);
                                    }
                                    //if the game is 1/1 there is a third round
                                    if (computerPoints != 2 && userPoints != 2) {
                                        System.out.println("Now round 3");
                                        System.out.println("----------------------");
                                        System.out.println("Bot played " + card6);
                                        System.out.println("Your cards:");
                                        System.out.println("---------------------------------------");
                                        System.out.println("You played " + card2);
                                        int resultb6 = card2.compareTo(card6);
                                        if (resultb6 > 0) {
                                            System.out.println("you won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        } else if (resultb6 < 0) {
                                            System.out.println("BOT won this match!");
                                            System.out.println("Do you want to exit? press 'e' but if you want to come back to the main menu press any button");
                                            Player = scan.next();
                                            menu = Player.charAt(0);
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        }
                    }
                }
            }
                        break;
                case 'e': {//exiting the game.
                    System.out.println("Ok, you are exiting the game...");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid entry");
            }
            }
        }
    }

