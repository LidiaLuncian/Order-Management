package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * The AbstractDAO class.
 * @param <T> a generic type, where T is a model class
 */
public class AbstractDAO<T> {
    /**
     * The LOGGER of the class.
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /**
     * The corresponding type of the model class
     */
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    /**
     * Instantiates a new AbstractDAO
     */
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Creates a SELECT query
     * @param field the filter for which the search is made
     * @return the query
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Searches for the object in the database by id
     * @param id the id
     * @return the object that matches the search
     */
    public T findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName()+"DAO:findById" + e.getMessage());
        }finally{
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Searches for the object in the database by name
     * @param nume the name
     * @return the object that matches the request
     */
    public T findByNume(String nume){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("nume");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,nume);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName()+"DAO:findByNume" + e.getMessage());
        }finally{
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates a SELECT query
     * @return all the objects a model
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Creates a list of all the objects from the database with model type T
     * @return the list
     */
    public List<T> findAll() {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates a list of objects from the resultSet of type 'type'
     * @param resultSet the resultSet
     * @return the list
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    System.out.println(field.getName());
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);

                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Creates an INSERT query
     * @param t an object that needs to be inserted
     * @return the query
     */
    private String createInsertQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" VALUES ( ");
        for(int i=0; i<type.getDeclaredFields().length;i++){
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length()-1); //sterge ultima virgula
        sb.append(")");
        return sb.toString();
    }

    /**
     * Inserts an object t into the database
     * @param t the model object to be inserted
     */
    public void insert(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery(t);
        int result;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i=1;
            for(Field field: t.getClass().getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(t);
                statement.setObject(i, value);
                i++;
            }
            result = statement.executeUpdate();

        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }

    /**
     * Creates an UPDATE query
     * @param t the model object that needs to pe modified
     * @return the query
     */
    private String createUpdateQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for(Field field: t.getClass().getDeclaredFields()){
            sb.append(field.getName() + "=?,");
        }
        sb.deleteCharAt(sb.length()-1); //sterge ultima virgula
        sb.append(" WHERE id=?");
        return sb.toString();
    }

    /**
     * Updates the object t from the database
     * @param t the model object that needs to be modified
     */
    public void update(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(t);
        int result;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i=1;
            for(Field field: t.getClass().getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(t);
                statement.setObject(i, value);
                if(i==1){
                    statement.setObject(t.getClass().getDeclaredFields().length+1, value);
                }
                i++;
            }
            result = statement.executeUpdate();

        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Creates a DELETE query
     * @param t the model object that needs to be deleted from the database
     * @return the query
     */
    private String createDeleteQuery(String t) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + t + " =?");
        return sb.toString();
    }

    /**
     * Deletes from the database the object t
     * @param t the model object that needs to be deleted
     */
    public void delete(T t) {
        //TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        int result;
        Field field = t.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        String query = createDeleteQuery(field.getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, (int) field.get(t));
            result = statement.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Creates a table with the data from a list
     * @param objects a list of objects
     * @return the table
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public JTable createTable(List<T> objects) throws IllegalArgumentException, IllegalAccessException {
        ArrayList<String> columnNamesArrayList = new ArrayList<String>();
        for(Field field : objects.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columnNamesArrayList.add(field.getName());
        }
        String[] columnNames = new String[columnNamesArrayList.size()];
        columnNames = columnNamesArrayList.toArray(columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Iterator<T> i = objects.iterator();
        while(i.hasNext()) {
            T object = i.next();
            ArrayList<Object> columnDataAsArrayList = new ArrayList<Object>();
            for(Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                columnDataAsArrayList.add(field.get(object));
            }
            Object[] columnDataAsArray = new Object[columnDataAsArrayList.size()];
            columnDataAsArray = columnDataAsArrayList.toArray(columnDataAsArray);
            tableModel.addRow(columnDataAsArray);
        }
        JTable table = new JTable(tableModel);
        return table;
    }

}
