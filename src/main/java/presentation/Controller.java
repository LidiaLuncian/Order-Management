package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Orders;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The Controller class. It implements the listeners for all the buttons from View,
 * ClientInterface, ProductInterface, OrderInterface.
 */
public class Controller {

    /**
     * The view
     */
    private View v;
    /**
     * The client interface
     */
    private ClientInterface ci;
    /**
     * The product interface
     */
    private ProductInterface pi;
    /**
     * The order interface
     */
    private OrderInterface oi;

    /**
     * Instantiates a new controller, adds listeners to the buttons from the View
     * @param v the view
     */
    public Controller(View v){
        this.v=v;
        v.clientListener(new ClientListener(ci));
        v.productListener(new ProductListener(pi));
        v.orderListener(new OrderListener(oi));

    }

    /**
     * Listener for the button Clients
     * It instantiates a new ClientInterface
     */
    static class ClientListener implements ActionListener {

        ClientInterface ci;

        public ClientListener(ClientInterface ci) {
            this.ci = ci;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            ci = new ClientInterface();
            ci.viewListener(new ViewClientListener(ci));
            ci.addListener(new AddNewClient(ci));
            ci.editListener(new EditClient(ci));
            ci.deleteListener(new DeleteClient(ci));
        }
    }

    /**
     * Listener for the View button from the client interface
     */
    static class ViewClientListener implements ActionListener{

        ClientInterface ci;

        public ViewClientListener(ClientInterface ci) {
            this.ci = ci;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            try {

                JTable t = clientBLL.generateTable();
                new TableInterface(t, "Clienti");
                //System.out.println("aici");
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();

            }
        }
    }

    /**
     * Listener for the Add button from the client's interface
     */
    static class AddNewClient implements ActionListener{

        ClientInterface ci;

        public AddNewClient(ClientInterface ci) {
            this.ci = ci;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nume, email,adresa,id;
            System.out.println("hahaha");
            id = ci.getIdClient();
            nume = ci.getNumeClient();
            email=ci.getEmailClient();
            adresa = ci.getAdresaClient();
            ClientBLL clientBLL = new ClientBLL();
            if(id.equals("")){
                Client c = new Client(nume,email,adresa);
                clientBLL.insertClient(c);
            }else{
                int idC = Integer.parseInt(id);
                Client c = new Client(idC, nume,email,adresa);
                clientBLL.insertClient(c);
            }
        }
    }

    /**
     * Listener for the Edit button from the client's interface
     */
    static class EditClient implements ActionListener{

        ClientInterface ci;

