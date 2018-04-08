package kumar.com.shape;

import kumar.com.command.FillColourCommand;
import kumar.com.command.LineCommand;
import kumar.com.command.RectangleCommand;
import kumar.com.command.ShapeCommand;

public class ShapeFactory {
	


	 public Shape getShape(ShapeCommand command) {
	        if (command instanceof LineCommand) {
	            LineCommand cmd = (LineCommand) command;
	            return new Line(cmd.getX1Point(), cmd.getY1Point(), cmd.getX2Point(), cmd.getY2Point());
	        } else if (command instanceof RectangleCommand) {
	            RectangleCommand cmd = (RectangleCommand) command;
	            return new Rectangle(cmd.getX1Point(), cmd.getY1Point(), cmd.getX2Point(), cmd.getY2Point());
	        } else if (command instanceof FillColourCommand) {
	            FillColourCommand cmd = (FillColourCommand) command;
	            return new FillColour(cmd.getXPoint(), cmd.getYPoint(), cmd.getCharToFillColour());
	        }
	        return null;
	    }
	 


}
