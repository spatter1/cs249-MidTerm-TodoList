package midterm.patters;/*
 * Sean Patterson
 * CS249
 * Midterm
 * Spring 2020
 *
 * ToDo list with the following features:
 * The ability to mark items as complete(you need each item to be its own object)
 * The ability to edit items
 * The ability to delete items
 * The ability to add as many objects as I want
 * The ability to list the ToDo list to the screen
 * The ability to select the item in the list and display the contents of the item
 * Item structure
 * Title (display when listing the item)
 * Description of what you want to do within the item
 * Date created
 * Date Completed
 * Whether the task is completed or not(also displayed when listing the item.)
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


import java.util.ArrayList;
import java.util.Scanner;

public class midterm {


    public static void main(String [] args){

        TodoMenu.displayMenu(); //run the main class file

    }
}

