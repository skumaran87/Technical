package kumar.com.shape;

import kumar.com.util.Utility;

public class Rectangle implements Shape{
	

	private Integer x1Point;
    private Integer y1Point;
    private Integer x2Point;
    private Integer y2Point;

    public Rectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
        Utility.validatePositiveNumbers(x1, y1, x2, y2);
        if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
            this.x1Point = x2;
            this.y1Point = y2;
            this.x2Point = x1;
            this.y2Point = y1;
        } else {
            this.x1Point = x1;
            this.y1Point = y1;
            this.x2Point = x2;
            this.y2Point = y2;
        }
    }

    public Integer getX1Point() {
        return x1Point;
    }

    public Rectangle setX1Point(Integer x1) {
        this.x1Point = x1;
        return this;
    }

    public Integer getY1Point() {
        return y1Point;
    }

    public Rectangle setY1Point(Integer y1) {
        this.y1Point = y1;
        return this;
    }

    public Integer getX2Point() {
        return x2Point;
    }

    public Rectangle setX2Point(Integer x2) {
        this.x2Point = x2;
        return this;
    }

    public Integer getY2Point() {
        return y2Point;
    }

    public Rectangle setY2(Integer y2) {
        this.y2Point = y2;
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

        Rectangle rectangle = (Rectangle) object;

        if (x1Point != rectangle.x1Point) {
        	return false;
        }
        if (y1Point != rectangle.y1Point) {
        	return false;
        }
        if (x2Point != rectangle.x2Point) {
        	return false;
        }
        return y2Point == rectangle.y2Point;
    }

    @Override
    public int hashCode() {
        int result = x1Point;
        result = 31 * result + y1Point;
        result = 31 * result + x2Point;
        result = 31 * result + y2Point;
        return result;
    }
    



}
