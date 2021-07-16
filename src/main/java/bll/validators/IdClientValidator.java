package bll.validators;

import model.Client;

/**
 * The IdClientValidator class.
 */
public class IdClientValidator implements Validator<Client> {
    /**
     * The minim and maxim limits of the client's id.
     */
    private static final int MIN_ID = -1;
    private static final int MAX_ID = 1000;

    /**
     * Method that validates the id of the client.
     * @param t a client
     */
    public void validate(Client t) {

        if (t.getId() <= MIN_ID || t.getId() > MAX_ID) {
            throw new IllegalArgumentException("Id-ul nu e bun!");
        }

    }

}
