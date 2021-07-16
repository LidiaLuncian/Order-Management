package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The OrderInterface class. It creates a new interface for the Order class.
 * It contains 4 labels, 4 text fields and 5 buttons.
 */
public class OrderInterface {

    /**
     * The frame of the interface.
     */
    JFrame orderFrame = new JFrame("Orders");
    /**
     * The panel which contains the buttons, labels and text fields.
     */
    JPanel orderPanel = new JPanel();

    /**
     * The id label
     */
    JLabel idOrder = new JLabel("ID: ");
    /**
     * CLient's name label
     */
    JLabel numeClient = new JLabel("Client name: ");
    /**
     * Product's name label
     */
    JLabel numeProdus = new JLabel("Product name: ");
    /**
     * Quantity's label.
     */
    JLabel cantitateComanda = new JLabel("Quantity: ");

    /**
     * Id's text field box.
     */
    JTextField id = new JTextField();
    /**
     * Client's name text field box.
     */
    JTextField numeCl = new JTextField();
    /**
     * Product's name text field box
     */
    JTextField numePr = new JTextField();
    /**
     * Quantity's text field box.
     */
    JTextField cant = new JTextField();

    /**
     * The button for inserting a new Order
     */
    JButton addNewOrder = new JButton("Add");
    /**
     * The button for updating an order
     */
    JButton editOrder = new JButton("Edit");
    /**
     * The button for deleting an order
     */
    JButton deleteOrder = new JButton("Delete");
    /**
     * The button for viewing the table of orders
     */
    JButton viewOrders = new JButton("View");
    /**
     * The button generating the bill.
     */
    JButton generateBill = new JButton("Bill");


    /**
     * Instantiates the OrderInterface.
     */
    public OrderInterface(){
        orderFrame.setVisible(true);
        orderFrame.setSize(500,200);
        orderFrame.setLocation(450,280);

        orderPanel.setLayout(null);
        orderFrame.add(orderPanel);

        idOrder.setBounds(10, 20,100, 25);
        orderPanel.add(idOrder);
        id.setBounds(90, 20, 150, 25);
        orderPanel.add(id);

        numeClient.setBounds(10, 55,100, 25);
        orderPanel.add(numeClient);
        numeCl.setBounds(90, 55, 150, 25);
        orderPanel.add(numeCl);

        numeProdus.setBounds(10, 90,100, 25);
        orderPanel.add(numeProdus);
        numePr.setBounds(90, 90, 150, 25);
        orderPanel.add(numePr);

        cantitateComanda.setBounds(10, 125,100, 25);
        orderPanel.add(cantitateComanda);
        cant.setBounds(90, 125, 150, 25);
        orderPanel.add(cant);

        addNewOrder.setBounds(250,20,100,30);
        orderPanel.add(addNewOrder);
        editOrder.setBounds(250,60,100,30);
        orderPanel.add(editOrder);
        deleteOrder.setBounds(250,100,100,30);
        orderPanel.add(deleteOrder);
        viewOrders.setBounds(350,20,100,30);
        orderPanel.add(viewOrders);
        generateBill.setBounds(350,60,100,30);
        orderPanel.add(generateBill);

    }

    /**
     * Adds a listener to the Add button
     * @param ad the listener class that needs to be added
     */
    void addListener(ActionListener ad){
        addNewOrder.addActionListener(ad);
    }

    /**
     * Adds a listener to the Edit button
     * @param ed the listener class that needs to be added
     */
    void editListener(ActionListener ed){
        editOrder.addActionListener(ed);
    }

    /**
     * Adds a listener to the Delete button
     * @param de the listener class that needs to be added
     */
    void deleteListener(ActionListener de){
        deleteOrder.addActionListener(de);
    }

    /**
     * Adds a listener to the View button
     * @param vi the listener class that needs to be added
     */
    void viewListener(ActionListener vi){
        viewOrders.addActionListener(vi);
    }

    /**
     * Adds a listener to the Bill button
     * @param gb the listener class that needs to be added
     */
    void generateBillListner(ActionListener gb){generateBill.addActionListener(gb);}


    /**
     * Method that extracts the text from the id text field.
     * @return the id of the order
     */
    String getIdOrder(){
        return id.getText();
    }

    /**
     * Method that extracts the text from the numeCl text field.
     * @return the name of the client
     */
    String getNumeClientOrder(){
        return numeCl.getText();
    }

    /**
     * Method that extracts the text from the numePr text field.
     * @return the name of the product
     */
    String getNumeProdusOrder(){
        return numePr.getText();
    }

    /**
     * Method that extracts the text from the cant text field.
     * @return the quantity of the product
     */
    String getCantitateComandaOrder(){
        return cant.getText();
    }
}


