package bll.validators;

/**
 * The Validator interface
 * @param <T> a generic type
 */
public interface Validator<T> {

    /**
     * Method that validates an object.
     * @param t an object
     *          throws an exception if false
     */
    public void validate(T t);
}
