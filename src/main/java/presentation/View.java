package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The class View contains 3 buttons from which you can choose
 * to make changes to Client, Order or Product
 */
public class View extends JFrame {

    /**
     * The main frame for the buttons.
     */
    JFrame mainFrame=new JFrame("Warehouse");
    /**
     * The panel which contains the buttons.
     */
    JPanel panel = new JPanel();

    /**
     * The button for accessing the Client interface.
     */
    JButton clientB = new JButton("Clients");
    /**
     * The button for accessing the Product interface.
     */
    JButton productB = new JButton("Products");
    /**
     * The button for accessing the Orders interface.
     */
    JButton orderB = new JButton("Orders");

    /**
     * Instantiates a new view.
     */
    public View() {


        mainFrame.setVisible(true);
        mainFrame.setSize(300, 200);
        mainFrame.setLocation(500,280);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel.setLayout(null);
        mainFrame.add(panel);


        clientB.setBounds(90, 20, 100, 30);
        productB.setBounds(90, 60,100,30);
        orderB.setBounds(90,100,100,30);

        panel.add(clientB);
        panel.add(orderB);
        panel.add(productB);


    }

    /**
     * Adds a listener to the Client button
     * @param cl the listener class that needs to be added
     */
    void clientListener(ActionListener cl){
        clientB.addActionListener(cl);
    }

    /**
     * Adds a listener to the Product button
     * @param pr the listener class that needs to be added
     */
    void productListener(ActionListener pr){
        productB.addActionListener(pr);
    }

    /**
     * Adds a listener to the Order button
     * @param or the listener class that needs to be added
     */
    void orderListener(ActionListener or){
        orderB.addActionListener(or);
    }

}
