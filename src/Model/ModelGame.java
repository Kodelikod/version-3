package Model;
import Controller.ControllerGame;

public class ModelGame {

        //attributes
        private int gameId;
        private String title;
        private String genre;
        private double dailyRentFee;
        private boolean available = true;


        //Declares a constructor with its states as parameters
        public ModelGame(int gameId, String title, String genre, double dailyRentFee) {
            //Initializing new game attributes
            this.gameId = gameId;
            this.title = title;
            this.genre = genre;
            this.dailyRentFee = dailyRentFee;

            //this.available;
        }

        // getters & setters
        public int getGameId(){
            return this.gameId;
        }
        public void setGameId(int anId){
            this.gameId = anId;
        }
        public String getTitle(){
            return this.title;
        }
        public void setTitle(String aTitle){
            this.title = aTitle;
        }
        public String getGenre(){
            return this.genre;
        }
        public void setGenre(String aGenre){
            this.genre = aGenre;
        }
        public double getDailyRentFee(){
            return this.dailyRentFee;
        }
        public void setDailyRentFee(double aDailyRentFee){
            this.dailyRentFee = aDailyRentFee;
        }
        public String getAvailable(){
            String available;
            if (this.available){
                available = "Available.";
            } else {
                available = "Not available at the moment.";
            }
            return available;

        }
        public void setAvailable(boolean availability){
            this.available = availability;
        }

        public String toString (){
            return "ID: " + this.getGameId() + System.lineSeparator() + "Title: " + this.getTitle() +
                    System.lineSeparator() + "Genre: " + this.getGenre() + System.lineSeparator() +
                    "Daily rent fee: $" + this.getDailyRentFee() + System.lineSeparator() + this.getAvailable();
        }
    }

