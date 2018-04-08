package kumar.com.shape;

import kumar.com.util.Utility;

public class Line implements Shape{


    private Integer x1Point;
    private Integer y1Point;
    private Integer x2Point;
    private Integer y2Point;

    public Line(Integer x1, Integer y1, Integer x2, Integer y2) {
        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException("Draw line does not support diagonal line at the moment");
        }
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

    public Line setX1Point(Integer x1) {
        this.x1Point = x1;
        return this;
    }

    public Integer getY1Point() {
        return y1Point;
    }

    public Line setY1Point(Integer y1) {
        this.y1Point = y1;
        return this;
    }

    public Integer getX2Point() {
        return x2Point;
    }

    public void setX2Point(Integer x2) {
        this.x2Point = x2;
    }

    public Integer getY2Point() {
        return y2Point;
    }

    public void setY2Point(Integer y2) {
        this.y2Point = y2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
        	return true;
        }
        if (object == null || getClass() != object.getClass()) {
        	return false;
        }

        Line line = (Line) object;

        if (x1Point != line.x1Point) {
        	return false;
        }
        if (y1Point != line.y1Point) {
        	return false;
        }
        if (x2Point != line.x2Point) {
        	return false;
        }
        return y2Point == line.y2Point;
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
