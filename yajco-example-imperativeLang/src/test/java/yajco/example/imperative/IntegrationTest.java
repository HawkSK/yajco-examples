package yajco.example.imperative;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.model.Program;
import yajco.example.imperative.parser.Parser;

import java.io.*;

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
	public void simpleExampleTest() throws Exception {
		executeProgram("/simpleProgram");
		Assert.assertEquals("10" + NL +
						"9" + NL +
						"8" + NL +
						"7" + NL +
						"6" + NL +
						"5" + NL +
						"4" + NL +
						"3" + NL +
						"2" + NL +
						"1" + NL +
						"0" + NL +
						"1" + NL +
						"2" + NL +
						"3" + NL +
						"4" + NL +
						"5" + NL +
						"6" + NL +
						"7" + NL +
						"8" + NL +
						"9" + NL +
						"10" + NL +
						"{a=39845888, b=0, c=20, i=11}" + NL,
				outContent.toString());
	}

	@Test
	public void complexExampleTest() throws Exception {
		executeProgram("/complexProgram");
		Assert.assertEquals("17" + NL +
						"18" + NL +
						"19" + NL +
						"20" + NL +
						"21" + NL +
						"22" + NL +
						"23" + NL +
						"24" + NL +
						"25" + NL +
						"26" + NL +
						"{a=39845888, b=0, c=20}" + NL,
				outContent.toString());
	}

	private void executeProgram(String source) throws Exception {
		Reader reader = new BufferedReader(new InputStreamReader(
				Main.class.getResourceAsStream(source)));
		Program program = new Parser().parse(reader);

		program.execute();
		System.out.println(Machine.getInstance());
	}


}
