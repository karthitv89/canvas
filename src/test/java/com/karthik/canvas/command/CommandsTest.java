package com.karthik.canvas.command;

import com.karthik.canvas.command.args.CreateCommandParam;
import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.model.Operation;
import com.karthik.canvas.util.CanvasUtils;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CommandsTest {

    private Operation operation;

    @BeforeAll
    static void init() {
        Canvas.init(new CreateCommandParam(new String[]{"20", "4"}));
    }

    @AfterAll
    static void clear() {
        Canvas.getInstance().clear();
    }

    @Test
    void testBucketFillCommand() {
        operation = new Operation(CanvasUtils.CommandType.B, new String[]{"10", "4", "C"});
        BucketFillCommand command = new BucketFillCommand(Canvas.getInstance(), operation);
        Assertions.assertTrue(command.execute());
    }

    @Test
    void testLineCommand() {
        operation = new Operation(CanvasUtils.CommandType.L, new String[]{"10", "4", "10", "7"});
        LineCommand command = new LineCommand(Canvas.getInstance(), operation);
        Assertions.assertFalse(command.execute());

        operation = new Operation(CanvasUtils.CommandType.L, new String[]{"10", "1", "10", "4"});
        command = new LineCommand(Canvas.getInstance(), operation);
        Assertions.assertTrue(command.execute());

        operation = new Operation(CanvasUtils.CommandType.L, new String[]{"1", "4", "4", "4"});
        command = new LineCommand(Canvas.getInstance(), operation);
        Assertions.assertTrue(command.execute());
    }

    @Test
    void testRectangleCommand() {
        operation = new Operation(CanvasUtils.CommandType.R, new String[]{"10", "4", "10", "7"});
        RectangleCommand command = new RectangleCommand(Canvas.getInstance(), operation);
        Assertions.assertFalse(command.execute());

        operation = new Operation(CanvasUtils.CommandType.R, new String[]{"1", "4", "10", "4"});
        command = new RectangleCommand(Canvas.getInstance(), operation);
        Assertions.assertTrue(command.execute());
    }
}
