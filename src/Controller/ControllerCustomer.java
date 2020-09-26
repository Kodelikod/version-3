package Controller;
import Model.ModelCustomer;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCustomer {

    private ArrayList<ModelCustomer> customerList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);


    //Method add customer
    public void registerCustomer() { //A customer has a unique id and a name
        System.out.println("Registering new customer \nEnter name of the customer: ");
        ModelCustomer newCustomer = new ModelCustomer(input.nextLine(), idGenerator());

        customerList.add(newCustomer);
        System.out.println();
        System.out.println("You have successfully added a new customer" + newCustomer.toString());
    }

    public ArrayList<ModelCustomer> getCustomerList() {
        return this.customerList;
    }

    public int idGenerator() {// to find four-digit number
        int idleId = 2000;

        for (int i = 0; i < customerList.size(); i++) { //search through entire arraylist of userDatabase
            if (customerList.get(i).getUserId() == idleId) { //when idleId matches with already existing user in userDatabase
                idleId++;
                i = 0; //start at i=0 with new id number
            } else {
                i++; //next index in arraylist
            }
        }
        return idleId;
        }

        public void removeCustomer(){
            System.out.println("Removing customer account \nEnter customer ID: ");
            int idRemoval = input.nextInt();
            input.nextLine();
            for (int i = 0; i < customerList.size(); i++) { //search though arraylist for...
                if (customerList.get(i).getUserId() == idRemoval) { //...account with same userID as the one given by user
                    customerList.remove(i); // remove when found
                    for (int j = 0; j < customerList.size(); i++) { //is it removed? go through arraylist again
                        if (!(customerList.get(j).getUserId() == idRemoval)) { //if it does not exist...
                            System.out.println("Customer with ID " + idRemoval + " successfully removed."); //... then its removed, let the user know
                        }
                    }
                }
            }

        }
    }


