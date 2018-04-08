package test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import kumar.com.command.CanvasCommand;
import kumar.com.command.CommandFactory;
import kumar.com.draw.DrawingConsoleMain;

@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {


	
	@Mock
	CommandFactory commandFactory;

	@InjectMocks
	DrawingConsoleMain javaConsole;
	
	CanvasCommand canvasCommand;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	    System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	} 
	
	@Test
	public void test5x5CanvasDrawingConsole(){
		Integer width = 5;
		Integer height = 5;
		canvasCommand = new CanvasCommand(new String[] {"5","5"});
		when(commandFactory.getCommand(anyString())).thenReturn(canvasCommand);
		javaConsole.process("C 5 5");
		assertEquals(render(height, width), outContent.toString().trim());
		
	}
	
	@After
	public void clearStream() {
		System.setOut(System.out);
		System.setErr(System.err);
	}
	
	
	public String render(Integer height, Integer width ) {
		StringBuilder canvasDrawingResponse = new StringBuilder();
		char[][] canvasArray = new char[height][width];
		Arrays.stream(canvasArray).forEach(chars -> Arrays.fill(chars, ' '));
		String canvasWidthLine = Stream.generate(() -> String.valueOf("-")).limit(width + 2)
				.collect(Collectors.joining());
		canvasDrawingResponse.append(canvasWidthLine).append("\n");
		for (int i = 0; i < height; i++) {
			canvasDrawingResponse.append("|");
			for (int j = 0; j < width; j++) {
				canvasDrawingResponse.append(canvasArray[i][j]);
			}
			canvasDrawingResponse.append("|");
			canvasDrawingResponse.append("\n");
		}
		canvasDrawingResponse.append(canvasWidthLine);
		return canvasDrawingResponse.toString().trim();
	}



}
