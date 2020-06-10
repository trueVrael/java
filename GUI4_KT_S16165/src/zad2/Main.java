/**
 *
 *  @author Kaszlewicz Tomasz S16165
 *
 */

package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.*;

public class Main extends JFrame{

private Color[] colors = {
		Color.red,
		Color.blue,
		Color.yellow,
		Color.green,
};
private int index = 0;
  
  // przycisk, który bedzie programistycznie wciśnięty
  private JButton bpre = new JButton("");  

  Main() {
	setPreferredSize(new Dimension(400, 400));
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        setButt(bpre, CENTER, TOP);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
      }
    });
    ActionListener listener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
            if (source instanceof Component) {
                ((Component)source).setBackground(colors[index++]);
                index%=colors.length;
            }
		}
    	
    };
    bpre.addActionListener(listener);
  }

  void setButt(AbstractButton b, int horPos, int vertPos) {
    b.setFocusPainted(false);
    b.setBackground(Color.green);
    add(b);
  }

  public static void main(String args[]) {
        new Main();
  }
}