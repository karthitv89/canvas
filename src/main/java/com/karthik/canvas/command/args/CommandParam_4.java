package com.karthik.canvas.command.args;

import com.karthik.canvas.util.CanvasUtils;
import lombok.Data;

@Data
public class CommandParam_4 extends CommandParam {
    private int x1, x2, y1, y2;

    public CommandParam_4(String[] params) {

        this.x1 = Integer.parseInt(params[0]);
        this.y1 = Integer.parseInt(params[1]);
        this.x2 = Integer.parseInt(params[2]);
        this.y2 = Integer.parseInt(params[3]);

        CanvasUtils.swap(x1, x2);
        CanvasUtils.swap(y1, y2);

    }

}
