package com.karthik.canvas.command;

import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.util.CanvasUtils;
import com.karthik.canvas.command.args.CommandParam_4;
import com.karthik.canvas.model.Operation;

import static com.karthik.canvas.util.CanvasUtils.CommandType.R;

public class RectangleCommand extends Command {

    public RectangleCommand(Canvas canvas, Operation param) {
        super(canvas, param);
    }

    @Override
    public boolean execute() {
        return canvas.createRectangle((CommandParam_4) params.getCommandParams());
    }

    @Override
    public CanvasUtils.CommandType getCommandType() {
        return R;
    }


}
