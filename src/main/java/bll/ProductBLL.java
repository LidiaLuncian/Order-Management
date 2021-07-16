package bll;

import dao.ProductDAO;
import model.Product;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ProductBLL class. Implements the business logic for Productx
 */
public class ProductBLL {

    /**
     * Declares a new productDAO
     */
    private ProductDAO productDAO;

    /**
     * Instantiates a new ProductBLL
     */
    public ProductBLL(){
        productDAO = new ProductDAO();
    }

    /**
     * Serches for a product depending on the id
     * @param id the id of the product
     * @return the product that matches the id
     */
    public Product findProductById(int id){
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Inserts a product into the database
     * @param product the product
     */
    public void insertProduct(Product product){
        productDAO.insert(product);
    };

    /**
     * Deletes a product from the database
     * @param product the product
     */
    public void deleteProduct(Product product){
        productDAO.delete(product);
    }

    /**
     * Updates a product from the database
     * @param product the product
     */
    public void updateProduct(Product product){
        productDAO.update(product);
    }

    /**
     * Searches for a product after his name
     * @param nume the name of the product
     * @return the product that matches the name
     */
    public Product findProductByNume(String nume){
        Product st = productDAO.findByNume(nume);
        if (st == null) {
            //throw new NoSuchElementException("The product with nume =" + nume + " was not found!");
            JOptionPane.showMessageDialog(null,"No such product found!");
        }
        return st;
    }

    /**
     * Generates the table for the products from the database
     * @return the table
     * @throws IllegalAccessException if the table can't be generated
     */
    public JTable generateTable() throws IllegalAccessException {

        List<Product> products = productDAO.findAll();
        for (Product c:products){
            System.out.println(c);
        }
        return productDAO.createTable(products);
    }
}
