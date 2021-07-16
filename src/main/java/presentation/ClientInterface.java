package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ClientInterface class. It creates an interface for clients.
 * It contains 4 labels, 4 buttons and 4 text fields.
 */
public class ClientInterface {

    /**
     * The frame of the interface which contains the panel with the
     * buttons, labels and text fields.
     */
    JFrame clientFrame = new JFrame("Clients");
    /**
     * The panel with the buttons, labels and text fields.
     */
    JPanel clientPanel = new JPanel();

    /**
     * The label for the client's id
     */
    JLabel idClient = new JLabel("ID: ");
    /**
     * The label for the client's name
     */
    JLabel numeClient = new JLabel("Name: ");
    /**
     * The label for client's email
     */
    JLabel emailClient = new JLabel("Email: ");
    /**
     * The label for the client's address.
     */
    JLabel adresaClient = new JLabel("Address: ");

    /**
     * The text field box for client's id
     */
    JTextField idCl = new JTextField();
    /**
     * The text field box for client's name
     */
    JTextField numeCl = new JTextField();
    /**
     * The text field box for client's email
     */
    JTextField emailCl = new JTextField();

    /**
     * The text field box for client's address
     */
    JTextField adresaCl = new JTextField();

    /**
     * The button for inserting a new client in the database
     */
    JButton addNewClient = new JButton("Add");
    /**
     * The button for updating/ editing an existing client from tha database
     */
    JButton editClient = new JButton("Edit");
    /**
     * The button for deleting an existing client from the database
     */
    JButton deleteClient = new JButton("Delete");
    /**
     * The button for viewing the table of clients
     */
    JButton viewClient = new JButton("View");

    /**
     * Instantiates a new ClientInterface
     */
    public ClientInterface(){
        clientFrame.setVisible(true);
        clientFrame.setSize(500,200);
        clientFrame.setLocation(450,280);
        clientPanel.setLayout(null);


        idClient.setBounds(10, 20,100, 20);
        clientPanel.add(idClient);
        idCl.setBounds(60, 20, 150, 25);
        clientPanel.add(idCl);

        numeClient.setBounds(10, 55,100, 25);
        clientPanel.add(numeClient);
        numeCl.setBounds(60, 55, 150, 25);
        clientPanel.add(numeCl);

        emailClient.setBounds(10, 90,100, 25);
        clientPanel.add(emailClient);
        emailCl.setBounds(60, 90, 150, 25);
        clientPanel.add(emailCl);

        adresaClient.setBounds(10, 125,200, 25);
        clientPanel.add(adresaClient);
        adresaCl.setBounds(60, 125, 150, 25);
        clientPanel.add(adresaCl);

        addNewClient.setBounds(220,20,100,30);
        clientPanel.add(addNewClient);
        editClient.setBounds(220,60,100,30);
        clientPanel.add(editClient);
        deleteClient.setBounds(330,20,100,30);
        clientPanel.add(deleteClient);
        viewClient.setBounds(330,60,100,30);
        clientPanel.add(viewClient);

        clientFrame.add(clientPanel);
    }

    /**
     * Adds a listener to the Add button
     * @param ad the listener class that needs to be added
     */
    void addListener(ActionListener ad){
        addNewClient.addActionListener(ad);
    }

    /**
     * Adds a listener to the Edit button
     * @param ed the listener class that needs to be added
     */
    void editListener(ActionListener ed){
        editClient.addActionListener(ed);
    }

    /**
     * Adds a listener to the Delete button
     * @param de the listener class that needs to be added
     */
    void deleteListener(ActionListener de){
        deleteClient.addActionListener(de);
    }

    /**
     * Adds a listener to the View button
     * @param vi the listener class that needs to be added
     */
    void viewListener(ActionListener vi){
        viewClient.addActionListener(vi);
    }

    /**
     * Method that extracts the text from the idCl text field.
     * @return the id of the client
     */
    public String getIdClient(){
        return idCl.getText();
    }
    /**
     * Method that extracts the text from the numeCl text field.
     * @return the name of the client
     */
    public String getNumeClient(){
        return numeCl.getText();
    }
    /**
     * Method that extracts the text from the emailCl text field.
     * @return the email of the client
     */
    public  String getEmailClient(){
        return emailCl.getText();
    }
    /**
     * Method that extracts the text from the adresaCl text field.
     * @return the address of the client
     */
    public String getAdresaClient(){
        return adresaCl.getText();
    }
}

