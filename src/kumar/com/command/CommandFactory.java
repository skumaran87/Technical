package kumar.com.command;

import java.util.Arrays;

public class CommandFactory {
	

	
	 public Command getCommand(String commandLine)  {
	        commandLine = commandLine.trim();//.replaceAll(" {2}", " ");
	        String[] split       = commandLine.split(" ");
	        String   drawCommand = split[0].toUpperCase();
	        String[] params      = Arrays.copyOfRange(split, 1, split.length);
	        switch (drawCommand) {
	            case "Q":
	                return new QuitCommand();
	            case "C":
	                return new CanvasCommand(params);
	            case "L":
	                return new LineCommand(params);
	            case "R":
	                return new RectangleCommand(params);
	            case "B":
	                return new FillColourCommand(params);
	            default:
	                return new CanvasCommand();
	        }
	    }



}
