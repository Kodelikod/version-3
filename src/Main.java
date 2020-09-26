import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerGame;
import View.ViewCustomer;
import View.ViewEmployee;
import View.ViewMain;
import View.ViewManager;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        ControllerCustomer controllerCustomer = new ControllerCustomer(); // BARA ETT OBJECT PER CONTROLLER SOM SKA VARA I MAIN. HÄMTAS DESSA SOM PARAMETRAR I METODER. ANNAR SKAPAS FLERA LISTOR!
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        ControllerGame controllerGame = new ControllerGame();
        ViewMain viewMain = new ViewMain();//VIEW KAN SKAPAS PÅ FLERA STÄLLEN FÖR DET HÄNDER INGET, ingen data förändras osv.
        ViewCustomer viewCustomer = new ViewCustomer();
        ViewManager viewManager = new ViewManager();
        ViewEmployee viewEmployee = new ViewEmployee();

        viewMain.welcome(controllerEmployee, controllerGame, controllerCustomer);


    }
}

