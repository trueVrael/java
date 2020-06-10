package zad1;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {
	JList list = new JList();
	JScrollPane scrollPane;
	public MainFrame(){
		TempModel wmodel = new TempModel();
		list.setModel(wmodel);
		scrollPane = new JScrollPane(list);	
		this.add(scrollPane);		
	}	
}