package model;

/**
 * The Product class.
 */
public class Product {

    /**
     * The id of the product
     */
    private int id;
    /**
     * The name of the product
     */
    private String nume;
    /**
     * The price of the product
     */
    private int pret;
    /**
     * The quantity of the product
     */
    private int cantitate;

    /**
     * Instantiates a new Product
     */
    public Product(){

    }

    /**
     * Instantiates a new Product
     * @param id the id of the product
     * @param nume the name of the product
     * @param pret the price of the product
     * @param cantitate the quantity of the product
     */
    public Product(int id, String nume, int pret, int cantitate){
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    /**
     * Instantiates a new Product
     * @param id the id of the product
     */
    public Product(int id){
        this.id = id;
    }

    /**
     * Instantiates a new Product.
     * @param numeProdus the name of the product
     * @param pret the price of the product
     * @param cantitate the quantity of the product
     */
    public Product(String numeProdus, int pret, int cantitate){
        this.nume = numeProdus;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    /**
     * Retrieves the id of the product
     * @return the id
     */
    public int getId(){
        return this.id;
    }

    /**
     * Sets the new id of the product
     * @param id the new id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Retrieves the name of the product
     * @return the name of the product
     */
    public String getNume() {
        return nume;
    }

    /**
     * Sets the new name of the product
     * @param numeProdus the new name
     */
    public void setNume(String numeProdus) {
        this.nume = numeProdus;
    }

    /**
     * Retrieves the price of the product
     * @return the price
     */
    public int getPret() {
        return pret;
    }

    /**
     * Sets the new price of the product
     * @param pret the new price
     */
    public void setPret(int pret) {
        this.pret = pret;
    }

    /**
     * Retrieves the quantity of the product
     * @return the quantity
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Sets the new quantity
     * @param cantitate the new quantity
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    /**
     * Pretty print of the data of the product
     * @return the data from Product
     */
    @Override
    public String toString() {
        return "Product{" +
                "idProdus=" + id +
                ", numeProdus='" + nume + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                '}';
    }
}