        public EditClient(ClientInterface ci) {
            this.ci = ci;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume, email,adresa,id;
            System.out.println("hahaha");
            id = ci.getIdClient();
            nume = ci.getNumeClient();
            email=ci.getEmailClient();
            adresa = ci.getAdresaClient();
            ClientBLL clientBLL = new ClientBLL();
            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }
            else{
                int idC = Integer.parseInt(id);
                Client c = new Client(idC, nume,email,adresa);
                clientBLL.updateClient(c);
            }


        }
    }

    /**
     * Listener for the Delete button from the client's interface
     */
    static class DeleteClient implements ActionListener{

        ClientInterface ci;

        public DeleteClient(ClientInterface ci) {
            this.ci = ci;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume, email,adresa,id;
            System.out.println("hahaha");
            id = ci.getIdClient();
            nume = ci.getNumeClient();
            email=ci.getEmailClient();
            adresa = ci.getAdresaClient();
            ClientBLL clientBLL = new ClientBLL();
            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }
            else{
                int idC = Integer.parseInt(id);
                Client c = new Client(idC, nume,email,adresa);
                clientBLL.deleteClient(c);
            }
        }
    }

    /**
     * Listener for the Product button from the  View
     * It instantiates a new ProductInterface
     */
    static class ProductListener implements ActionListener {

        ProductInterface pi;

        public ProductListener(ProductInterface pi) {
            this.pi = pi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            pi = new ProductInterface();
            pi.viewListener(new ViewProductListener(pi));
            pi.addListener(new AddProductListener(pi));
            pi.editListener(new EditProductListener(pi));
            pi.deleteListener(new DeleteProductListener(pi));

        }
    }

    /**
     * Listener for the view button from the product's interface
     */
    static class ViewProductListener implements ActionListener{

        ProductInterface pi;

        public ViewProductListener(ProductInterface pi) {
            this.pi = pi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            try {


                JTable t = productBLL.generateTable();
                // System.out.println("aici");
                new TableInterface(t, "Produse");

            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();

            }
        }
    }

    /**
     * Listener for the Add button from the product's interface
     */
    static class AddProductListener implements ActionListener{

        ProductInterface pi;

        public AddProductListener(ProductInterface pi) {
            this.pi = pi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            String id, numeProdus,pret,cantitate;
            System.out.println("hahaha");
            id = pi.getIdProdus();
            numeProdus = pi.getNumeProdus();
            pret = pi.getPretProdus();
            cantitate = pi.getCantitateProdus();

            ProductBLL productBLL = new ProductBLL();

            if(id.equals("")){
                int prett = Integer.parseInt(pret);
                int cant = Integer.parseInt(cantitate);
                Product p = new Product(numeProdus,prett,cant);
                productBLL.insertProduct(p);
            }else{
                int idC = Integer.parseInt(id);
                int prett = Integer.parseInt(pret);
                int cant = Integer.parseInt(cantitate);
                Product p = new Product(idC, numeProdus,prett,cant);
                productBLL.insertProduct(p);
            }
        }
    }

    /**
     * Listener for the Edit button from the product's interface
     */
    static class EditProductListener implements ActionListener{

        ProductInterface pi;

        public EditProductListener(ProductInterface pi) {
            this.pi = pi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String id, numeProdus,pret,cantitate;
            System.out.println("hahaha");
            id = pi.getIdProdus();
            numeProdus = pi.getNumeProdus();
            pret = pi.getPretProdus();
            cantitate = pi.getCantitateProdus();

            ProductBLL productBLL = new ProductBLL();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }else{
                int idC = Integer.parseInt(id);
                int prett = Integer.parseInt(pret);
                int cant = Integer.parseInt(cantitate);
                Product p = new Product(idC, numeProdus,prett,cant);
                productBLL.updateProduct(p);
            }
        }
    }

    /**
     * Listener for the Delete button from the product's interface
     */
    static class DeleteProductListener implements ActionListener{

        ProductInterface pi;

        public DeleteProductListener(ProductInterface pi) {
            this.pi = pi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String id;
            System.out.println("hahaha");
            id = pi.getIdProdus();

            ProductBLL productBLL = new ProductBLL();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }else{
                int idC = Integer.parseInt(id);
                Product p = new Product(idC);
                productBLL.deleteProduct(p);
            }

        }
    }

    /**
     * Listener for the Order button from the View
     * It instantiates a mew OrderInterface
     */
    static class OrderListener implements ActionListener {

        OrderInterface oi;

        public OrderListener(OrderInterface oi) {
            this.oi = oi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            oi = new OrderInterface();
            oi.viewListener(new ViewOrderListener(oi));
            oi.addListener(new AddOrderListener(oi));
            oi.editListener(new EditOrderListener(oi));
            oi.deleteListener(new DeleteOrderListener(oi));
            oi.generateBillListner(new GenerateBillListener(oi));
        }
    }

    /**
     * Listener for the view button from the order's interface
     */
    static class ViewOrderListener implements ActionListener{

        OrderInterface oi;

        public ViewOrderListener(OrderInterface oi) {
            this.oi = oi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderBLL orderBLL = new OrderBLL();
            try {

                System.out.println("aici");
                JTable t = orderBLL.generateTable();

                new TableInterface(t, "Orders");

            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();

            }
        }
    }

    /**
     * Listener for the Add button from the order's interface
     */
    static class AddOrderListener implements ActionListener{

        OrderInterface oi;

        public AddOrderListener(OrderInterface oi) {
            this.oi = oi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String id, numeProdus,numeClient, cantitate;
            System.out.println("hahaha");
            id = oi.getIdOrder();
            numeProdus = oi.getNumeProdusOrder();
            numeClient = oi.getNumeClientOrder();
            cantitate = oi.getCantitateComandaOrder();
            int cant = Integer.parseInt(cantitate);


            OrderBLL orderBLL = new OrderBLL();
            ClientBLL clientBLL = new ClientBLL();
            ProductBLL productBLL = new ProductBLL();
            Client client;
            Product produs;
            try{
                client = clientBLL.findClientByNume(numeClient);
                try{
                    produs = productBLL.findProductByNume(numeProdus);
                    if(produs.getCantitate() < cant){
                        JOptionPane.showMessageDialog(null,"Understock");
                    }
                    else{
                        if(id.equals("")){

                            Orders o = new Orders(numeClient, numeProdus, cant);
                            orderBLL.insertOrder(o);
                            produs.setCantitate(produs.getCantitate() - cant);
                            productBLL.updateProduct(produs);
                        }else{

                            int idC = Integer.parseInt(id);
                            Orders o = new Orders(idC, numeClient,numeProdus,cant);
                            orderBLL.insertOrder(o);
                            produs.setCantitate(produs.getCantitate() - cant);
                            productBLL.updateProduct(produs);
                        }
                    }
                }catch (IndexOutOfBoundsException ee){
                    JOptionPane.showMessageDialog(null,"Please introduce a valid client or product");
                }
            }catch (IndexOutOfBoundsException ee){
                JOptionPane.showMessageDialog(null,"Please introduce a valid client or product");
            }
        }
    }

    /**
     * Listener for the Edit button from the order's interface
     */
    static class EditOrderListener implements ActionListener {

        OrderInterface oi;

        public EditOrderListener(OrderInterface oi) {
            this.oi = oi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String id, numeProdus, numeClient, cantitate;
            System.out.println("hahaha");
            id = oi.getIdOrder();
            numeProdus = oi.getNumeProdusOrder();
            numeClient = oi.getNumeClientOrder();
            cantitate = oi.getCantitateComandaOrder();
            int cant = Integer.parseInt(cantitate);

            OrderBLL orderBLL = new OrderBLL();
            ClientBLL clientBLL = new ClientBLL();
            ProductBLL productBLL = new ProductBLL();
            Client client;
            Product produs;
            try {

                client = clientBLL.findClientByNume(numeClient);
                try {

                    if (id.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please introduce an Id");
                    } else {

                        int idC = Integer.parseInt(id);
                        produs = productBLL.findProductByNume(numeProdus);
                        Orders oo = orderBLL.findOrderById(idC);
                        int oldQ = oo.getCantitateComanda();
                        if (produs.getCantitate() < cant) {
                            JOptionPane.showMessageDialog(null, "Understock");
                        }
                        Orders o = new Orders(idC, numeClient, numeProdus, cant);
                        orderBLL.updateOrder(o);
                        produs.setCantitate(produs.getCantitate() - (cant - oldQ));
                        productBLL.updateProduct(produs);
                    }
                } catch (IndexOutOfBoundsException ee) {
                    JOptionPane.showMessageDialog(null, "Please introduce a valid client or product");
                }

            }catch(
                    IndexOutOfBoundsException ee){
                JOptionPane.showMessageDialog(null, "Please introduce a valid client or product");
            }

        }
    }

    /**
     * Listener for the Delete button from the order's interface
     */
    static class DeleteOrderListener implements ActionListener{

        OrderInterface oi;

        public DeleteOrderListener(OrderInterface oi) {
            this.oi = oi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            String id;
            System.out.println("hahaha");
            id = oi.getIdOrder();

            OrderBLL orderBLL = new OrderBLL();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }
            else{
                int idC = Integer.parseInt(id);
                Orders o = new Orders(idC);
                orderBLL.deleteOrder(o);
            }
        }
    }

    /**
     * Listener for the Bill button from the order's interface
     */
    static class GenerateBillListener implements ActionListener{

        OrderInterface oi;

        public GenerateBillListener(OrderInterface oi) {
            this.oi = oi;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            String id;
            System.out.println("hahaha");
            id = oi.getIdOrder();

            OrderBLL orderBLL = new OrderBLL();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null,"Please introduce an Id");
            }else{
                int idC = Integer.parseInt(id);
                Orders o = orderBLL.findOrderById(idC);
                try {
                    BillWriter.generateBill(o);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

}