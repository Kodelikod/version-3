package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerGame;

import java.text.ParseException;
import java.util.Scanner;

public class ViewManager{

    //public void managerPassword(ControllerEmployee controllerEmployee, ControllerGame controllerGame,
                            //ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {



    public void managerMenu(ControllerEmployee controllerEmployee, ControllerGame controllerGame, ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {

    Scanner input = new Scanner(System.in);

        System.out.println("Please enter your password:");
        String passwordM = input.nextLine();

        if (passwordM.equals("admin1234")) {
            System.out.println("Manager Screen - Type one of the options below:");
            System.out.println("1. Add an employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. View all employees");
            System.out.println("4. Return to Main Menu");

            int optionM = input.nextInt();
            if (optionM == 1) {
                controllerEmployee.registerEmployee();
            } else if (optionM == 2) {
                controllerEmployee.removeEmployee();
            } else if (optionM == 3) {
                controllerEmployee.viewEmployeeList();
            } else if (optionM == 4) {
                viewMain.mainMenu(controllerEmployee, controllerGame, controllerCustomer);
            } else {
                System.out.println("Invalid input, please try again");
                managerMenu(controllerEmployee, controllerGame, controllerCustomer, viewMain);
            }
        } else {
            System.out.println("Invalid password// mainMenu();"); //+ send back to main menu with method mainMenu();
        }
    }
}

