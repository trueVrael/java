/**
 *
 *  @author Kaszlewicz Tomasz S16165
 *
 */

package zad3;

import javax.swing.JFrame;

public class Main {
  
	public static void main(String[] args) {
  
	  Reader information = new Reader();
	  Object[][] file_data = information.file_data;
      for(int i=0; i<10; i++){
      	System.out.println(file_data[i][0] + " " + file_data[i][1] + " " + file_data[i][2]);
      }
	  TableIcon mainFrame = new TableIcon(file_data);
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
	  mainFrame.setVisible(true);	
	
	}
}
