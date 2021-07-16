package bll;

import bll.validators.EmailValidator;
import bll.validators.IdClientValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ClientBLL class, it implements the business logic for the Client
 *
 */
public class ClientBLL {

    /**
     * A list of validators
     */
    private List<Validator<Client>> validators;
    /**
     * Declares a new clientDAO
     */
    private ClientDAO clientDAO;


    /**
     * Instantiates a new clientBLL
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new IdClientValidator());

        clientDAO = new ClientDAO();
    }

    /**
     * Searches a client by id
     * @param id the id of the client
     * @return the Client that matches the id
     */
    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Searches a client by name
     * @param nume the name of the client
     * @return the client that matches the given name
     */
    public Client findClientByNume(String nume){
        Client st = clientDAO.findByNume(nume);
        if (st == null) {
            throw new NoSuchElementException("The product with nume =" + nume + " was not found!");
            //JOptionPane.showMessageDialog(null,"No such product found!");
        }
        return st;
    }

    /**
     * Inserts a new client in the database
     * @param client a client
     */
    public void insertClient(Client client){

        for(Validator v: validators){
            v.validate(client);
        }
        clientDAO.insert(client);
    };

    /**
     * Deletes a client from the database
     * @param client a client
     */
    public void deleteClient(Client client){
        clientDAO.delete(client);
    }

    /**
     * Updates a client from the database
     * @param client a client
     */
    public void updateClient(Client client){
        clientDAO.update(client);
    }

    /**
     * Generates the table with the clients from the database
     * @return the table with the clients
     * @throws IllegalAccessException if the table couldn't be generated
     */
    public JTable generateTable() throws IllegalAccessException {
        List<Client> clients = clientDAO.findAll();
        for (Client c:clients){
            System.out.println(c);
        }
        return clientDAO.createTable(clients);
    }



}
