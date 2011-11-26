package ar.com.unwebmaster.rovers.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import ar.com.unwebmaster.rovers.web.RoverRequestHandler;
import com.sun.net.httpserver.HttpServer;

public class WebServer {
	public static void main(String[] args) throws IOException {
		Integer portNumber = 0;
		if (args.length == 1) {
			portNumber = Integer.parseInt(args[0]);
		}

		InetSocketAddress addr = new InetSocketAddress(portNumber);
		HttpServer server = HttpServer.create(addr, 0);

		server.createContext("/", new RoverRequestHandler());
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
		System.out.println("Server is listening on port " + addr.getPort());
	}
}