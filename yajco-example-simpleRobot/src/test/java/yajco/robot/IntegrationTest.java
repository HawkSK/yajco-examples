package yajco.robot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.robot.model.Robot;
import yajco.robot.model.parser.Parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IntegrationTest {
	private static final String NL = System.lineSeparator();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}

	@Test
	public void moveTest() throws Exception {
		execute("begin\n\tmove\nend");
		Assert.assertEquals("going straight" + NL, outContent.toString());
	}

	@Test
	public void turnLeftTest() throws Exception {
		execute("begin\n\tturn-left\nend");
		Assert.assertEquals("turning left" + NL, outContent.toString());
	}

	@Test
	public void executeProgramTest() throws Exception {
		execute("begin\n\tturn-left\n\tmove\n\tmove\n\tturn-left\nend");
		final String expected = "turning left" + NL +
				"going straight" + NL +
				"going straight" + NL +
				"turning left" + NL;
		Assert.assertEquals(expected, outContent.toString());
	}

	private void execute(String input) throws Exception {
		Parser parser = new Parser();
		Robot robot = parser.parse(input);
		robot.run();
	}
}
