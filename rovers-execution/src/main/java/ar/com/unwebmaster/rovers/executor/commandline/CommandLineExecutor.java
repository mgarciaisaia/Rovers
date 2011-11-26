package ar.com.unwebmaster.rovers.executor.commandline;

import java.util.logging.Logger;
import ar.com.unwebmaster.rovers.executor.RoverExecutionSpecification;
import ar.com.unwebmaster.rovers.executor.RoversSystemExecutor;
import ar.com.unwebmaster.rovers.parser.StringRoverExecutionParser;

public class CommandLineExecutor {
	private static Logger logger = Logger.getLogger(CommandLineExecutor.class.getName());

	public static void main(String[] arguments) {
		if (arguments.length < 1) {
			System.err.println("No argument supplied");
			showUsage();
			return;
		}
		if (arguments.length == 1 && (arguments[0].equals("--help") || arguments[0].equals("-h"))) {
			showUsage();
			return;
		}
		String inputLine = "";
		for (String argument : arguments) {
			inputLine += argument + " ";
		}

		StringRoverExecutionParser parser = new StringRoverExecutionParser();
		try {
			RoverExecutionSpecification specification = parser.parse(inputLine);
			RoversSystemExecutor executor = new RoversSystemExecutor();
			try {
				System.out.print(executor.execute(specification));
			} catch (Exception e) {
				logger.severe("Error executing specification\n" + e);
				System.err.println("Fatal error while executing request");
				// I miss you, Log4j
				return;
			}
		} catch (Exception e) {
			logger.severe("Error executing specification\n" + e);
			System.err.println("Error while trying to parse your request - bugous input?");
			showUsage();
			return;
		}
	}

	private static void showUsage() {
		System.out.println("**** USAGE: rovers [[-h | --help] | ROVERS_DEFINITION ]");
		System.out.println();
		System.out.println("rovers ROVERS_DEFINITION");
		System.out.println("	Executes Rovers with ROVERS_DEFINITION as input");
		System.out.println("rovers --help");
		System.out.println("rovers -h");
		System.out.println("	Shows this info and exit");
	}
}