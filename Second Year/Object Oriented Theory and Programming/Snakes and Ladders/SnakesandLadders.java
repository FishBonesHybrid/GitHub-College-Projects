//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Main Method.

//Main method
//Importing
import java.util.*;
import java.io.*;

public class SnakesandLadders {

    public static void main(String[] args) {
        //Variables
        String user, cobrasound;
        int loss = 0, i = 0, j = 0;
        
        //player analysis
        String playerColor = "";
        int prl = 0, pwl = 0, pgl = 0, pcs = 0, pms = 0, pas = 0;
        
        //Bot analysis
        int brl = 0, bwl = 0, bgl = 0, bcs = 0, bms = 0, bas = 0;

        //Scanner and colling the other classes
        Scanner scan = new Scanner(System.in);//Scanner
        Player player = new Player();
        Random rand = new Random();
        SnakeAtt att = new SnakeAtt(18, "Brazil");
        Snake s1 = new Snake("Fluffy", att);
        Snake s2 = new Snake("Severus", att);
        Snake s3 = new Snake("Medusa", att);
        boolean menu = true, color = true;

        //While loop for the main menu
        while (menu == true) {
            boolean game = true;

            //Main Menu
            System.out.println("Welcome to Snakes and ladders");
            System.out.println("Please tell me what you want to do:");
            System.out.println("P - Play game.");
            System.out.println("R - Read Rules.");
            System.out.println("S - Snakes and Ladders");
            System.out.println("E - Exit.");

            user = scan.nextLine();

            //Play game
            if (user.equals("P") || user.equals("p")) {
                String playerName, playerSurname, playerDecision;
                Bot bot = new Bot("", "");
                int playerPos = 0, botPos = 0, playerDice = 0, botDice = 0;
                bot.batteryPower = 0;

                //That's where the player is going to pub the informations and choose its colour.
                System.out.println("Playing game.");
                System.out.print("Please enter your name: ");
                playerName = scan.nextLine();
                System.out.print("Please enter your surname: ");
                playerSurname = scan.nextLine();
                player.setName(playerName);
                player.setSurname(playerSurname);
                System.out.println("Hello! " + player.getName() + " " + player.getSurname());
                while (color == true) {
                    color = true;
                    System.out.println("Please enter the color that you want to play:");
                    System.out.println("G - Green\nB - Blue\nW - White\nO - Orange");
                    playerDecision = scan.nextLine();

                    //If Statement, This will decide what color the player wants and what color the but will be.
                    if (playerDecision.equals("G") || playerDecision.equals("g")) {
                        System.out.println("Ok you are playing with green.");
                        playerColor = "Green";
                        //Setting up the bot.
                        bot = new Bot("GBR7", "Blue");
                        color = false;
                    } else if (playerDecision.equals("B") || playerDecision.equals("b")) {
                        System.out.println("Ok you are playing with blue.");
                        playerColor = "Blue";
                        //Setting up the bot.
                        bot = new Bot("RSF2", "Red");
                        color = false;
                    } else if (playerDecision.equals("W") || playerDecision.equals("w")) {
                        System.out.println("Ok you are playing with white.");
                        playerColor = "White";
                        //Setting up the bot.
                        bot = new Bot("TPGB", "Black");
                        color = false;
                    } else if (playerDecision.equals("O") || playerDecision.equals("o")) {
                        System.out.println("Ok you are playing with orange.");
                        playerColor = "Orange";
                        //Setting up the bot.
                        bot = new Bot("MACP", "Silver");
                        color = false;
                    } else {
                        System.out.println("Invalid Entry, try again");
                    }
                }
                //Bot setup
                System.out.print("Your oponent's name is: ");
                System.out.println(bot.getBotName());
                System.out.println("Color: " + bot.getBotChassis());
                //Loop to play the game but later

                //While here
                while (game == true) {
                    //Player Turn
                    System.out.println("\nPlayer turn: ");
                    System.out.println("Press any button to roll the dice");
                    playerDecision = scan.nextLine();
                    playerDice = rand.nextInt(6) + 1;
                    playerPos = playerPos + playerDice;
                    System.out.println("Your dice was: " + playerDice);
                    System.out.println("Your position right now is: " + playerPos);

                    //Ladders
                    //Red Ladder
                    if (playerPos == 5 || playerPos == 14 || playerPos == 48 || playerPos == 62) {
                        Ladder red = new LadderRed();
                        System.out.print("You found the ladder of color ");
                        red.ladderColor();
                        System.out.println(", you have gained: " + red.ladderGain() + " positions.");
                        playerPos = playerPos + red.ladderGain();
                        prl += 1;
                    }

                    //White Ladder
                    if (playerPos == 6 || playerPos == 24 || playerPos == 43 || playerPos == 77) {
                        Ladder white = new LadderWhite();
                        System.out.print("You found the ladder of color ");
                        white.ladderColor();
                        System.out.println(", you have gained: " + white.ladderGain() + " positions.");
                        playerPos = playerPos + white.ladderGain();
                        pwl += 1;
                    }

                    //Green Ladder
                    if (playerPos == 33 || playerPos == 83) {
                        Ladder green = new LadderGreen();
                        System.out.print("You found the ladder of color ");
                        green.ladderColor();
                        System.out.println(", you have gained: " + green.ladderGain() + " positions.");
                        playerPos = playerPos + green.ladderGain();
                        pgl += 1;
                    }

                    //Snakes
                    //Cobra
                    if (playerPos == 11 || playerPos == 13 || playerPos == 17 || playerPos == 49 || playerPos == 60 || playerPos == 84 || playerPos == 99) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s1.display();
                        loss = Snakes.dCobra();
                        System.out.println("Type: " + Snakes.Cobra + "\nJust appeared." + "\nYou are going to lose " + loss + " positions.");
                        playerPos = playerPos - loss;
                        pcs += 1;
                    }

                    //Mamba
                    if (playerPos == 21 || playerPos == 42 || playerPos == 61 || playerPos == 86) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s2.display();
                        loss = Snakes.dMamba();
                        System.out.println("Type: " + Snakes.Mamba + "\nJust appeared." + "\nYou are going to lose " + loss + " positions.");
                        playerPos = playerPos - loss;
                        pms += 1;
                    }

                    //Anaconda
                    if (playerPos == 37 || playerPos == 44 || playerPos == 78 || playerPos == 91 || playerPos == 94) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s3.display();
                        loss = Snakes.dAna();
                        System.out.println("Type: " + Snakes.Anaconda + "\nJust appeared." + "\nYou are going to lose " + loss + " positions.");
                        playerPos = playerPos - loss;
                        pas += 1;
                    }

                    //Player Position
                    System.out.println("Your position at the end of this round is: " + playerPos);

                    if (playerPos >= 100) {
                        System.out.println("You win!");
                        game = false;
                    }

                    //Bot turn
                    System.out.println("\nBot turn: ");
                    System.out.println("This is bot battery right now: " + bot.batteryPower);
                    //Switch the move of the bot
                    if (bot.batteryPower == 0) {

                        bot.printRechar();
                        bot.changeGear(1);
                    }
                    if (bot.batteryPower == 100) {
                        bot.printDeploy();
                        bot.changeGear(2);
                    }

                    //Bot dices
                    if (bot.gear == 1) {
                        botDice = rand.nextInt(5) + 1;
                        botPos = botPos + botDice;
                        bot.rechargePower(25);
                    }
                    if (bot.gear == 2) {
                        botDice = rand.nextInt(4) + 3;
                        botPos = botPos + botDice;
                        bot.chargePower(25);
                    }

                    System.out.println(bot.getBotName() + " dice is: " + botDice);
                    System.out.println(bot.getBotName() + " position right now is: " + botPos);

                    //Ladder
                    //Red letter
                    if (botPos == 5 || botPos == 14 || botPos == 48 || botPos == 62) {
                        Ladder red = new LadderRed();
                        System.out.print(bot.getBotName() + " has found the ladder of color ");
                        red.ladderColor();
                        System.out.println(", it has gained: " + red.ladderGain() + " positions.");
                        botPos = botPos + red.ladderGain();
                        brl += 1;
                    }

                    //White letter      
                    if (botPos == 6 || botPos == 24 || botPos == 43 || botPos == 77) {
                        Ladder white = new LadderWhite();
                        System.out.print(bot.getBotName() + " has found the ladder of color ");
                        white.ladderColor();
                        System.out.println(", it has gained: " + white.ladderGain() + " positions.");
                        botPos = botPos + white.ladderGain();
                        bwl += 1;
                    }

                    //Green letter
                    if (botPos == 33 || botPos == 83) {
                        Ladder green = new LadderGreen();
                        System.out.print(bot.getBotName() + " has found the ladder of color ");
                        green.ladderColor();
                        System.out.println(", it has gained: " + green.ladderGain() + " positions.");
                        botPos = botPos + green.ladderGain();
                        bgl += 1;
                    }

                    //Snakes
                    //Cobra
                    if (botPos == 11 || botPos == 13 || botPos == 17 || botPos == 49 || botPos == 60 || botPos == 84 || botPos == 99) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s1.display();
                        loss = Snakes.dCobra();
                        System.out.println("Type: " + Snakes.Cobra + "\nJust appeared." + "\n" + bot.getBotName() + " is going to lose " + loss + " positions.");
                        botPos = botPos - loss;
                        bcs += 1;
                    }

