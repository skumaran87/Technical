package kumar.com.shape;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CanvasImpl implements Canvas{

	private static final char HORIZONTAL_LINE = '-';
	private static final char VERTICAL_LINE = '|';
	private static final char LINE_CHAR = 'x';

	private final char[][] canvasArray;
	private final Integer width;
	private final Integer height;
	private LinkedList<Shape> shapes;
	private final String canvasWidthLine;
	char reference;

	public CanvasImpl(Integer width, Integer height) {
		this.width = width;
		this.height = height;
		this.shapes = new LinkedList<>();
		this.canvasArray = new char[this.height][this.width];
		Arrays.stream(this.canvasArray).forEach(chars -> Arrays.fill(chars, ' '));
		this.canvasWidthLine = Stream.generate(() -> String.valueOf(HORIZONTAL_LINE)).limit(width + 2)
				.collect(Collectors.joining());
	}

	@Override
	public void drawShape(Shape shape) {
		shapes.add(shape);
		if (shape instanceof Line) {
			drawLine((Line) shape);
		} else if (shape instanceof Rectangle) {
			drawRectangle((Rectangle) shape);
		} else if (shape instanceof FillColour) {
			doColorFill((FillColour) shape);
		}
	}

	@Override
	public String render() {
		StringBuilder canvasDrawingResponse = new StringBuilder();
	//	System.out.println("horizontalEdge>>"+canvasWidthLine);
		canvasDrawingResponse.append(canvasWidthLine).append("\n");
		for (int i = 0; i < this.height; i++) {
			canvasDrawingResponse.append(VERTICAL_LINE);
			for (int j = 0; j < this.width; j++) {
				canvasDrawingResponse.append(canvasArray[i][j]);
			}
			canvasDrawingResponse.append(VERTICAL_LINE);
			canvasDrawingResponse.append("\n");
		}
		canvasDrawingResponse.append(canvasWidthLine);
		return canvasDrawingResponse.toString().trim();
	}

	private void doColorFill(FillColour fillColor) {
		if (isPointsOutsideCanvas(fillColor.getXPoint(), fillColor.getYPoint())) {
			System.out.println("Canvas fill point is outside of canvas");
		}
		reference = canvasArray[fillColor.getYPoint() - 1][fillColor.getXPoint() - 1];
		fillCanvasColour(fillColor.getXPoint(), fillColor.getYPoint(), fillColor.getCharToFill());
	}

	private void drawRectangle(Rectangle rec) {
		if (isPointsOutsideCanvas(rec.getX1Point(), rec.getY1Point())) {
			System.out.println("Rectangle is outside of canvas");
		}
		drawRectangle(rec.getX1Point(), rec.getY1Point(), rec.getX2Point(), rec.getY2Point(), LINE_CHAR);
	}

	private void drawLine(Line line) {
		if (isPointsOutsideCanvas(line.getX1Point(), line.getY1Point())) {
			System.out.println("Line is outside of canvas");
		}

		// trim the part the is outside
		if (line.getX2Point() >= width) {
			line.setX2Point(width);
		}
		if (line.getY2Point() >= height) {
			line.setY2Point(height);
		}
		drawLine(line.getX1Point(), line.getY1Point(), line.getX2Point(), line.getY2Point(), LINE_CHAR);
	}

	private void drawLine(Integer x1, Integer y1, Integer x2, Integer y2, char fillChar) {

		for (Integer row = y1 - 1; row <= y2 - 1 && row < height; row++) {

			for (Integer column = x1 - 1; column <= x2 - 1 && column < width; column++) {
				canvasArray[row][column] = fillChar;
			}
		}
	}

	private void fillCanvasColour(Integer x, Integer y, char mchar) {
		if (x > 0 && y > 0 && x <= this.width && y <= this.height && canvasArray[y - 1][x - 1] != reference) {
			return;
		}

		if ((x - 1 >= 0 && x <= this.width) && (y - 1 >= 0 && y <= this.width)) {
			if (canvasArray[y - 1][x - 1] == reference) {
				canvasArray[y - 1][x - 1] = mchar;
			}

			if (x + 1 <= this.width)
				fillCanvasColour(x + 1, y, mchar);
			if (x > 0)
				fillCanvasColour(x - 1, y, mchar);
			if (y > 0)
				fillCanvasColour(x, y - 1, mchar);
			if (y + 1 <= this.height)
				fillCanvasColour(x, y + 1, mchar);

		}
	}

	private void drawRectangle(Integer x1, Integer y1, Integer x2, Integer y2, char fillChar) {

		drawLine(x1, y1, x2, y1, fillChar);
		drawLine(x1, y1, x1, y2, fillChar);
		drawLine(x2, y1, x2, y2, fillChar);
		drawLine(x1, y2, x2, y2, fillChar);
	}

	private boolean isPointsOutsideCanvas(Integer x, Integer y) {
		return x < 1 || x > width || y < 1 || y > height;
	}



}
