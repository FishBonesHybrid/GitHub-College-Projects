//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Abstract class and method.

//Data abstraction is the process of hiding certain details and showing only essential information to the user
//This one is the abstract class, this one is a restricted class that cannot be used to create objects.
//In order to access it, it must be inherited from another class). It means that this guys is a superclass
abstract class Sound {
    //Abstract method (does not have a body)
    //Can only be used in an abstract class. The body is provided by the subclass.
    //In this case I did the sound, which is just printing the sound of the snake.
    //However the System.out.println stuff can only be seen in the subclass.
    public abstract String getSound();
}
