//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Composition and bot Spec

//Composition
//With composition i can reuse instance variables in other classes
//This class is a subclass of the interface BotSystem.
public class Bot implements BotSystem{
    private BotSpec botspec;
    
    int gear = 0;
    int batteryPower = 0;
    
    public Bot(String name, String Chassis){
        this.botspec = new BotSpec();
        botspec.setName(name);
        botspec.setChassis(Chassis);
    }
    
    public String getBotName()
    {
        return botspec.getName();
    }
    
    public String getBotChassis()
    {
        return botspec.getChassis();
    }
    
    public void changeGear(int gear){
        this.gear = gear;
    }
    
    public void chargePower(int batteryPower){
        this.batteryPower = this.batteryPower - batteryPower;
    }
    
    public void rechargePower(int batteryPower){
        this.batteryPower = this.batteryPower + batteryPower;
    }
    
    public void printDeploy(){
        System.out.println(botspec.getName() + " changed to gear 2 and it is deploying battery! Be careful.");
    }
    
    public void printRechar(){
        System.out.println(botspec.getName() + " changed to gear 1 and it is recharging! For now you can breathe.");
    }
}
