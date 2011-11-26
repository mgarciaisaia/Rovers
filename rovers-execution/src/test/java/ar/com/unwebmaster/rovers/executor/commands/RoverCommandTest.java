package ar.com.unwebmaster.rovers.executor.commands;

import org.junit.Assert;
import org.junit.Test;
import ar.com.unwebmaster.rovers.executor.commands.LeftSpin;
import ar.com.unwebmaster.rovers.executor.commands.MoveForward;

public class RoverCommandTest {
	@Test
	public void testEquals() {
		Assert.assertEquals("MoveForward's are distinct", new MoveForward(), new MoveForward());
		Assert.assertFalse("MoveForward equals LeftSpin", new MoveForward().equals(new LeftSpin()));
	}
}