                    //Mamba 
                    if (botPos == 21 || botPos == 42 || botPos == 61 || botPos == 86) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s2.display();
                        loss = Snakes.dMamba();
                        System.out.println("Type: " + Snakes.Mamba + "\nJust appeared." + "\n" + bot.getBotName() + " is going to lose " + loss + " positions.");
                        botPos = botPos - loss;
                        bms += 1;
                    }

                    //Anaconda
                    if (botPos == 37 || botPos == 44 || botPos == 78 || botPos == 91 || playerPos == 94) {
                        cobrasound = s1.getSound();
                        System.out.println(cobrasound);
                        s3.display();
                        loss = Snakes.dAna();
                        System.out.println("Type: " + Snakes.Anaconda + "\nJust appeared." + "\n" + bot.getBotName() + " is going to lose " + loss + " positions.");
                        botPos = botPos - loss;
                        bas += 1;
                    }
                    //Bot position
                    System.out.println(bot.getBotName() + " position for this round is " + botPos + ".");

                    //Next Round
                    System.out.println("------- Next Round -------");

                    //Bot wins
                    if (botPos >= 100) {
                        System.out.println(bot.getBotName() + " wins! Better luck next time\n");
                        game = false;
                    }
                }

                //Creating the file
                try{
                BufferedWriter analysis = new BufferedWriter(new FileWriter("/Users/viniparzanini/OneDrive - Limerick Institute Of Technology/Second Year/First Semester/Object Oriented Theory and Programming/Project/SnakesandLadders/src/Last Game Stats/Records.txt"));
                
                //Player analysis
                analysis.write("Player Name: " + player.getName() + ".\n");
                analysis.write("Player Surname: " + player.getSurname() + ".\n");
                analysis.write("Color Chosen: " + playerColor + ".\n");
                analysis.write("Position Finished: " + playerPos + ".\n");
                analysis.write("Red ladder found: " + prl + ".\n");
                analysis.write("White ladder found: " + pwl + ".\n");
                analysis.write("Green ladder found: " + pgl + ",\n");
                analysis.write("Snake type cobra found: " + pcs + ".\n");
                analysis.write("Snake type mamba found: " + pms + ".\n");
                analysis.write("Snake type anaconda found: " + pas + ".\n");
                
                //Bot Analysis
                analysis.write("\n");
                analysis.write("Bot Analysis:\n");
                analysis.write("Bot Name: " + bot.getBotName() + ".\n");
                analysis.write("Bot Color: " + bot.getBotChassis() + ".\n");
                analysis.write("Position Finished: " + botPos + ".\n");
                analysis.write("Red ladder found: " + brl + ".\n");
                analysis.write("White ladder found: " + bwl + ".\n");
                analysis.write("Green ladder found: " + bgl + ",\n");
                analysis.write("Snake type cobra found: " + bcs + ".\n");
                analysis.write("Snake type mamba found: " + bms + ".\n");
                analysis.write("Snake type anaconda found: " + bas + ".\n");
                analysis.close();
                }catch(Exception ex){
                    return;
                }
                
                //File recorded
                System.out.println("File Recorded.");
                
                //Rules
            } else if (user.equals("R") || user.equals("r")) {
                try {
                    BufferedReader rules = new BufferedReader(new FileReader("/Users/viniparzanini/OneDrive - Limerick Institute Of Technology/Second Year/First Semester/Object Oriented Theory and Programming/Project/SnakesandLadders/src/Rules.txt"));
                    String s;
                    while ((s = rules.readLine()) != null) {
                        System.out.println(s);
                    }
                    System.out.println("");
                    rules.close();
                } catch (Exception e) {
                    return;
                }
            } //Creating Ladders and Snakes
            //Collections
            else if (user.equals("S") || user.equals("s")) {
                //Collections
                //Snake's names
                ArrayList<Snakes> snakeType = new ArrayList<Snakes>();
                snakeType.add(Snakes.Cobra);
                snakeType.add(Snakes.Mamba);
                snakeType.add(Snakes.Anaconda);

                Iterator snake1 = snakeType.iterator();

                //Snake's positions loss
                ArrayList<Integer> snakePos = new ArrayList<Integer>();
                snakePos.add(Snakes.dCobra());
                snakePos.add(Snakes.dMamba());
                snakePos.add(Snakes.dAna());

                Iterator snake2 = snakePos.iterator();

                System.out.println("Type of Snakes and how many positions you lose if find them: ");
                while (snake1.hasNext()) {
                    System.out.print("Type: " + snake1.next() + " ,You are going to lose: ");
                    System.out.println(snake2.next() + " positions.");
                }

                //Skipping line
                System.out.println("");

                //Ladders
                //Ladders Color
                Vector<String> ladderColor = new Vector<String>();
                ladderColor.add("Red");
                ladderColor.add("White");
                ladderColor.add("Green");

                Iterator ladder1 = ladderColor.iterator();

                //ladders' positions gain
                ArrayList<Integer> ladderPos = new ArrayList<Integer>();
                ladderPos.add(5);
                ladderPos.add(12);
                ladderPos.add(17);

                Iterator ladder2 = ladderPos.iterator();

                System.out.println("Type of ladders and how many positions you gain if find them: ");
                while (ladder1.hasNext()) {
                    System.out.print("Type: " + ladder1.next() + " ,You are going to gain: ");
                    System.out.println(ladder2.next() + " positions.");
                }
                //Skip one line
                System.out.println("");
            } //Leaving the game
            else if (user.equals("E") || user.equals("e")) {
                System.out.println("Thank you! Leaving the game.");
                menu = false;
            } else {
                System.out.println("Invalid Entry!");
            }
        }
    }
}
