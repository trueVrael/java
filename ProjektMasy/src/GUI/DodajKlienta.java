package GUI;
import Model.*;
import java.awt.Color;
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

public class DodajKlienta extends LoadSaveEkstensja {

	private JFrame frame;
	private JTextField textImie;
	private JTextField textNazwisko;
	private JTextField textAdres;
	private JTextField textTelefon;
	private JTextField textRabat;
	public List<Klient> klienci = new ArrayList<>();
	private JTextField textMail;
	public Klient klient = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKlienta window = new DodajKlienta();
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
	public DodajKlienta() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame("Add a client");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 250, 262);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// load extension
		
		loadEkstensja();

		JLabel lblImie = new JLabel("Name");
		lblImie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImie.setBounds(10, 11, 48, 14);
		frame.getContentPane().add(lblImie);

		textImie = new JTextField();
		textImie.setToolTipText("");
		textImie.setBackground(Color.WHITE);
		textImie.setBounds(79, 9, 104, 20);
		frame.getContentPane().add(textImie);
		textImie.setColumns(10);

		JLabel lblNazwisko = new JLabel("Surname");
		lblNazwisko.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNazwisko.setBounds(10, 42, 71, 14);
		frame.getContentPane().add(lblNazwisko);

		textNazwisko = new JTextField();
		textNazwisko.setColumns(10);
		textNazwisko.setBounds(79, 40, 104, 20);
		frame.getContentPane().add(textNazwisko);

		JLabel lblAdres = new JLabel("Address");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(10, 73, 48, 14);
		frame.getContentPane().add(lblAdres);

		textAdres = new JTextField();
		textAdres.setColumns(10);
		textAdres.setBounds(79, 71, 104, 20);
		frame.getContentPane().add(textAdres);

		JLabel lblMail = new JLabel("E-mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMail.setBounds(10, 104, 48, 14);
		frame.getContentPane().add(lblMail);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(79, 102, 104, 20);
		frame.getContentPane().add(textMail);
		
		JLabel lblTel = new JLabel("Phone");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTel.setBounds(10, 135, 48, 14);
		frame.getContentPane().add(lblTel);

		textTelefon = new JTextField();
		textTelefon.setColumns(10);
		textTelefon.setBounds(79, 133, 104, 20);
		frame.getContentPane().add(textTelefon);
		
		JLabel lblRabat = new JLabel("Discount");
		lblRabat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRabat.setBounds(10, 167, 48, 14);
		frame.getContentPane().add(lblRabat);

		textRabat = new JTextField();
		textRabat.setColumns(10);
		textRabat.setBounds(79, 169, 104, 20);
		frame.getContentPane().add(textRabat);
		
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(130, 198, 100, 23);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					// Rabat must be a double, liczbaH and szkolenia must be a Int
					try {
						Double.parseDouble(textRabat.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Incorrect format. Discount must be a number");
						return;
					}
					
					// all blanks other than telefone and Rabat must be filled
					if (textImie.getText().isEmpty() || textNazwisko.getText().isEmpty()
							|| textAdres.getText().isEmpty() || textMail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Empty fields not allowed");
						return;

					} else if(textTelefon.getText().isEmpty() && textRabat.getText().isEmpty()) {
						Klient klient = new Klient(textImie.getText(), textNazwisko.getText(), textAdres.getText(),
								textMail.getText());
					} else if(textRabat.getText().isEmpty()) {
						Klient klient = new Klient(textImie.getText(), textNazwisko.getText(), textAdres.getText(),
							textMail.getText(), textTelefon.getText());
					} else if(textTelefon.getText().isEmpty()) {
						Klient klient = new Klient(textImie.getText(), textNazwisko.getText(), textAdres.getText(),
								textMail.getText(),Double.parseDouble(textRabat.getText()));
					} else {
						Klient klient = new Klient(textImie.getText(), textNazwisko.getText(), textAdres.getText(),
								textMail.getText(), textTelefon.getText(),Double.parseDouble(textRabat.getText()));
					}
					try {
						saveEkstensja();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Client added.");

					textImie.setText("");
					textNazwisko.setText("");
					textAdres.setText("");
					textMail.setText("");
					textRabat.setText("");
					textTelefon.setText("");

			}
		});

		JButton btnWroc = new JButton("Back");
		btnWroc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Menu menu = new Menu();
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnWroc.setBounds(10, 198, 100, 23);
		frame.getContentPane().add(btnWroc);

	}

	public Component getFrame() {
		return frame;
	}
}
