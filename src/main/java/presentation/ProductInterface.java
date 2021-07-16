package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ProductInterface class. It creates a new interface for products which
 * contains 4 text fields and 4 buttons.
 */
public class ProductInterface {

    /**
     * productFrame is the frame of the interface.
     */
    JFrame productFrame = new JFrame("Products");
    /**
     * productPanel is the panel which contains all the buttons and labels
     * and text fields
     */
    JPanel productPanel = new JPanel();

    /**
     * Label for the Product's id.
     */
    JLabel idProdus = new JLabel("ID: ");
    /**
     * Label for the Product's name.
     */
    JLabel numeProdus = new JLabel("Name: ");
    /**
     * Label for the Product's price.
     */
    JLabel pretProdus = new JLabel("Price: ");
    /**
     * Label for the Product's quantity.
     */
    JLabel cantitateProdus = new JLabel("Quantity: ");

    /**
     * TextField for id.
     */
    JTextField id = new JTextField();
    /**
     * TextField for name
     */
    JTextField nume = new JTextField();
    /**
     * Textfield for price.
     */
    JTextField pret = new JTextField();
    /**
     * TextField for quantity.
     */
    JTextField cant = new JTextField();

    /**
     * Button for inserting a new product.
     */
    JButton addNewProduct = new JButton("Add");
    /**
     * Button for updating an existing product.
     */
    JButton editProduct = new JButton("Edit");
    /**
     * Button for deleting an existing product.
     */
    JButton deleteProduct = new JButton("Delete");
    /**
     * Button for viewing the table of products.
     */
    JButton viewProduct = new JButton("View");


    /**
     * The constructor instantiates a new ProductInterface
     */
    public ProductInterface(){
        productFrame.setVisible(true);
        productFrame.setSize(500,200);
        productFrame.setLocation(450,280);

        productPanel.setLayout(null);
        productFrame.add(productPanel);

        idProdus.setBounds(10, 20,100, 25);
        productPanel.add(idProdus);
        id.setBounds(60, 20, 100, 25);
        productPanel.add(id);

        numeProdus.setBounds(10, 55,100, 25);
        productPanel.add(numeProdus);
        nume.setBounds(60, 55, 100, 25);
        productPanel.add(nume);

        pretProdus.setBounds(10, 90,100, 25);
        productPanel.add(pretProdus);
        pret.setBounds(60, 90, 100, 25);
        productPanel.add(pret);

        cantitateProdus.setBounds(10, 135,100, 25);
        productPanel.add(cantitateProdus);
        cant.setBounds(60, 135, 100, 25);
        productPanel.add(cant);

        addNewProduct.setBounds(220,20,100,30);
        productPanel.add(addNewProduct);
        editProduct.setBounds(220,60,100,30);
        productPanel.add(editProduct);
        deleteProduct.setBounds(330,20,100,30);
        productPanel.add(deleteProduct);
        viewProduct.setBounds(330,60,100,30);
        productPanel.add(viewProduct);

    }

    /**
     * Adds a listener to the Add button
     * @param ad the listener class that needs to be added
     */
    void addListener(ActionListener ad){
        addNewProduct.addActionListener(ad);
    }

    /**
     * Adds a listener to the Edit button
     * @param ed the listener class that needs to be added
     */
    void editListener(ActionListener ed){
        editProduct.addActionListener(ed);
    }

    /**
     * Adds a listener to the Delete button
     * @param de  the listener class that needs to be added
     */
    void deleteListener(ActionListener de){
        deleteProduct.addActionListener(de);
    }

    /**
     * Adds a listener to the View button.
     * @param vi the listener class that needs to be added
     */
    void viewListener(ActionListener vi){
        viewProduct.addActionListener(vi);
    }

    /**
     * Method that extracts the text from the id text field.
     * @return the id of the product
     */
    String getIdProdus(){
        return id.getText();
    }

    /**
     * Method that extracts the text from the nume text field
     * @return the name of the product
     */
    String getNumeProdus(){
        return nume.getText();
    }

    /**
     * Method that extracts the text from the pret text filed
     * @return the price of the product
     */
    String getPretProdus(){
        return pret.getText();
    }

    /**
     * Method that extracts the text from the cant text field
     * @return the quantity of the product in stock.
     */
    String getCantitateProdus(){
        return cant.getText();
    }
}

