package Controller;
import Model.ModelEmployee;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerEmployee {

        public static ArrayList<ModelEmployee> employeeList = new ArrayList<>();
        private Scanner input = new Scanner(System.in);

        public void viewEmployeeList() {
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(employeeList.get(i).toString());
            }
        }

        // Method register employee
        public ModelEmployee registerEmployee() { //An Employee has a unique employee id, a name, a birth year, an address and a monthly gross salary
            ModelEmployee newEmployee = new ModelEmployee(0,null,0,0);
            newEmployee.setUserId(idGenerator());

            System.out.println("Registering new employee \nEnter name of the employee: ");
            newEmployee.setName(input.nextLine());

            System.out.println("Enter birth year: ");
            newEmployee.setBirthYear(input.nextInt());
            input.nextLine();

            System.out.println("Enter monthly gross salary");
            newEmployee.setGrossSalary(input.nextDouble());
            input.nextLine();

            employeeList.add(newEmployee);

            return newEmployee;
        }

        //Method for generating unique ID
        public int idGenerator() {// to find four-digit number
            int idleId = 1000;

            for (int i = 0; i < employeeList.size(); i++) { //search through entire arraylist of userDatabase
                if (employeeList.get(i).getUserId() == idleId) { //when idleId matches with already existing user in userDatabase
                    idleId++;
                    i = 0; //start at i=0 with new id number
                } else {
                    i++; //next index in arraylist
                }
            }
            return idleId;
        }

    //Method remove employee
        public void removeEmployee () {
            System.out.println("Removing employee account \nEnter employee ID: ");
            int idRemoval = input.nextInt();
            input.nextLine();

            for (int i = 0; i < employeeList.size(); i++) { //search though arraylist for...
                if (employeeList.get(i).getUserId() == idRemoval) { //...account with same userID as the one given by user
                    employeeList.remove(i); // remove when found
                            System.out.println("User with ID " + idRemoval + " successfully removed."); //... then its removed, let the user know
                        }
                    }
                }


            public void employeeNetSalary() {
                Scanner input = new Scanner(System.in); // we need values from the manager

                //Maybe the name value is not needed? Or should we leave it if we will have each
                // employee as an array then we could just call the information from that person into this method?
                System.out.println("Please type your employees name:");
                String name = input.nextLine();

                System.out.println("Please type hours worked in a year:"); //ask question
                double hPerYear = input.nextDouble(); // declare and store value from numbers, maybe decimal

                System.out.println("Please enter hourly pay rate $:");
                double hPayRate = input.nextDouble(); // same as above

                double grossPay = hPayRate * hPerYear; //
                double netSalaryOver100 = (grossPay * (0.7)); //

                if (grossPay <= 100000) {
                    System.out.println("Gross Pay is less than 100.000 $ per year, therefore the Net Salary is: " + grossPay + " $");
                } else {
                    System.out.println("Gross Pay is more than 100.000 $ per year and the Net Salary is: " + (netSalaryOver100) + " $");
                }

                input.close();
            }

            public void employeeBonus() {
                Scanner input = new Scanner(System.in);

                System.out.println("What is the employee's age?  ");

                double age = input.nextInt();
                int bonusPac1 = 4000;
                int bonusPac2 = 6000;
                int bonusPac3 = 7500;

                if (age < 22) {
                    System.out.println("The employee's bonus salary is " + bonusPac1 + "kr.");
                } else if (age >= 22 && age <= 30) {
                    System.out.println("The employee's bonus salary is " + bonusPac2 + "kr.");
                } else {
                    System.out.println("The employee's bonus salary is " + bonusPac3 + "kr.");
                }
            }
        }




