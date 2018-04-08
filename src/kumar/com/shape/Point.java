package kumar.com.shape;

import kumar.com.util.Utility;

public class Point {
	
	private Integer xPoint;
    private Integer yPoint;
	
    public Point(Integer x1, Integer y1) {
        Utility.validatePositiveNumbers(x1, y1);
        this.xPoint = x1;
        this.yPoint = y1;
    }
    

    public Integer getX() {
        return xPoint;
    }

    public Point setX(Integer x) {
        this.xPoint = x;
        return this;
    }

    public Integer getY() {
        return yPoint;
    }

    public Point setY(Integer y) {
        this.yPoint = y;
        return this;
    }


}
