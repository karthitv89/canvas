package com.karthik.canvas.model;

import com.karthik.canvas.command.args.CommandParam;
import com.karthik.canvas.util.CanvasUtils;
import lombok.*;

@Getter
@Setter
public class Operation {
    @NonNull
    private CanvasUtils.CommandType commandType;
    @NonNull
    private String[] params;
    private CommandParam commandParams;

    public Operation(CanvasUtils.CommandType commandType, String[] params) {
        this.commandType = commandType;
        this.params = params;
        if (!CanvasUtils.validateAndAssignParams(this)) {
            throw new IllegalArgumentException("Illegal argument");
        }
    }
}
