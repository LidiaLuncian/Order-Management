package model;

/**
 * The Orders class.
 */
public class Orders {

    /**
     * The id of the order.
     */
    private int id;
    /**
     * The name of the client who placed the order.
     */
    private String numeClient;
    /**
     * The name of the product that wants to be purchased.
     */
    private String numeProdus;
    /**
     * The quantity of the product to be purchased.
     */
    private int cantitateComanda;

    /**
     * Instantiates a new Order.
     */
    public Orders(){

    }

    /**
     * Instantiates a new Order.
     * @param id the id of the order
     */
    public Orders(int id){
        this.id = id;
    }

    /**
     * Instantiates a new Order.
     * @param id the id of the order
     * @param numeClient the name of the client
     * @param numeProdus the name of the product
     * @param cantitateComanda the quantity of the product
     */
    public Orders(int id, String numeClient, String numeProdus, int cantitateComanda){
        this.id = id;
        this.numeClient = numeClient;
        this.numeProdus = numeProdus;
        this.cantitateComanda = cantitateComanda;
    }

    /**
     * Instantiates a new Order
     * @param numeClient the name of the client
     * @param numeProdus the name of the product
     * @param cantitateComanda the quantity of the product
     */
    public Orders(String numeClient, String numeProdus, int cantitateComanda){
        this.numeClient = numeClient;
        this.numeProdus = numeProdus;
        this.cantitateComanda = cantitateComanda;
    }

    /**
     * Retrieves the id of the order
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of the order
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the client
     * @return numeClient
     */
    public String getNumeClient() {
        return numeClient;
    }

    /**
     * Sets the new name of the client
     * @param numeClient the new name
     */
    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    /**
     * Retireves the name of the product
     * @return numeProdus
     */
    public String getNumeProdus() {
        return numeProdus;
    }

    /**
     * Sets the new name of the product
     * @param numeProdus the new name
     */
    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    /**
     * Retrieves the quantity of the product
     * @return the quantity
     */
    public int getCantitateComanda() {
        return cantitateComanda;
    }

    /**
     * Sets the new quantity
     * @param cantitateComanda new quantity
     */
    public void setCantitateComanda(int cantitateComanda) {
        this.cantitateComanda = cantitateComanda;
    }

    /**
     * Pretty print of the data
     * @return the data from Order
     */
    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + id +
                ", numeClient='" + numeClient + '\'' +
                ", numeProdus='" + numeProdus + '\'' +
                ", cantitateComanda=" + cantitateComanda +
                '}';
    }
}
