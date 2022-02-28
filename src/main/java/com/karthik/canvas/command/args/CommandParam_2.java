package com.karthik.canvas.command.args;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommandParam_2 extends CommandParam {
    private int x, y;

    /**
     * Must be called after checking the isValid method
     * @param params
     */
    public CommandParam_2(String[] params) {
        this.x = Integer.parseInt(params[0]);
        this.y = Integer.parseInt(params[1]);
    }
}
