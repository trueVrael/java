package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import Model.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DodajSerwisanta extends LoadSaveEkstensja {
	private JFrame frame;
	private JTextField textImie;
	private JTextField textNazwisko;
	private JTextField textAdres;
	private JTextField textTelefon;
	
	public ArrayList<Object> dane = new ArrayList<Object>();
	public List<Serwisant> serwisanci = new ArrayList<>();
	private JTextField textMail;
	private JTextField textStawka;
	private JTextField textLiczbaH;
	private JTextField textPremia;
	private JTextField textWiek;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajSerwisanta window = new DodajSerwisanta();
					window.frame.setVisible(true);
				} catch (Exception e) {
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
	public DodajSerwisanta() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame("Add a repairman");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 250, 326);
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
		textImie.setBounds(100, 11, 104, 20);
		frame.getContentPane().add(textImie);
		textImie.setColumns(10);

		JLabel lblNazwisko = new JLabel("Surname");
		lblNazwisko.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNazwisko.setBounds(10, 38, 71, 14);
		frame.getContentPane().add(lblNazwisko);

		textNazwisko = new JTextField();
		textNazwisko.setColumns(10);
		textNazwisko.setBounds(100, 38, 104, 20);
		frame.getContentPane().add(textNazwisko);

		JLabel lblAdres = new JLabel("Address");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(10, 65, 48, 14);
		frame.getContentPane().add(lblAdres);

		textAdres = new JTextField();
		textAdres.setColumns(10);
		textAdres.setBounds(100, 65, 104, 20);
		frame.getContentPane().add(textAdres);

		JLabel lblMail = new JLabel("E-mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMail.setBounds(10, 94, 48, 14);
		frame.getContentPane().add(lblMail);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(100, 96, 104, 20);
		frame.getContentPane().add(textMail);

		JLabel lblStawka = new JLabel("Hourly rate");
		lblStawka.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStawka.setBounds(10, 124, 71, 14);
		frame.getContentPane().add(lblStawka);

		textStawka = new JTextField();
		textStawka.setColumns(10);
		textStawka.setBounds(100, 122, 104, 20);
		frame.getContentPane().add(textStawka);

		JLabel lblLiczbaH = new JLabel("Hours worked");
		lblLiczbaH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczbaH.setBounds(10, 149, 71, 14);
		frame.getContentPane().add(lblLiczbaH);

		textLiczbaH = new JTextField();
		textLiczbaH.setColumns(10);
		textLiczbaH.setBounds(100, 151, 104, 20);
		frame.getContentPane().add(textLiczbaH);

		JLabel lblPremia = new JLabel("Bonus");
		lblPremia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPremia.setBounds(10, 176, 91, 18);
		frame.getContentPane().add(lblPremia);

		textPremia = new JTextField();
		textPremia.setColumns(10);
		textPremia.setBounds(100, 176, 104, 20);
		frame.getContentPane().add(textPremia);

		JLabel lblTelefon = new JLabel("Phone");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefon.setBounds(10, 201, 48, 14);
		frame.getContentPane().add(lblTelefon);

		textTelefon = new JTextField();
		textTelefon.setBounds(100, 201, 104, 20);
		frame.getContentPane().add(textTelefon);
		textTelefon.setColumns(10);
		
		JLabel lblWiek = new JLabel("Age");
		lblWiek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWiek.setBounds(10, 226, 48, 14);
		frame.getContentPane().add(lblWiek);

		textWiek = new JTextField();
		textWiek.setBounds(100, 226, 104, 20);
		frame.getContentPane().add(textWiek);
		textWiek.setColumns(10);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(130, 259, 100, 23);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
					Serwisant serwisant = null;

					// Stawka must be a double, liczbaH and szkolenia must be a Int
					try {
						Double.parseDouble(textStawka.getText());
						Integer.parseInt(textLiczbaH.getText());
						Integer.parseInt(textPremia.getText());
						Integer.parseInt(textWiek.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Incorrect format.");
						return;

					}

					// obsluga bledu gdy nie wpiszemy jakiegos pola
					if (textImie.getText().isEmpty() || textNazwisko.getText().isEmpty()
							|| textAdres.getText().isEmpty() || textMail.getText().isEmpty()
							|| textStawka.getText().isEmpty() || textLiczbaH.getText().isEmpty()
							|| textPremia.getText().isEmpty() || textWiek.getText().isEmpty()

					) {
						JOptionPane.showMessageDialog(null, "Empty fields not allowed.");

					} else if(Integer.parseInt(textWiek.getText())< Serwisant.getMinimalnyWiek()) {
						JOptionPane.showMessageDialog(null, "Repairman is too young.");
						return;
						
					} else if(textTelefon.getText().isEmpty()) {
						
						serwisant = new Serwisant(textImie.getText(), textNazwisko.getText(), textAdres.getText(), textMail.getText(), Double.parseDouble(textStawka.getText()), 
								Integer.parseInt(textLiczbaH.getText()), Integer.parseInt(textPremia.getText()));

						try {
							saveEkstensja();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Repairman added.");

						textImie.setText("");
						textNazwisko.setText("");
						textAdres.setText("");
						textMail.setText("");
						textStawka.setText("");
						textLiczbaH.setText("");
						textPremia.setText("");
					} else {
							
							serwisant = new Serwisant(textImie.getText(), textNazwisko.getText(), textAdres.getText(), textMail.getText(), textTelefon.getText(), Double.parseDouble(textStawka.getText()), 
									Integer.parseInt(textLiczbaH.getText()), Integer.parseInt(textPremia.getText()));

							try {
								saveEkstensja();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						JOptionPane.showMessageDialog(null, "Repairman Added.");

						textImie.setText("");
						textNazwisko.setText("");
						textAdres.setText("");
						textMail.setText("");
						textStawka.setText("");
						textLiczbaH.setText("");
						textPremia.setText("");
						textTelefon.setText("");
						textWiek.setText("");
					}
				}
			});


		JButton buttonWroc = new JButton("Back");
		buttonWroc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Menu menu = new Menu();
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		buttonWroc.setBounds(10, 259, 100, 23);
		frame.getContentPane().add(buttonWroc);

	}

	public Component getFrame() {
		return frame;
	}
}
