package kumar.com.shape;

import kumar.com.util.Utility;

public class FillColour implements Shape {


    private Integer  xPoint;
    private Integer  yPoint;
    private char charToFill;

    public FillColour(Integer x, Integer y, char fillChar) {
        Utility.validatePositiveNumbers(x, y);
        this.xPoint = x;
        this.yPoint = y;
        this.charToFill = fillChar;
    }

    public Integer getXPoint() {
        return xPoint;
    }

    public FillColour setXPoint(Integer x) {
        this.xPoint = x;
        return this;
    }

    public Integer getYPoint() {
        return yPoint;
    }

    public FillColour setYPoint(Integer y) {
        this.yPoint = y;
        return this;
    }

    public char getCharToFill() {
        return charToFill;
    }

    public FillColour setCharacter(char fillChar) {
        this.charToFill = fillChar;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
        	return true;
        }
        if (object == null || getClass() != object.getClass()) {
        	return false;
        }

        FillColour that = (FillColour) object;

        if (xPoint != that.xPoint) {
        	return false;
        }
        if (yPoint != that.yPoint) {
        	return false;
        }
        return charToFill == that.charToFill;
    }

    @Override
    public int hashCode() {
        int result = xPoint;
        result = 31 * result + yPoint;
        result = 31 * result + (int) charToFill;
        return result;
    }



}
