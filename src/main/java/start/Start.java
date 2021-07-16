package start;

import presentation.Controller;
import presentation.View;

/**
 * @author Lidia Luncian
 * The Class Start contains the main method
 */
public class Start {

    /**
     * The main method.
     * @param args the arguments
     */
    public static void main(String[] args){
        View v = new View();
        Controller c = new Controller(v);

    }
}
