package com.karthik.canvas;

import com.karthik.canvas.command.BucketFillCommand;
import com.karthik.canvas.command.Command;
import com.karthik.canvas.command.LineCommand;
import com.karthik.canvas.command.RectangleCommand;
import com.karthik.canvas.command.args.CreateCommandParam;
import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.model.Operation;
import com.karthik.canvas.util.CanvasUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "";
        do {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine().replaceAll("\\s{2,}", " ").trim();
            System.out.println(input);
            drawApp(input);
        } while (true);
    }

    static boolean drawApp(String input) {
        String[] inputArgs = input.split("\\s");
        CanvasUtils.CommandType commandType = CanvasUtils.CommandType.lookup(inputArgs[0]);
        String[] params = null;
        if (inputArgs.length > 1) {
            params = Arrays.copyOfRange(inputArgs, 1, inputArgs.length);
        }
        try {
            Operation operation = new Operation(commandType, params);
            Command command = null;

            switch (commandType) {
                case C:
                    if (Canvas.getInstance() != null) {
                        return false;
                    }
                    CreateCommandParam commandParam = (CreateCommandParam) operation.getCommandParams();
                    Canvas.init(commandParam);
                    break;
                case B:
                    command = new BucketFillCommand(Canvas.getInstance(), operation);
                    break;
                case L:
                    command = new LineCommand(Canvas.getInstance(), operation);
                    break;
                case R:
                    command = new RectangleCommand(Canvas.getInstance(), operation);
                    break;
                case Q:
                    System.exit(0);
                case INVALID:
                default:
                    System.out.println("Invalid input");
                    break;
            }
            if (command != null) {
                return command.execute();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }
}
