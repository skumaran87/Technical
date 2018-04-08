package kumar.com.command;

import kumar.com.util.Utility;

public class CanvasCommand implements Command{
	

	
    private Integer height;
    private Integer width;
    
    public CanvasCommand(String... inputCommand) {
        if (inputCommand.length < 2)
        	System.out.println("Canvas command expects 2 parameters");
        try {
        	
            width = Utility.checkValidInput(inputCommand[0]);
            height = Utility.checkValidInput(inputCommand[1]);
        } catch (IllegalArgumentException e) {
        	System.out.println("Canvas Command Number must >= 0");
        }
    }

    public Integer getHeight() {
        return height;
    }

    public CanvasCommand setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public CanvasCommand setWidth(Integer width) {
        this.width = width;
        return this;
    }



}
