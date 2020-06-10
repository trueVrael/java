package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Model.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DodajZgloszenie extends LoadSaveEkstensja{

	private JFrame frame;
	private JTextField nazwaZgloszenia;
	public List<Klient> zgloszeniaKlientow = new ArrayList<>();
	public List<Klient> klienci = new ArrayList<>();
	private JTextField koszt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajZgloszenie window = new DodajZgloszenie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public DodajZgloszenie() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame("Add an order");
		frame.setBounds(100, 100, 585, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);

		// lista aby wczytac klientów
		final DefaultListModel zgloszenia = new DefaultListModel();

		// wczytujemy klientow z pliku

		loadEkstensja();
		
		// wyswietlamy wszystkich klientow w petli na liscie
		for (Klient k : ObjectPlus.pokazEkstensje(Klient.class)) {
			zgloszenia.addElement(k);
		}
		frame.getContentPane().setLayout(null);

		JComboBox comboTrudnosc = new JComboBox();
		comboTrudnosc.setBounds(373, 110, 140, 20);
		frame.getContentPane().add(comboTrudnosc);

		comboTrudnosc.addItem("easy");
		comboTrudnosc.addItem("medium");
		comboTrudnosc.addItem("difficult");

		JList lewaListaKlientow = new JList(zgloszenia);
		JScrollPane scroll = new JScrollPane(lewaListaKlientow);
		scroll.setBounds(7, 31, 222, 269);
		frame.getContentPane().add(scroll);

		JLabel lblWybierzKlient = new JLabel("Choose a client");
		lblWybierzKlient.setBounds(7, 7, 107, 20);
		lblWybierzKlient.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblWybierzKlient);

		JLabel lblZgloszenie = new JLabel("Order details");
		lblZgloszenie.setBounds(314, 7, 165, 20);
		lblZgloszenie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblZgloszenie);

		JLabel lblNazwa = new JLabel("Name");
		lblNazwa.setBounds(239, 39, 113, 25);
		lblNazwa.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNazwa);

		nazwaZgloszenia = new JTextField();
		nazwaZgloszenia.setBounds(373, 43, 140, 20);
		frame.getContentPane().add(nazwaZgloszenia);
		nazwaZgloszenia.setColumns(10);

		JLabel lblTrudnosc = new JLabel("Difficulty");
		lblTrudnosc.setBounds(239, 106, 113, 25);
		lblTrudnosc.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblTrudnosc);

		JLabel lblKoszt = new JLabel("Price");
		lblKoszt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKoszt.setBounds(239, 70, 113, 25);
		frame.getContentPane().add(lblKoszt);

		koszt = new JTextField();
		koszt.setColumns(10);
		koszt.setBounds(373, 74, 140, 20);
		frame.getContentPane().add(koszt);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("img/r.gif"));
		logo.setBounds(345, 151, 222, 132);
		frame.getContentPane().add(logo);

		JButton btnDodajZgloszenie = new JButton("Add an order");
		btnDodajZgloszenie.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {

				// obsluga jesli nic nie zaznaczymy na liscie klientow po lewej
				if (!(lewaListaKlientow.getSelectedValue() == null)) {

					// Tworzymy obiekt na podstawie tego klienta wybranego z
					// listy po lewej
					Klient wybranyKlient = (Klient) lewaListaKlientow.getSelectedValue();

					// obsluga wyjatku
					if (nazwaZgloszenia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Empty fields not allowed.");
					} else {

						Zgloszenie zgloszenie = null;
						try {
							zgloszenie = new Zgloszenie(nazwaZgloszenia.getText(),
									(Double.parseDouble(koszt.getText()) - wybranyKlient.getRabat()));
							zgloszenie.setTrudnosc(comboTrudnosc.getSelectedItem().toString());

						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Price must be a number.");
							return;
						} catch (Exception e2) {
							e2.printStackTrace();
						}

						// make assosiation

						wybranyKlient.dodajZgloszenie(zgloszenie);
						 
						//save extension
						FileOutputStream file2;
						try {
							file2 = new FileOutputStream("Ekstensja");
							ObjectOutputStream save2 = new ObjectOutputStream(file2);						 
		 			    	ObjectPlus.Save(save2);
		 					save2.close();
		 
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,
								"Order added to client: " + wybranyKlient);

						Menu menu = new Menu();
						menu.getFrame().setVisible(true);
						frame.setVisible(false);

					}
				} else {
					JOptionPane.showMessageDialog(null, "You need to pick a client.");
				}
			}
		});
		btnDodajZgloszenie.setBounds(321, 311, 147, 23);
		frame.getContentPane().add(btnDodajZgloszenie);

		JButton btnWroc = new JButton("Back");
		btnWroc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Menu menu = new Menu();
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnWroc.setBounds(162, 311, 89, 23);
		frame.getContentPane().add(btnWroc);

	}

	public Window getFrame() {
		return frame;
	}
}
