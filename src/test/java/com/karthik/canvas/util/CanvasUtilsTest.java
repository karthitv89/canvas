package com.karthik.canvas.util;

import com.karthik.canvas.command.args.CommandParam_4;
import com.karthik.canvas.command.args.CreateCommandParam;
import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.model.Operation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasUtilsTest {

    @BeforeAll
    static void init() {
        Canvas.init(new CreateCommandParam(new String[]{"10", "5"}));
    }

    @AfterAll
    static void clear() {
        Canvas.getInstance().clear();
    }

    @Test
    void validateAndAssignParams() {
        String[] args = new String[]{"4", "7", "4", "10"};
        Operation operation = new Operation(CanvasUtils.CommandType.R, new String[]{"4", "7", "4", "10"});
        CommandParam_4 commandParam = (CommandParam_4) operation.getCommandParams();
        assertEquals(4, commandParam.getX1());
        assertEquals(7, commandParam.getY1());
        assertEquals(4, commandParam.getX2());
        assertEquals(10, commandParam.getY2());


    }

    @Test
    void testValidateAndAssignParams() {
        Operation operation = new Operation(CanvasUtils.CommandType.L, new String[]{"4", "7", "4", "10"});
        boolean isValid = CanvasUtils.validateAndAssignParams(operation);
        assertTrue(isValid);
        CommandParam_4 commandParam = (CommandParam_4) operation.getCommandParams();
        assertEquals(4, commandParam.getX1());
        assertEquals(7, commandParam.getY1());
        assertEquals(4, commandParam.getX2());
        assertEquals(10, commandParam.getY2());

        Operation newLineOperation = new Operation(CanvasUtils.CommandType.L, new String[]{"4", "7", "5", "10"});
        assertTrue(CanvasUtils.validateAndAssignParams(newLineOperation));

        assertThrows(IllegalArgumentException.class, () -> new Operation(CanvasUtils.CommandType.L, new String[]{"4", "7", "5", "10", "12"}));

        assertThrows(IllegalArgumentException.class, () -> new Operation(CanvasUtils.CommandType.L, new String[]{"4", "7", "5"}));

        Operation buketFillOperationValid = new Operation(CanvasUtils.CommandType.B, new String[]{"4", "7", "C"});
        assertTrue(CanvasUtils.validateAndAssignParams(buketFillOperationValid));

    }

    @Test
    void isInteger() {
        assertTrue(CanvasUtils.isInteger("0"));
        assertFalse(CanvasUtils.isInteger("S"));
    }

}