package midterm.patters;
/* Sean Patterson
 * CS249
 * Midterm
 * Spring 2020
 *
 * UML Diagram:
 *
 *  ----------------------------------------
 * |         ToDo List                      |
 *  ----------------------------------------
 * | - itemDateCreated - date               |
 * | - itemDateCompleted - date             |
 * | - itemTitle - string                   |
 * | - itemDescription - string             |
 * | - itemComplete - int / binary          |
 *  ----------------------------------------
 * | + markComplete()                       |
 * | + editItem()                           |
 * | + deleteItem()                         |
 * | + displayListOfItems()                 |
 * | + displayContentsOfItem()              |
 * | + displayMenu()                        |
 *  ----------------------------------------
 */

//import required classes
import java.util.Date;
import java.util.Scanner;


//declare todo class and private variables
public class Todo {
    private String itemTitle;
    private String itemDescription;
    private Date itemDateCreated;
    private Date itemDateCompleted;
    private int itemComplete;
    private int itemIndex = 0;

    //create new scanner
    Scanner input = new Scanner(System.in);


    //no arg constructor
    public Todo(){
        itemDateCreated = new Date();
    };


    //constructor to create a todo with a title, description, and complete status passed in
    public Todo(String todoTitle, String todoDescription, int todoComplete){
        //assign values to variables for the item
        itemIndex = itemIndex++;
        itemDateCreated = new Date();
        itemTitle = todoTitle;
        itemDescription = todoDescription;
        itemComplete = todoComplete;
        Date itemDateCompleted = new Date(0);

        System.out.println("Item added!\n"); //confirm that the item has been added

    }
    ;

    //getters
    public String getItemTitle() {
        return itemTitle;
    };

    public String getItemDescription(){
        return itemDescription;
    };

    public  Date getItemDateCreated(){
        return itemDateCreated;
    };

    public Date getItemDateCompleted() {return  itemDateCompleted;};

    public char getItemComplete() {
        if (itemComplete == 0)
            return ' ';
        else return 'X';
    };

    //setters
    public void setMarkComplete(){
        itemComplete = 1;
        itemDateCompleted = new Date();
        System.out.println("Item marked as complete\n");
    }

    public void setMarkIncomplete(){
        itemComplete = 0;
        itemDateCompleted = new Date(0);
        System.out.println("Item marked as incomplete\n");
    }

    public void setItemTitle(String todoTitle){
        itemTitle = todoTitle;
        System.out.println("Item title updated\n");
    }

    public void setItemDescription(String todoDescription){
        itemDescription = todoDescription;
        System.out.println("Item description updated\n");
    }


    }



