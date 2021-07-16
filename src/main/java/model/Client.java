package model;

/**
 * The Client class.
 */
public class Client {

    /**
     * The id.
     */
    private int id;
    /**
     * The name.
     */
    private String nume;
    /**
     * The email.
     */
    private String email;
    /**
     * The address.
     */
    private String adresa;

    /**
     * Instantiates a new Client.
     */
    public Client(){

    }

    /**
     * Instantiates a new Client.
     * @param id  the id
     * @param nume the name
     * @param email the email
     * @param adresa the address
     */
    public Client(int id, String nume, String email, String adresa){
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
    }

    /**
     * Instantiates a new Client
     * @param nume the name
     * @param email the email
     * @param adresa the address
     */
    public Client(String nume, String email, String adresa){
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
    }

    /**
     * Retrieves the id.
     * @return the id
     */
    public int getId(){
        return this.id;
    }

    /**
     * Sets the id.
     * @param id the new id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Retrieves the name
     * @return the name
     */
    public String getNume(){
        return this.nume;
    }

    /**
     * Sets the name
     * @param nume the new nume
     */
    public void setNume(String nume){
        this.nume=nume;
    }

    /**
     * Retrirve the address
     * @return the address
     */
    public String getAdresa(){
        return this.adresa;
    }

    /**
     * Sets the address
     * @param adresa the new adresa
     */
    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    /**
     * Retrieves the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the new email.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pretty print
     * @return all the Client's data
     */
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + id +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
