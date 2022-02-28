package com.karthik.canvas;

import com.karthik.canvas.command.args.CommandParam_4;
import com.karthik.canvas.component.Canvas;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.karthik.canvas.Main.drawApp;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @AfterAll
    static void quitTest() {
        assertTrue(drawApp("Q"));
    }

    @Test
    void draw() {
        drawApp("C 20 4");
        Canvas canvas = Canvas.getInstance();
        assertEquals(4, canvas.getHeight());
        assertEquals(20, canvas.getWidth());


        assertTrue(drawApp("L 1 2 6 2"));
        assertTrue(drawApp("L 6 3 6 4"));
        assertTrue(drawApp("R 14 1 18 3  "));
        assertTrue(drawApp("B 10 3 o"));
        assertFalse(drawApp("B 10 30 o"));
        assertFalse(drawApp("X 10 3 DD"));

        assertFalse(drawApp("L 12 12"));
        assertFalse(drawApp("L 12 12 43 4334 4334 43"));


        assertFalse(drawApp("L 12 12 43 4334 4334 43"));
    }

    @Test
    void main() {
        Canvas canvas = Canvas.getInstance();
        CommandParam_4 commandParam = new CommandParam_4(new String[]{"20", "4", "1", "4"});
        canvas.createLine(commandParam);// h line

        commandParam = new CommandParam_4(new String[]{"6", "3", "6", "4"});
        canvas.createLine(commandParam);// h line

        commandParam = new CommandParam_4(new String[]{"6", "1", "6", "9"});
        canvas.createLine(commandParam);// h line
    }


}