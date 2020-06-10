package GUI;

import java.awt.Color;
import Model.*;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DodajProdukt extends LoadSaveEkstensja {

	private JFrame frame;
	public List<Produkt> produkty = new ArrayList<>();
	private JTextField textNazwa;

	private JTextField textGwarancja;
	private JTextField textCena;
	private JTextField textZasieg;
	private JTextField textMaterial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajProdukt window = new DodajProdukt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(" ");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws FileNotFoundException
	 */
	public DodajProdukt() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame("Add a product");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 250, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// wczytanie ekstensji
		loadEkstensja();

		JLabel lblNazwa = new JLabel("Name");
		lblNazwa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNazwa.setBounds(10, 13, 74, 14);
		frame.getContentPane().add(lblNazwa);

		textNazwa = new JTextField();
		textNazwa.setBounds(94, 11, 104, 20);
		frame.getContentPane().add(textNazwa);
		textNazwa.setColumns(10);

		JLabel lblGwarancja = new JLabel("Warranty");
		lblGwarancja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGwarancja.setBounds(10, 40, 88, 14);
		frame.getContentPane().add(lblGwarancja);

		textGwarancja = new JTextField();
		textGwarancja.setColumns(10);
		textGwarancja.setBounds(94, 38, 104, 20);
		frame.getContentPane().add(textGwarancja);

		JLabel lblCena = new JLabel("Price");
		lblCena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCena.setBounds(10, 65, 48, 14);
		frame.getContentPane().add(lblCena);

		textCena = new JTextField();
		textCena.setColumns(10);
		textCena.setBounds(94, 65, 104, 20);
		frame.getContentPane().add(textCena);

		JLabel lblZasieg = new JLabel("Range");
		lblZasieg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblZasieg.setBounds(10, 90, 74, 18);
		frame.getContentPane().add(lblZasieg);

		textZasieg = new JTextField();
		textZasieg.setColumns(10);
		textZasieg.setBounds(94, 90, 104, 20);
		frame.getContentPane().add(textZasieg);

		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaterial.setBounds(10, 115, 74, 18);
		frame.getContentPane().add(lblMaterial);

		textMaterial = new JTextField();
		textMaterial.setColumns(10);
		textMaterial.setBounds(94, 115, 104, 20);
		frame.getContentPane().add(textMaterial);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(125, 153, 100, 23);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					// jesli liczba cena lub zasieg nie sa liczba

					try {
						Double.parseDouble(textCena.getText());
						Double.parseDouble(textZasieg.getText());
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Incorrect format.");
						return;

					}

					// obsluga bledu gdy nie wpiszemy jakiegos pola
					if (textNazwa.getText().isEmpty() || textGwarancja.getText().isEmpty()
							|| textCena.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Empty fields not allowed.");

					} else {

						Produkt produkt = new Produkt(textNazwa.getText(), textGwarancja.getText(),
								Double.parseDouble(textCena.getText()), Double.parseDouble(textZasieg.getText()));

						try {
							saveEkstensja();
						} catch (FileNotFoundException e2) {

						}

						JOptionPane.showMessageDialog(null, "Product added.");

						textNazwa.setText("");
						textGwarancja.setText("");
						textCena.setText("");
						textZasieg.setText("");
					}
				}
			});

		JButton btnWroc = new JButton("Back");
		btnWroc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Menu menu = new Menu();
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnWroc.setBounds(10, 153, 100, 23);
		frame.getContentPane().add(btnWroc);
	}

	public Component getFrame() {
		return frame;
	}
}
