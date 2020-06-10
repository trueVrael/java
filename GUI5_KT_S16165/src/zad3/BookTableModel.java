package zad3;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel{
	
	static String[] columnNames = { "Autor", "Tytuł",
            "Cena", "Okładka"
    };
	
	private     Object[][] data = {
            {"String", "I'm a string"},
            {"Integer", new Integer(123)},
            {"Double", new Double(123.45)},
            {"Boolean", Boolean.TRUE}
    };
	
	Class[] columns = new Class[]{Object.class, Object.class, Number.class, Icon.class};
	public int getColumnCount() { return columnNames.length; }

	public int getRowCount() {
		return 10;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Class getColumnClass(int c) {
		// klasa danych w pierwszej komórce kolumny c
		return columns[c];
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0)  // komórki kolumny "Dzień" nie są edytowalne!
			return false;
		else
			return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
