/**
 *
 *  @author Kaszlewicz Tomasz S16165
 *
 */

package zad1;


import java.awt.*;
import javax.swing.*;
import static java.awt.Color.*;


public class Main {

  public static void main(String[] args) {


    final int CNUM = 5; 
  
    String gborders[] = { "West", "North", "East", "South", "Center" };
    Color[] colors = {GREEN,
    		RED,
    		BLUE,
    		YELLOW,
    		ORANGE
    };
    String FontColors[] = {"red", "green", "yellow", "orange", "blue"};
    int FontSize[] = {20, 25, 30, 35, 50};
    JFrame frame = new JFrame("Layouts show"); // okno i contentPane

    frame.setLayout(new GridLayout(0, 1));

      JPanel p = new JPanel();
      p.setBorder(BorderFactory.createTitledBorder("Border Layout")); // ramka
      p.setLayout(new BorderLayout()); // ustalenie rozkładu


      for (int j = 0; j < CNUM; j++) { 
    	String html= "<html><font color="+FontColors[j]+">"+gborders[j]+"</font>";
    	JLabel label = new JLabel(html);
    	label.setFont(new Font("Dialog",Font.PLAIN, FontSize[j]));
    	label.setOpaque(true);
    	label.setToolTipText("Położenie komponentu:" +gborders[j]);
    	if(j==0)
    		label.setBorder(BorderFactory.createLineBorder(BLACK));
    	else if(j==1)
    		label.setBorder(BorderFactory.createEtchedBorder());
    	else if(j==2)
    		label.setBorder(BorderFactory.createRaisedBevelBorder());
    	else if(j==3)
    		label.setBorder(BorderFactory.createCompoundBorder());
    	else if(j==4)
    		label.setBorder(BorderFactory.createMatteBorder(-10,5,-10,5,BLACK));
    	label.setBackground(colors[j]);
        p.add(label, gborders[j]);
      }
      frame.add(p);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
