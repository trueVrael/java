package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Server implements Runnable {

	public int port;
	public ServerSocketChannel sChannel;
	private Selector select;
	public ArrayList<SocketChannel> clientList;

	public Server(int port) throws Exception {

		// System.out.println(port);
		sChannel = ServerSocketChannel.open();
		clientList = new ArrayList<>();
		sChannel.socket().bind(new InetSocketAddress(port));
		sChannel.configureBlocking(false);
		select = Selector.open();

		sChannel.register(select, SelectionKey.OP_ACCEPT);

		System.out.println("Selector server is ready to take message!");

	}

	@Override
	public void run() {

		boolean serverIsRunning = true;
		while (serverIsRunning) {
			try {
				select.select();
				Set keys = select.selectedKeys();
				Iterator iter = keys.iterator();
				while (iter.hasNext()) {
					SelectionKey key = (SelectionKey) iter.next();
					iter.remove();

					if (key.isAcceptable()) {
						SocketChannel cc = sChannel.accept();
						cc.configureBlocking(false);
						cc.register(select, SelectionKey.OP_READ);
						clientList.add(cc);
						continue;
					}

					if (key.isReadable()) {
						SocketChannel cc = (SocketChannel) key.channel();
						serviceRequest(cc);
						continue;
					}
				}
			} catch (Exception exc) {
				exc.printStackTrace();
				continue;
			}
		}

	}

	private void serviceRequest(SocketChannel cc) {
		// TODO Auto-generated method stub

		if (!cc.isOpen()) {
			return;
		}
		if (!cc.isBlocking()) {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			try {
				buf.clear();
				if (cc.read(buf) > 0) {
					cc.read(buf);
				}
				String fromClient = new String(buf.array());
				
				if (!fromClient.trim().equals("Close")) {
					
					writeToAllClients(fromClient);
				} else {
					System.out.println("Client logout!");
					cc.close();
				}
			} catch (IOException e) {
				 e.printStackTrace();
			}
		}

	}

	public void writeToAllClients(String string) throws IOException {
		for (SocketChannel cc : clientList) {
			if (cc.isOpen() && cc.isConnected()) {

				ByteBuffer buffer = ByteBuffer.allocate(string.length());
				buffer.put(string.getBytes());
				buffer.flip();
				cc.write(buffer);
			}
		}
	}

	public static void main(String[] args) {
		try {
			Server server1 = new Server(1912);
			server1.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
