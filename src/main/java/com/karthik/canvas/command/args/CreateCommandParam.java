package com.karthik.canvas.command.args;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateCommandParam extends CommandParam {
    private int width, height;

    /**
     * Must be called after checking the isValid method
     * @param params
     */
    public CreateCommandParam(String[] params) {
        this.width = Integer.parseInt(params[0]);
        this.height = Integer.parseInt(params[1]);
    }
}
