package zad12;

import javax.jms.Message;

public class MessageListener implements javax.jms.MessageListener {
    public void onMessage(Message message) {
        System.out.println(message.toString());
    }
}
