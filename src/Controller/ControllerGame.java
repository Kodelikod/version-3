package Controller;

import Model.*;
import View.*;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

    public class ControllerGame{
        //ArrayList for storing all Game objects
        public ArrayList<ModelGame> allGames = new ArrayList<ModelGame>(); // Tog bort static?

        public void viewGameList(){
            for (int i = 0; i < allGames.size(); i++) {
                System.out.println(allGames.get(i).toString());
            }
        }

        // Method Register Game
        public void registerGame() {
            Scanner input = new Scanner(System.in);
            //Let's user enter new game's attributes
            System.out.println("Creating a Game. Please type the game’s:");
            System.out.println("Title:");
            String title = input.nextLine();
            System.out.println("Genre:");
            String genre = input.nextLine();
            System.out.println("Daily Rent Fee ($): ");
            double dailyRentFee = input.nextDouble();
            int gameId = this.allGames.size() + 1;
            //assigns ID to the number of the arraylist size + 1, and adds it to ArrayList ids
            ModelGame newGame = new ModelGame(gameId, title, genre, dailyRentFee);
            this.allGames.add(newGame);
            System.out.println("You have successfully added:" + "\n" + newGame.toString());
            //ViewMain.mainMenu();


            //for (int i = 0; i <allGames.size(); i++) {
                //if (!allGames.hasNext()) {

        }

            //input.close();


        public void rentingFeature() {
            Scanner input = new Scanner(System.in); //read input from user

            viewGameList();
            //for (int i = 0; i < allGames.size(); i++) {
                //this.toString();
            //}

            System.out.println("Please insert the game ID for the game you want to rent: ");
            int gameSearchID = input.nextInt();
            input.nextLine();

            for (int i = 0; i < allGames.size(); i++) {
                if (gameSearchID == allGames.get(i).getGameId()) {
                    System.out.println("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");

                    String answer = input.nextLine();
                    if (answer.toLowerCase().equals("y")) {
                        allGames.get(i).setAvailable(false);
                        System.out.println("You have successfully rented the game!");
                    } else {
                        rentingFeature();
                    }
                }
            }
        }

            public void removeGame(){
                int idRemoval;
                System.out.println("Removing game \nEnter game ID: ");
                Scanner input = new Scanner(System.in);
                idRemoval = input.nextInt();
                input.nextLine();
                for (int i = 0; i < allGames.size(); i++) {
                    if (allGames.get(i).getGameId() == idRemoval) {
                        allGames.remove(i);
                        for (int j = 0; j < allGames.size(); i++) { //is it removed? go through arraylist again
                            if (!(allGames.get(j).getGameId() == idRemoval)) { //if it does not exist...
                                System.out.println("Game with ID " + idRemoval + " successfully removed."); //... then its removed, let the user know
                            }
                        }
                    }
                }
            }

            //Method for finding dailyRentFee in a game from arraylist in Game.
            public ModelGame findGameById () {
                Scanner input = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter the ID of the game you wish to return:");
                int id = input.nextInt();  // Read user input of id
                for (ModelGame game : this.allGames) {
                    if (game.getGameId() == id) {
                        return game;
                    }
                }
                return null;
            }


        //Method for calculating how many days the customer rented a game. Private because this is not used in main.
            // Used type SimpleDateFormat and parse method. This method only return type long.

            private long daysBetween() throws ParseException {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the date of when you rented the game dd/MM/yyyy:");
                String dateReturn = input.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateReturn);
                long interval = new Date().getTime() - date.getTime();
                return TimeUnit.DAYS.convert(interval, TimeUnit.MILLISECONDS);
            }

            private void printTotalRentFee(long daysBetween, double dailyRentFee){
                double totalRentFee = daysBetween * dailyRentFee;

                System.out.println("You must pay: " + totalRentFee + "US Dollars");

            }

            //Stores total rent
            double totalRent; //Stores total rent for feature 6.3

            // Method for calculating total rent, used for calculating rent profit
            public void returnGame () throws ParseException { //ParseE: must be here for the parse method to run
                long days = daysBetween();
                ModelGame game = findGameById();
                game.setAvailable(true);
                printTotalRentFee(days, game.getDailyRentFee());
                totalRent = totalRent + (days * game.getDailyRentFee());
            }
            // Method total rent profit
            public void printTotalRentProfit () {
                System.out.println("The total rent profit is currently: " + totalRent + " US Dollars.");
            }


    }

