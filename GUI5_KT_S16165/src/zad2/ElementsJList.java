package zad2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElementsJList extends JFrame {

     private DefaultListModel element;
     private JList list;
     private JTextField inputField;
     
     public ElementsJList(){
         super( "JList2" );

         element = new DefaultListModel();
         list = new JList( element );
         
         list.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {
                 java.util.List selectedItems = list.getSelectedValuesList();
                 if (e.isAltDown()){
                     for (Object o : selectedItems){
                         element.removeElement(o);
                     }
                 }
             }
         });
             
         inputField=new JTextField();
         inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String name=inputField.getText();
                element.addElement( name );
                inputField.setText("");
            }

        });

        list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION );

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.Y_AXIS));

        inputField.setLayout(new FlowLayout());
        inputField.setBounds(5, 5, 100, 100);
        inputField.setPreferredSize(new Dimension(120,20));
        JScrollPane scrollPane=new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(200,200));

        Container container = getContentPane();
        add(scrollPane);
        container.add( inputPanel);
        add( inputField);
        container.setLayout(new FlowLayout());
        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 500, 250 );
        setVisible( true );
     }
}