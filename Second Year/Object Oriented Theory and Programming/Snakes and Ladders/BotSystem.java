//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Interface and Bot behavior

//Interface
//For the I created the bot behavior.
public interface BotSystem {
    //For this one it is changeGear, when the Bot is deploying battery or not, if it is not its gear is going to be 1,
    //If it is deploying battery it is going to change the gear to 2.
    void changeGear(int newValue);
    
    //This one is going to add battery power to the bot.
    void chargePower(int newValue);
    
    //This one is going to deploy the battery power
    void rechargePower(int newValue);
    
    //Scenario when Bot is deploying battery.
    void printDeploy();
    
    //Scenario when Bot is recharging.
    void printRechar();
}
