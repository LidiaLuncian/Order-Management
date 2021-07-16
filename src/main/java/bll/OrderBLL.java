package bll;

import dao.OrderDAO;
import model.Orders;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The OrderBLL class. Implements the business logic for Order
 */
public class OrderBLL {

    /**
     * It declares a new orderDAO
     */
    private OrderDAO orderDAO;

    /**
     * Instantiates a new OrderBLL
     */
    public OrderBLL(){
        orderDAO = new OrderDAO();
    }

    /**
     * Searches for an order by id
     * @param id the id of an order
     * @return the order that matches the id
     */
    public Orders findOrderById(int id){

        Orders st = orderDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Inserts a new order into the database
     * @param order the order
     */
    public void insertOrder(Orders order){
        orderDAO.insert(order);
    };

    /**
     * Deletes an order from the database
     * @param order an order
     */
    public void deleteOrder(Orders order){
        orderDAO.delete(order);
    }

    /**
     * Updates an order from the database
     * @param order an order
     */
    public void updateOrder(Orders order){
        orderDAO.update(order);
    }

    /**
     * Generates the table for the orders from the database
     * @return the table
     * @throws IllegalAccessException if the table can't be created
     */
    public JTable generateTable() throws IllegalAccessException {
        List<Orders> orders = orderDAO.findAll();
        for (Orders c:orders){
            System.out.println(c);
        }
        return orderDAO.createTable(orders);
    }
}
