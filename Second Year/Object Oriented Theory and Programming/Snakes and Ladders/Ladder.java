//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function Polymorphism

//Polymorphism
//Created the class that is going to extend the Ladder.
//In this case i can call Ladder sth = new the ladder of the color that I want.
public class Ladder {
    public void ladderColor(){
        System.out.println("The Color of the ladder");
    }
    public int ladderGain(){
        return 10;
    }
}

//The three ladders
class LadderWhite extends Ladder{
    public void ladderColor(){
        System.out.print("White");
    }
    public int ladderGain(){
        return 12; 
    }
}

class LadderRed extends Ladder{
    public void ladderColor(){
        System.out.print("Red");
    }
    public int ladderGain(){
        return 5;
    }
}

class LadderGreen extends Ladder{
    public void ladderColor(){
        System.out.print("Green");
    }
    public int ladderGain(){
        return 17;
    }
}