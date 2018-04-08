package kumar.com.command;

import kumar.com.util.Utility;

public class LineCommand implements ShapeCommand {
	   
    private Integer x1Point;
    private Integer y1Point;
    private Integer x2Point;
    private Integer y2Point;

    public LineCommand(String... inputLineCommand) {
        if (inputLineCommand.length < 4)
        	System.out.println("Line command expects 4 parameters");
        try {
            x1Point = Utility.checkValidInput(inputLineCommand[0]);
            y1Point = Utility.checkValidInput(inputLineCommand[1]);
            x2Point = Utility.checkValidInput(inputLineCommand[2]);
            y2Point = Utility.checkValidInput(inputLineCommand[3]);
        } catch (IllegalArgumentException e) {
        	System.out.println("Number should be > 0");
        }
        if (x1Point != x2Point && y1Point != y2Point) {
        	System.out.println("Draw command does not support any diagonal line");
        }
    }

    public Integer getX1Point() {
        return x1Point;
    }

    public LineCommand setX1Point(Integer x1) {
        this.x1Point = x1;
        return this;
    }

    public Integer getY1Point() {
        return y1Point;
    }

    public LineCommand setY1Point(Integer y1) {
        this.y1Point = y1;
        return this;
    }

    public Integer getX2Point() {
        return x2Point;
    }

    public LineCommand setX2Point(Integer x2) {
        this.x2Point = x2;
        return this;
    }

    public Integer getY2Point() {
        return y2Point;
    }

    public LineCommand setY2Point(Integer y2) {
        this.y2Point = y2;
        return this;
    }



}
