package zad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.awt.Dimension;

public class Client extends JFrame implements Runnable {

	public String hostName;
	public Socket clientSocket;
	private JTextField textField;
	public JTextArea tArea;
	public boolean close;
	public Client(int port, String hostName,int positionX,int positionY) {
			setLocation(positionX, positionY);
			
		setLocation(positionX,positionY);
		this.hostName = hostName;
		
		try {
			clientSocket = new Socket("localhost", port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Client is ready to work!");
		System.out.println("HOST: "+hostName);
		System.out.println("PROT: "+port);
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setForeground(Color.BLUE);
		setTitle("Client");
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	try {
            		
					writer("Close");
					clientSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            	
            	dispose();
                
                System.out.println("Client close!");
            }
        });
		getContentPane().setLayout(null);
		setSize(new Dimension(600, 274));
		tArea = new JTextArea();
		tArea.setText("Wpisz wiadomo\u015B\u0107 \nLOGOUT wyloguje z czatu\n");
		tArea.setForeground(Color.BLACK);
		tArea.setLineWrap(true);
		tArea.setFont(new Font("MS Gothic", Font.ITALIC, 14));
		tArea.setEditable(false);
		tArea.setBackground(Color.WHITE);
		tArea.setBounds(10, 11, 564, 183);
		getContentPane().add(tArea);
		textField = new JTextField();
		textField.setBounds(10, 205, 433, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Wy\u015Blij");
		btnNewButton.setBounds(453, 204, 121, 23);
		btnNewButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					if(textField.getText().equals("LOGOUT")){
						writer("Close");
						dispose();
						try {
							clientSocket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}else{
						writer(textField.getText());
						textField.setText("");
					}
				}

			}
		});
		getContentPane().add(btnNewButton);
		this.setVisible(true);
	}

	public void writer(String messageToWrite) {
		if (clientSocket.isConnected()) {
			try {
				OutputStream output = clientSocket.getOutputStream();
				output.write(messageToWrite.getBytes());
			} catch (IOException e) {
				System.out.println("Sending error!");
				e.printStackTrace();
			}
		}

	}

	public void recive() {
		try {
			
			while (clientSocket.getSoTimeout() < 1000 && clientSocket.isConnected()) {
				InputStream inputStream = clientSocket.getInputStream();
				byte[] bytes = new byte[1024];
				inputStream.read(bytes);
				String recived = new String(bytes);

				replaceTextInArea(recived);
			}
			
		} catch (SocketException e) {
			System.out.println("Connection is Close");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void replaceTextInArea(String text) {
		String oldText = tArea.getText() + "\n";
		String newText = oldText + text;
		tArea.setText(newText);
	}

	public static void main(String[] args) {
		Client client = new Client(1912, "localhost",0,100);
		new Thread(client).start();

	}

	@Override
	public void run() {

		recive();

	}
}
