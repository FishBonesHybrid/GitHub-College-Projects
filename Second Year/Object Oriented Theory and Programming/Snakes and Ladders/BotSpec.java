//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Composition and some instance variables.

//Composition
public class BotSpec {
    
    //These instance variables is going to be reused in Bot.
    private String name;
    private String chassisColor;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setChassis(String chassisColor){
        this.chassisColor = chassisColor;
    }
    
    public String getName(){
        return name;
    }
    
    public String getChassis(){
        return chassisColor;
    }
}
