//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Enumarations.

//Public Enum
//Enumarations serve the purpose of representing a group of named constants.
//For Enumarations I did the type of the snakes. There are three of them.
public enum Snakes{
    Cobra,
    Mamba,
    Anaconda;
    
    //This one is the amount of the positions that the bot or player loses.
    //Notice that i created static and final, the static the memory is allocated only once and not every time
    //Final it is not mutable, it is gonna be this number and FINAL.
    public static final int cobra = 10;
    public static final int mamba = 20;
    public static final int anaconda = 25;
    
    //These methods can be acessed without using the Snakes object.
    static int dCobra(){
        return cobra;
    }
    
    static int dMamba(){
        return mamba;
    }
    
    static int dAna(){
        return anaconda;
    }
}
