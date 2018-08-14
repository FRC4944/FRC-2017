package org.usfirst.frc.team4944.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

final class Server implements Runnable {

	private ServerSocket serverSocket;
	private Connector connection;
	private Robot bot;

	Server(final Robot robot) {
		bot = robot;
		try {
			serverSocket = new ServerSocket(5800);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public final void run() {
		while (true) {
			if (connection != null) {
				if (!connection.ping()) {
					connect();
				}
			} else
				connect();
			try {
				Thread.sleep(2000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private final void connect() {
		try {
			connection = new Connector();
			new Thread(connection).start();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	final void send(final String string) {
		connection.send(string);
	}

	private final class Connector implements Runnable {

		private PrintWriter writer;
		private BufferedReader reader;
		private Socket socket;
		private boolean pinged = false;

		private Connector() throws IOException {
			socket = serverSocket.accept();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		}

		@Override
		public void run() {
			try {
				String string;
				while ((string = reader.readLine()) != null) {
					pinged = true;
					if (string.equals("ping"))
						send("ping");
					else {
						//System.out.println("Command: " + string);
						final String[] command = string.split(" ");
						switch (command[0]) {
						case "auto": {
							bot.setAuto(command[1]);
							break;
						}
						case "pos": {
							bot.setSide(command[1]);
							break;
						}
						case "delay":{
							bot.setDelay(Byte.parseByte(command[1]));
							break;
						}
						case "null":
							bot.setGotoNull(Boolean.parseBoolean(command[1]));
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private final boolean ping() {
			pinged = false;
			send("ping");
			try {
				Thread.sleep(500);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			return pinged;
		}

		private final void send(final String string) {
			writer.println(string);
		}
	}
}