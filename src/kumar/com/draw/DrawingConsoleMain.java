package kumar.com.draw;
import java.util.Scanner;

import kumar.com.command.CanvasCommand;
import kumar.com.command.Command;
import kumar.com.command.CommandFactory;
import kumar.com.command.QuitCommand;
import kumar.com.command.ShapeCommand;
import kumar.com.shape.Canvas;
import kumar.com.shape.CanvasImpl;
import kumar.com.shape.ShapeFactory;



public class DrawingConsoleMain {
	


	private static Canvas canvas;
	private static Scanner scanner;
	private static CommandFactory commandFactory = new CommandFactory();;
	private static ShapeFactory entityFactory = new ShapeFactory();

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		scanner = new Scanner(System.in);

		System.out.println("Enter command:");
		DrawingConsoleMain obj = new DrawingConsoleMain();
		while (true) {
			obj.process(scanner.nextLine());
			System.out.println("Enter command:");
		}
	}

	public void process(String commandLine) {
		Command command = null;

		try {
			command = commandFactory.getCommand(commandLine);
		} catch (Exception e) {
			System.out.println("Please enter a valid command.");
		}

		if (command instanceof QuitCommand) {
			quit();
		}

		if (command instanceof CanvasCommand) {
			createNewCanvas((CanvasCommand) command);
			return;
		}

		if (command instanceof ShapeCommand) {
			draw((ShapeCommand) command);
		}
	}

	private static void draw(ShapeCommand command) {
		if (canvas == null) {
			System.out.println("You need to create a Canvas first");
			return;
		}
		try {
			canvas.drawShape(entityFactory.getShape(command));
			System.out.println(canvas.render());
		} catch (Exception e) {
			System.out.println("Can not add the model to canvas: " + e.getMessage());
		}
	}

	private static void createNewCanvas(CanvasCommand command) {
		canvas = new CanvasImpl(command.getWidth(), command.getHeight());
		System.out.println(canvas.render());
	}

	private static void quit() {
		scanner.close();
		System.out.println("Exit this drawing program");
		System.exit(0);
	}



}
