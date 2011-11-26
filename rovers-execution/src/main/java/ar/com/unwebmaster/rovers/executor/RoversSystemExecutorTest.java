package ar.com.unwebmaster.rovers.executor;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import ar.com.unwebmaster.rovers.parser.StringRoverExecutionParser;

public class RoversSystemExecutorTest {

	private RoversSystemExecutor executor;
	private StringRoverExecutionParser parser;

	@Before
	public void setUp() throws Exception {
		executor = new RoversSystemExecutor();
		parser = new StringRoverExecutionParser();
	}

	@Test
	public void testExecute() {
		RoverExecutionSpecification executionSpecification = parser.parse("5 5\n1 2 n\nlmlmlmlmm\n3 3 e\nmmrmmrmrrm");
		String result = executor.execute(executionSpecification);
		Assert.assertEquals("1 3 N\n5 1 E\n", result);
	}
}