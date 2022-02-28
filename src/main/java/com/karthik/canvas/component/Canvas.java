package com.karthik.canvas.component;

import com.karthik.canvas.command.args.CommandParamBucketFill;
import com.karthik.canvas.command.args.CommandParam_4;
import com.karthik.canvas.command.args.CreateCommandParam;
import lombok.Getter;

public final class Canvas {

    @Getter
    private final int width;
    @Getter
    private final int height;
    private final char[][] canvas;

    private static Canvas canvasObj = null;

    private Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new char[height + 2][width + 2];
        init();
    }

    public static Canvas getInstance() {
        if (canvasObj == null) {
            System.err.println("You have to call init first"); // Throw error
        }

        return canvasObj;
    }


    public void clear() {
        init();
    }

    public synchronized static Canvas init(CreateCommandParam createCommandParam) {
        if (canvasObj != null) {
            return canvasObj;
        }
        canvasObj = new Canvas(createCommandParam.getWidth(), createCommandParam.getHeight());
        return canvasObj;
    }

    private void init() {
        // start thw canvas with empty strings
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        // Top line
        drawHorizontalBorderLine(0);

        // left line
        drawVerticalBorderLine(0);
        // Bottom line
        drawVerticalBorderLine(width + 1);

        // Top line
        drawHorizontalBorderLine(height + 1);

        printCanvas();
    }

    private void drawVerticalBorderLine(int width) {
        // right line
        for (int i = 1; i <= height; i++) {
            canvas[i][width] = '|';
        }
    }

    private void drawHorizontalBorderLine(int row) {
        for (int i = 0, j; i <= width + 1; i++) {
            canvas[row][i] = '-';
        }
    }

    public void printCanvas() {
        for (int i = 0; i <= height + 1; i++) {
            for (int j = 0; j <= width + 1; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    // 1 2 6 2
    public boolean createLine(CommandParam_4 commandParam) {
        int x1 = commandParam.getX1();
        int y1 = commandParam.getY1();
        int x2 = commandParam.getX2();
        int y2 = commandParam.getY2();

        if (checkBoundaryCondition(x1, y1, x2, y2)) {
            return false;
        }
        // vertical line (Y Axis will be same)
        boolean isVLine = y1 == y2;
        // Horizontal line (X axis will be same)
        boolean isHLine = x1 == x2;
        if (!isVLine && !isHLine) { // not vertical line and not horizontal line
            System.out.println("Only Horizontal or Vertical lines are supported");
        }
        if (isVLine) {
            for (int i = 1; i <= (x2 - x1) + 1; i++) {
                canvas[y1][(x1 - 1) + i] = 'x';
                canvas[y2][(x1 - 1) + i] = 'x';
            }
        } else if (isHLine) {
            for (int i = 1; i <= (y2 - y1) + 1; i++) {
                canvas[(y1 - 1) + i][x1] = 'x';
                canvas[(y1 - 1) + i][x2] = 'x';
            }
        }

        printCanvas();

        return true; // line created
    }

    // x1 = 14, y1 = 1, x2 = 18, y2 = 5
    public boolean createRectangle(CommandParam_4 commandParam) {
        int x1 = commandParam.getX1();
        int y1 = commandParam.getY1();
        int x2 = commandParam.getX2();
        int y2 = commandParam.getY2();

        if (checkBoundaryCondition(x1, y1, x2, y2)) {
            return false;
        }
        //Outer Loop for number of Rows
        int rectangleHeight = y2 - y1;
        int rectangleWidth = x2 - x1;

        for (int i = 0; i <= rectangleHeight; i++) {
            for (int j = 0; j <= rectangleWidth; j++) {
                if (i == 0 || i == rectangleHeight || j == 0 || j == rectangleWidth) {
                    canvas[i + y1][j + x1] = 'x';
                } else {
                    canvas[i + y1][j + x1] = ' ';
                }
            }

        }

        printCanvas();

        return true;// rectangle created
    }

    //0 column, o row,
    public boolean checkPointWithinBoundary(int row, int col) {
        return col < 1 ||
                row < 1 ||
                row > height
                || col > width
                || canvas[row][col] == '|' || canvas[row][col] == '-';
    }

    public boolean checkPointWithinBoundaryForFiller(int row, int col, char color) {
        return canvas[row][col] == '|' || canvas[row][col] == '-'
                || canvas[row][col] == color || canvas[row][col] == 'x';
    }

    public boolean checkBoundaryCondition(int x1, int y1, int x2, int y2) {
        return checkPointWithinBoundary(y1, x1) || checkPointWithinBoundary(y2, x2);
    }

    // https://www.youtube.com/watch?v=CEHG0VZmnYQ&t=29s
    public boolean bucketFill(CommandParamBucketFill commandParam) {
        int column = commandParam.getX();
        int row = commandParam.getY();
        char color = commandParam.getColor();

        if (checkPointWithinBoundary(row, column)) {
            return false;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        dfsFloodFill(column, row, color, directions);
        printCanvas();
        return true;
    }

    // Row - y, col - x
    private void dfsFloodFill(int col, int row, char color, int[][] directions) {
        if (checkPointWithinBoundaryForFiller(row, col, color)) {
            return;
        }
        canvas[row][col] = color;
        for (int[] direction : directions) {
            dfsFloodFill(col + direction[1], row + direction[0], color, directions);
        }
    }
}
