package artnetremote.server.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import artnetremote.gui.models.RemoteModel;
import artnetremote.server.ArtNetServerManager;
import artnetremote.server.BadSyntaxException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * This handler process data requests.
 * These request send commandLine value by POST method
 * @author Jeremie GASTON-RAOUL
 *
 */
public class DataHttpHandler implements HttpHandler {

	private static final int MAX_BUFFER_SIZE = 1024*512;
	private static ArtNetServerManager artNetServerManager = ArtNetServerManager.getInstance();

	private final transient Logger logger = Logger.getLogger(RemoteModel.class.getName());
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		if(httpExchange.getRequestMethod().equalsIgnoreCase("POST")){
			InputStream is = httpExchange.getRequestBody();
			
			byte buffer[]=new byte[DataHttpHandler.MAX_BUFFER_SIZE]; 
			int bytesRead = 0;
			
			StringBuilder commandLine = new StringBuilder();
			
			while( (bytesRead = is.read(buffer)) != -1 ) {
				commandLine.append(new String(buffer,0,bytesRead));
			}
			is.close();

			try {
				DataHttpHandler.artNetServerManager.processCommandLine(commandLine.toString());
				logger.info("Command line : "+commandLine);
				DataHttpHandler.artNetServerManager.sendDmxCommand();
				logger.info("broadcast DMX packet sent");
			} catch (BadSyntaxException e) {
				logger.severe("Bad syntax in Command Line");
				String badRequest = "400 : Bad request !!!";
				httpExchange.sendResponseHeaders(400, badRequest.length());
				httpExchange.getResponseBody().write(badRequest.getBytes());
				httpExchange.getResponseBody().close();
			}

			String responseOk = "200 : OK !";
			httpExchange.sendResponseHeaders(200, responseOk.length());
			httpExchange.getResponseBody().write(responseOk.getBytes());
			httpExchange.getResponseBody().close();
		}
		else{
			String badMethod = "405 : Method not allowed !!!";
			httpExchange.sendResponseHeaders(405, badMethod.length());
			httpExchange.getResponseBody().write(badMethod.getBytes());
			httpExchange.getResponseBody().close();
		}
	}

}