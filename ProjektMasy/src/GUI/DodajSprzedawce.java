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

public class DodajSprzedawce extends LoadSaveEkstensja {
	private JFrame frame;
	private JTextField textImie;
	private JTextField textNazwisko;
	private JTextField textAdres;
	private JTextField textTelefon;
	
	public ArrayList<Object> dane = new ArrayList<Object>();
	public List<Sprzedawca> sprzedawcy = new ArrayList<>();
	private JTextField textMail;
	private JTextField textStawka;
	private JTextField textLiczbaH;
	private JTextField textSzkolenia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajSprzedawce window = new DodajSprzedawce();
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
	public DodajSprzedawce() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame("Dodawanie sprzedawcy");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 250, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// load extension
		loadEkstensja();

		JLabel lblImie = new JLabel("Imie");
		lblImie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImie.setBounds(10, 11, 48, 14);
		frame.getContentPane().add(lblImie);

		textImie = new JTextField();
		textImie.setBounds(100, 11, 104, 20);
		frame.getContentPane().add(textImie);
		textImie.setColumns(10);

		JLabel lblNazwisko = new JLabel("Nazwisko");
		lblNazwisko.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNazwisko.setBounds(10, 38, 71, 14);
		frame.getContentPane().add(lblNazwisko);

		textNazwisko = new JTextField();
		textNazwisko.setColumns(10);
		textNazwisko.setBounds(100, 38, 104, 20);
		frame.getContentPane().add(textNazwisko);

		JLabel lblAdres = new JLabel("Adres");
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

		JLabel lblStawka = new JLabel("Stawka H");
		lblStawka.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStawka.setBounds(10, 124, 71, 14);
		frame.getContentPane().add(lblStawka);

		textStawka = new JTextField();
		textStawka.setColumns(10);
		textStawka.setBounds(100, 122, 104, 20);
		frame.getContentPane().add(textStawka);

		JLabel lblLiczbaH = new JLabel("Liczba H");
		lblLiczbaH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczbaH.setBounds(10, 149, 71, 14);
		frame.getContentPane().add(lblLiczbaH);

		textLiczbaH = new JTextField();
		textLiczbaH.setColumns(10);
		textLiczbaH.setBounds(100, 151, 104, 20);
		frame.getContentPane().add(textLiczbaH);

		JLabel lblLiczbaSzkolen = new JLabel("Liczba szkolen");
		lblLiczbaSzkolen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczbaSzkolen.setBounds(10, 176, 91, 18);
		frame.getContentPane().add(lblLiczbaSzkolen);

		textSzkolenia = new JTextField();
		textSzkolenia.setColumns(10);
		textSzkolenia.setBounds(100, 176, 104, 20);
		frame.getContentPane().add(textSzkolenia);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefon.setBounds(10, 201, 48, 14);
		frame.getContentPane().add(lblTelefon);

		textTelefon = new JTextField();
		textTelefon.setBounds(100, 201, 104, 20);
		frame.getContentPane().add(textTelefon);
		textTelefon.setColumns(10);
		
		JButton btnEnter = new JButton("Zatwierdü");
		btnEnter.setBounds(130, 234, 100, 23);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
					Sprzedawca sprzedawca = null;

					// Stawka must be a double, liczbaH and szkolenia must be a Int
					try {
						Double.parseDouble(textStawka.getText());
						Integer.parseInt(textLiczbaH.getText());
						Integer.parseInt(textSzkolenia.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Incorrect format.");
						return;

					}

					// obsluga bledu gdy nie wpiszemy jakiegos pola
					if (textImie.getText().isEmpty() || textNazwisko.getText().isEmpty()
							|| textAdres.getText().isEmpty() || textMail.getText().isEmpty()
							|| textStawka.getText().isEmpty() || textLiczbaH.getText().isEmpty()
							|| textSzkolenia.getText().isEmpty()

					) {
						JOptionPane.showMessageDialog(null, "Empty fields not allowed.");

					} else if(textTelefon.getText().isEmpty()) {
						
						sprzedawca= new Sprzedawca(textImie.getText(), textNazwisko.getText(), textAdres.getText(), textMail.getText(), Double.parseDouble(textStawka.getText()), 
								Integer.parseInt(textLiczbaH.getText()), Integer.parseInt(textSzkolenia.getText()));

						try {
							saveEkstensja();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Salesman added.");

						textImie.setText("");
						textNazwisko.setText("");
						textAdres.setText("");
						textMail.setText("");
						textStawka.setText("");
						textLiczbaH.setText("");
						textSzkolenia.setText("");
					}
						else {
							
							sprzedawca= new Sprzedawca(textImie.getText(), textNazwisko.getText(), textAdres.getText(), textTelefon.getText(), textMail.getText(), Double.parseDouble(textStawka.getText()), 
									Integer.parseInt(textLiczbaH.getText()), Integer.parseInt(textSzkolenia.getText()));

							try {
								saveEkstensja();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						JOptionPane.showMessageDialog(null, "Salesman added.");

						textImie.setText("");
						textNazwisko.setText("");
						textAdres.setText("");
						textMail.setText("");
						textStawka.setText("");
						textLiczbaH.setText("");
						textSzkolenia.setText("");
						textTelefon.setText("");
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
		buttonWroc.setBounds(10, 234, 100, 23);
		frame.getContentPane().add(buttonWroc);

	}

	public Component getFrame() {
		return frame;
	}
}
