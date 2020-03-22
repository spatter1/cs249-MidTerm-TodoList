package midterm.patters;
/* Sean Patterson
 * CS249
 * Midterm
 * Spring 2020
 */

//import required classes
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


public class TodoMenu {

    public static void displayMenu() {

        //create an array list of the type Todo
        ArrayList<Todo> myToDoAL = new ArrayList<Todo>();

        //create new scanner and initialize menu selection variable
        Scanner input = new Scanner(System.in);
        int menuSelection = 0;

        //display the menu unless 9 has been selected
        while (menuSelection != 9) {
            displayLine();
            System.out.println("*\t\t\t\tThe ToDo List\t\t\t\t*");
            displayLine();
            System.out.println("* Select a menu item:\t\t\t\t\t\t*");
            twoStarLine();
            System.out.println("* 1. Create a new item.\t\t\t\t\t\t*"); //done
            System.out.println("* 2. Display list of items.\t\t\t\t\t*"); //done
            System.out.println("* 3. View an item.\t\t\t\t\t\t\t*");
            System.out.println("* 4. Edit an item.\t\t\t\t\t\t\t*");
            System.out.println("* 5. Delete an item.\t\t\t\t\t\t*");
            System.out.println("* 9. Quit program.\t\t\t\t\t\t\t*");
            twoStarLine();
            displayLine();

            System.out.print("What can I do for you?  Pick an option: ");

            //try - catch - prevent a crash on unacceptable input type
            try {
                //force an int entry at the menu
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.println("We don't serve that type here, please try again....");
                }
                menuSelection = input.nextInt();


                //switch statement to drive menu selection items
                switch (menuSelection) {

                    case 1: // create new item'
                        clearScreen();
                        System.out.println("Add a new todo item:\n");
                        System.out.print("Enter todo item title: ");
                        input.nextLine();
                        String itemTitle = input.nextLine();
                        System.out.print("Enter todo item description: ");
                        String itemDescription = input.nextLine();
                        int itemComplete = 0;
                        myToDoAL.add(new Todo(itemTitle, itemDescription, itemComplete));
                        break;

                    case 2: // display list of items
                        clearScreen();
                        System.out.println("Your todo list contains " + myToDoAL.size() + " items.");
                        System.out.printf("Item No  Complete  Title\n");
                        System.out.printf("-------  --------  --------------------------\n");

                        //iterate through the ArrayList of todo objects
                        Iterator<Todo> itr = myToDoAL.iterator();
                        int counter = 1; //counter used to reference todo items in the UI
                        while (itr.hasNext()) {
                            Todo listItem = itr.next();
                            System.out.printf("   %-5d\t[%1c]\t\t%s\n", counter, listItem.getItemComplete(), listItem.getItemTitle());

                            counter++;
                        }
                        System.out.println();

                        break;

                    case 3: // view an item
                        System.out.print("Select the item number that you would like to view: ");
                        int viewNumber = (input.nextInt() - 1);

                        //calling on the arraylist item to display
                        Todo viewTodo = myToDoAL.get(viewNumber);
                        itemTitle = viewTodo.getItemTitle();
                        itemDescription = viewTodo.getItemDescription();
                        Date itemCreateDate = viewTodo.getItemDateCreated();
                        itemComplete = viewTodo.getItemComplete();
                        clearScreen();

                        displayLine();
                        //routine to display the todolist item
                        System.out.print("*\t\t\tViewing item number " +(viewNumber+1) + "\t\t\t*\n");
                        displayLine();
                        System.out.println("* Title:\t\t\t" + itemTitle);
                        System.out.println("* Description:\t\t" + itemDescription);
                        System.out.printf("* Created on:\t\t%tA, %<tB %<te, %<tY %n", itemCreateDate);
                        System.out.print("* Item Complete:\t");
                        if (itemComplete == 88) {
                            System.out.println("Yes");
                            System.out.printf("* Date Completed:\t%tA, %<tB %<te, %<tY %n", viewTodo.getItemDateCompleted());
                        } else System.out.println("No");
                        displayLine();
                        System.out.println();

                        break;

                    case 4: // Edit an item
                        System.out.print("Select the item number that you would like to edit: ");
                        int editNumber = (input.nextInt() - 1);
                        clearScreen();
                        //routine to get the arraylist item
                        Todo returnTodo = myToDoAL.get(editNumber);
                        itemTitle = returnTodo.getItemTitle();
                        itemDescription = returnTodo.getItemDescription();
                        itemCreateDate = returnTodo.getItemDateCreated();
                        itemComplete = returnTodo.getItemComplete();

                        //routine to display the item
                        displayLine();
                        System.out.println("*\t\t\tEditing item number " +(editNumber+1)+ "\t\t\t*");
                        displayLine();
                        System.out.println("* Title:\t\t\t" + itemTitle);
                        System.out.println("* Description:\t\t" + itemDescription);
                        System.out.printf("* Created on:\t\t%tA, %<tB %<te, %<tY %n", itemCreateDate);
                        System.out.print("* Item Complete:\t");
                        if (itemComplete == 88) {
                            System.out.println("Yes");
                            System.out.printf("* Date Completed:\t%tA, %<tB %<te, %<tY %n", returnTodo.getItemDateCompleted());
                        } else System.out.println("No");
                        displayLine();
                        System.out.println("\n");

                        //show the menu options
                        displayLine();
                        System.out.println("* What would you like to edit?\t\t\t\t*");
                        twoStarLine();

                        //first option is different depending on if item is complete or not.
                        if (itemComplete == 88) {
                            System.out.println("* 1. Mark as incomplete\t\t\t\t\t\t*");
                        } else
                            System.out.println("* 1. Mark as complete\t\t\t\t\t\t*");

                        System.out.println("* 2. Edit title\t\t\t\t\t\t\t\t*");
                        System.out.println("* 3. Edit description\t\t\t\t\t\t*");
                        System.out.println("* 9. Return to previous menu\t\t\t\t*");
                        twoStarLine();
                        displayLine();
                        System.out.print("Your turn, pick a menu option: ");

                        //try - catch to prevent a crash
                        try {
                            int editMenuSelection = input.nextInt();

                            //switch statements to drive the edit menu options
                            switch (editMenuSelection) {
                                case 1:
                                    //toggle the item complete or not complete
                                    if (itemComplete == 88) {
                                        returnTodo.setMarkIncomplete();
                                        break;
                                    } else
                                        returnTodo.setMarkComplete();
                                    System.out.println();

                                    break;

                                case 2:
                                    //edit the title
                                    System.out.println("The title currently says: " + itemTitle);
                                    System.out.print("What would you like it to say: ");
                                    input.nextLine();
                                    returnTodo.setItemTitle(input.nextLine());
                                    break;

                                case 3:
                                    //edit the description
                                    System.out.println("The description currently says: " + itemDescription);
                                    System.out.print("What would you like it to say: ");
                                    input.nextLine();
                                    returnTodo.setItemDescription(input.nextLine());
                                    break;


                                case 9:
                                    break;

                                default:
                                    System.out.println("I didn't understand your choice, please try again.");
                            }


                        } catch (Exception e) {
                            System.out.println("Please read the options before selecting");
                        }
                        break;


                    case 5: //Delete an item
                        int removeItem;
                        System.out.print("Select item to remove: ");
                        removeItem = input.nextInt() - 1;
                        myToDoAL.remove(removeItem);
                        break;

                    case 9: // Quit program
                        System.out.println("Okay, quitting program... thanks for playing.");
                        break;

                    default: // default case
                        System.out.println("\nI didn't say that was an option! \n");
                }
            } catch (Exception e) {
                System.out.println("You must select a a menu option.  Try it again.");

            }

        }

    }

    //clear screen used to keep the screen somewhat neat.
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
    }

    //display line used to help with consistency in formatting
    public static void displayLine() {
        System.out.println("*-------------------------------------------*");
    }

    //two star line used for consistency in programming
    public static void twoStarLine(){
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t*");
    }
}
