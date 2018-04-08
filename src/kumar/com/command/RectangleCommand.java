package kumar.com.command;

import kumar.com.util.Utility;

public class RectangleCommand implements ShapeCommand {
	

	

    private Integer x1Point;
    private Integer y1Point;
    private Integer x2Point;
    private Integer y2Point;

    public RectangleCommand(String... inputDrawRectangleCmd) {
        if (inputDrawRectangleCmd.length < 4)
        	System.out.println("Draw Rectangle command expects 4 params");
        try {
            x1Point = Utility.checkValidInput(inputDrawRectangleCmd[0]);
            y1Point = Utility.checkValidInput(inputDrawRectangleCmd[1]);
            x2Point = Utility.checkValidInput(inputDrawRectangleCmd[2]);
            y2Point = Utility.checkValidInput(inputDrawRectangleCmd[3]);
        } catch (IllegalArgumentException e) {
        	System.out.println("Number can not be negative");
        }
    }

    public Integer getX1Point() {
        return x1Point;
    }

    public RectangleCommand setX1Point(Integer x1) {
        this.x1Point = x1;
        return this;
    }

    public Integer getY1Point() {
        return y1Point;
    }

    public RectangleCommand setY1Point(Integer y1) {
        this.y1Point = y1;
        return this;
    }

    public Integer getX2Point() {
        return x2Point;
    }

    public RectangleCommand setX2Point(Integer x2) {
        this.x2Point = x2;
        return this;
    }

    public Integer getY2Point() {
        return y2Point;
    }

    public RectangleCommand setY2Point(Integer y2) {
        this.y2Point = y2;
        return this;
    }



}
