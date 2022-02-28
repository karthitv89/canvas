package com.karthik.canvas.command.args;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommandParamBucketFill extends CommandParam_2 {
    private char color;

    /**
     * Must be called after checking the isValid method
     *
     * @param params
     */
    public CommandParamBucketFill(String[] params) {
        super(Arrays.copyOfRange(params, 0, 2));
        this.color = params[2].charAt(0); // Just take first char
    }
}
