package presentation;

import javax.swing.*;

/**
 * The TableInterface class. It creates an interface for a table.
 * It contains only a table.
 */
public class TableInterface extends JFrame {

    /**
     * tableFrame is the frame of the interface.
     */
    JFrame tabelFrame;
    /**
     * The table itself
     */
    JTable table;

    /**
     * The constructor instantiates a new TableInterface
     * @param table a table sent as a parameter
     * @param nume the name of the table
     */
    public TableInterface(JTable table, String nume){
        tabelFrame = new JFrame("Tabel " + nume);
        this.table = table;
        tabelFrame.setVisible(true);
        tabelFrame.setSize(500,200);
        tabelFrame.setLocation(450,280);
        JScrollPane p = new JScrollPane(table);
        tabelFrame.add(p);
    }

}
