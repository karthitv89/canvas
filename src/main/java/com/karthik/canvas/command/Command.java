package com.karthik.canvas.command;

import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.util.CanvasUtils;
import com.karthik.canvas.model.Operation;

public abstract class Command {
    protected Canvas canvas;
    protected Operation params;

    Command(Canvas canvas, Operation param) {
        this.canvas = canvas;
        this.params = param;
        //CanvasUtils.validateAndAssignParams(params);
    }

    public void clear() {
        canvas.clear();
    }

    public abstract boolean execute();
    public abstract CanvasUtils.CommandType getCommandType();
}
