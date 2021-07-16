package presentation;

import bll.ProductBLL;
import model.Orders;
import model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The BillWriter class. It creates a .txt file for orders.
 */
public class BillWriter {

    private static final boolean append = false;

    /**
     * Creates a .txt file
     * @param order the order that needs a bill
     * @throws IOException for the creation of the .txt file
     */
    public static void generateBill(Orders order) throws IOException {
        File newBill = new File("BillNo " + order.getId()+".txt");
        newBill.createNewFile();

        FileWriter fw = new FileWriter(newBill.getCanonicalPath(),append);
        PrintWriter pw = new PrintWriter(fw);

        ProductBLL productBLL = new ProductBLL();
        Product product = productBLL.findProductByNume(order.getNumeProdus());
        pw.println("---------ORDER #" + order.getId() + "-----------");
        pw.println("Client name: " + order.getNumeClient());
        pw.println("Product name: " + order.getNumeProdus());
        pw.println("Product unit/price: " +product.getPret());
        pw.println("Quantiy: " + order.getCantitateComanda());
        pw.println("Total price: " + product.getPret() * order.getCantitateComanda());
        pw.close();

    }
}
