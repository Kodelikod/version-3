package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerGame;

import java.text.ParseException;
import java.util.Scanner;

    public class ViewMain {
        private ViewManager viewManager = new ViewManager();
        private ViewEmployee viewEmployee = new ViewEmployee();
        private ViewCustomer viewCustomer = new ViewCustomer();

        private boolean running = true;

        public void welcome(ControllerEmployee controllerEmployee, ControllerGame controllerGame, ControllerCustomer controllerCustomer) throws ParseException {
            System.out.println("Welcome to DART, your good old game rental system. The competition has no steam to keep up");
            System.out.println("Please specify your role by entering one of the options given:");
            mainMenu(controllerEmployee, controllerGame, controllerCustomer);
        }

        public void mainMenu(ControllerEmployee controllerEmployee, ControllerGame controllerGame, ControllerCustomer controllerCustomer) throws ParseException {
            while(running){
                System.out.println("Main Menu");
                System.out.println ("1. Enter M for Manager");
                System.out.println ("2. Enter E for Employee");
                System.out.println ("3. Enter C for Customer");
                System.out.println ("4. Enter X to exit system");

                Scanner input = new Scanner (System.in);
                String inputMainMenu = input.nextLine();


                switch (inputMainMenu.toUpperCase().trim()) {
                    case "M":
                        viewManager.managerMenu(controllerEmployee, controllerGame, controllerCustomer, this);
                        break;
                    case "E":
                        viewEmployee.employeeMenu(controllerEmployee, controllerGame, controllerCustomer, this);
                        break;
                    case "C":
                        viewCustomer.customerMenu(controllerEmployee, controllerGame, controllerCustomer, this);
                        break;
                    case "X":
                        running = false;
                        break; // this break can be removed because the program ends by System.exit
                    default:
                        System.out.println("Invalid input, please try again.");
                        mainMenu(controllerEmployee, controllerGame, controllerCustomer);
                        break;
                }
            }
        }
    }



