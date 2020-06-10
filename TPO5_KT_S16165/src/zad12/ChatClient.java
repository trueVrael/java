package zad12;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * @Author Tomasz Kaszlewicz
 */
public class ChatClient {

    private Context context = new InitialContext();

    private MessageProducer producer;

    private MessageConsumer consumer;

    private Connection connection;

    private Session session;

    private Scanner keyboard = new Scanner(System.in);

    private String username;

    public ChatClient() throws NamingException, JMSException {
        System.out.print("Your username: ");
        username = keyboard.nextLine();
        System.out.println("You can now type messages. Enjoy!");

        init();
    }

    private void init() throws JMSException, NamingException {
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Destination destination = (Destination) context.lookup("topic1");
        connection = factory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        producer = session.createProducer(destination);
        consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener());
    }

    public void handleConnection() throws JMSException {
        boolean isRunning = true;

        connection.start();

        while (isRunning) {
            String userInput = keyboard.nextLine();

            TextMessage msg = session.createTextMessage();
            msg.setText(username + ":" + userInput);

            producer.send(msg);
        }
    }

    public static void main(String[] args) throws NamingException, MalformedURLException, JMSException {
        new ChatClient().handleConnection();
    }

}
