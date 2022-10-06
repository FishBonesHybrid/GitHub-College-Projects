//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function Aggregation and Snake class

//This Snake class is a subclass of the abstract class sound.
public class Snake extends Sound{
    //Aggregation
    //Notice that I created SnakeAtt class, it is 2 data in once that aggregates the snake.
    
    //Instant Variables
    SnakeAtt snakeatt;//Sneak class using the aggregation.
    String name;
    
    
    public Snake(String name, SnakeAtt snakeatt){
        this.name = name;
        this.snakeatt = snakeatt;
    }
    
    void display()
    {
        System.out.print("Snake name: " + name);
        System.out.println("\nSnake age: " + snakeatt.age + "\nSnake comes from: " + snakeatt.country);
    }

    //Method override is used to override the superclass method and this one can be changed or access in the subclass.
    @Override 
    public String getSound()
    {
        return "hisssssssss!!!";
    }
}
