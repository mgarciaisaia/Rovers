package ar.com.unwebmaster.executor.commands;

import org.junit.Assert;
import org.junit.Test;

public class RoverCommandTest {
	@Test
	public void testEquals() {
		Assert.assertEquals("MoveForward's are distinct", new MoveForward(), new MoveForward());
		Assert.assertFalse("MoveForward equals LeftSpin", new MoveForward().equals(new LeftSpin()));
	}
}