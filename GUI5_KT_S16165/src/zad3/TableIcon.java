package zad3;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JFrame
{
    public TableIcon(Object[][] read)
    {        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
    	String[] columnNames = { "Autor", "Tytuł",
                "Cena"
        };
        Object[][] data = read;

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable( model )
        {
            @Override
        	public boolean isCellEditable(int row, int col) {
        		if (col == 2)  // komórki kolumny "Dzień" nie są edytowalne!
        			return true;
        		else
        			return false;
        	}
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }
}
