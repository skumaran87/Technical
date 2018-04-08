package kumar.com.command;

import kumar.com.util.Utility;

public class FillColourCommand implements ShapeCommand{
	
    private Integer  xPoint;
    private Integer  yPoint;
    private char charToFillColour;

    public FillColourCommand(String... inputFillColour) {
        if (inputFillColour.length < 3)
            System.out.println("Canvas fill expects 3 paramseters");
        if (inputFillColour[2].length() != 1)
        	System.out.println("Colour character should only be 1 character");
        try {
            xPoint = Utility.checkValidInput(inputFillColour[0]);
            yPoint = Utility.checkValidInput(inputFillColour[1]);
            charToFillColour = inputFillColour[2].charAt(0);
        } catch (IllegalArgumentException e) {
        	System.out.println("x or y should be > 0");
        }
    }

    public Integer getXPoint() {
        return xPoint;
    }

    public FillColourCommand setXPoint(Integer x) {
        this.xPoint = x;
        return this;
    }

    public Integer getYPoint() {
        return yPoint;
    }

    public FillColourCommand setYPoint(Integer y) {
        this.yPoint = y;
        return this;
    }

    public char getCharToFillColour() {
        return charToFillColour;
    }

    public FillColourCommand setCharToFillColour(char charToFill) {
        this.charToFillColour = charToFill;
        return this;
    }



}
