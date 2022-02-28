package com.karthik.canvas.util;

import com.karthik.canvas.command.args.CommandParamBucketFill;
import com.karthik.canvas.command.args.CommandParam_4;
import com.karthik.canvas.command.args.CreateCommandParam;
import com.karthik.canvas.model.Operation;

import java.util.Arrays;

public class CanvasUtils {

    public enum CommandType {
        C, // Create canvas
        L, // Draw line
        R, // Draw Rectangle
        B, // Fill Bucket
        Q,
        INVALID; // Quit

        public static CommandType lookup(final String id) {
            for (CommandType enumValue : values()) {
                if (enumValue.name().equalsIgnoreCase(id)) {
                    return enumValue;
                }
            }
            return INVALID;
        }
    }

    public static boolean validateAndAssignParams(Operation operation) {
        switch (operation.getCommandType()) {
            case L:
            case R:
                if (!isValid(operation, 4)) {
                    return false;
                }
                operation.setCommandParams(new CommandParam_4(operation.getParams()));
                break;
            case C:
                if (!isValid(operation, 2)) {
                    return false;
                }
                operation.setCommandParams(new CreateCommandParam(operation.getParams()));
                break;
            case B:
                if (!isValidFillBucket(operation)) {
                    return false;
                }
                operation.setCommandParams(new CommandParamBucketFill(operation.getParams()));
                break;
            case Q:
                return true;
            default:
                return false;
        }
        return true;

    }

    private static boolean isValidFillBucket(Operation operation) {
        String[] params = operation.getParams();
        if (params == null
                || params.length != 3
                || Arrays.stream(params).limit(2).anyMatch(p -> !isInteger(p))
                || params[2].length() != 1) {
            System.out.println("Must input 4 valid integers");
            return false;
        }
        return true;
    }

    private static boolean isValid(Operation operation, int requiredNoOfParams) {
        String[] params = operation.getParams();
        if (params == null
                || params.length != requiredNoOfParams
                || !(Arrays.stream(params).allMatch(CanvasUtils::isInteger))) {
            System.out.println("Must input 4 valid integers");
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    private static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }

    public static void swap(int n1, int n2) {
        int temp;
        if (n1 > n2) {
            temp = n2;
            n2 = n1;
            n1 = temp;
        }
    }
}
