package ar.com.unwebmaster.rovers.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import ar.com.unwebmaster.rovers.executor.RoversSystemExecutor;
import ar.com.unwebmaster.rovers.parser.StringRoverExecutionParser;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RoverRequestHandler implements HttpHandler {
	private RoversSystemExecutor executor = new RoversSystemExecutor();
	private StringRoverExecutionParser parser = new StringRoverExecutionParser();

	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("Serving " + exchange.getRequestURI().toString());
		OutputStream responseBody = exchange.getResponseBody();
		try {
			Headers responseHeaders = exchange.getResponseHeaders();
			exchange.sendResponseHeaders(200, 0);

			String query = exchange.getRequestURI().getQuery();
			if (query != null && !query.isEmpty() ) {
				responseHeaders.set("Content-Type", "text/plain");
				String[] queries = query.split("&");
				String[] partsOfQuery = queries[0].split("=", 2);

				responseBody.write(executor.execute(parser.parse(partsOfQuery[1].replace("+", ""))).getBytes());
			} else {
				InputStream indexFile = this.getClass().getResourceAsStream("/index.html");

				responseHeaders.set("Content-Type", "text/html");
				int read;
				while ((read = indexFile.read()) != -1) {
					responseBody.write(read);
				}
			}
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			responseBody.write("ERROR".getBytes());
		} finally {
			responseBody.close();
		}
	}
}