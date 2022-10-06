//Name: Vinicius Parzanini
//Date: 11/12/2021
//Function: Player Class and Encapsulation.

//Encapsulation
//Encapsulation is a mechanism of wrapping the data and code acting on the data together as a single unit.
public class Player {
    private String name;
    private String surname;
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setSurname(String newSurname){
        surname = newSurname;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
}
