package com.karthik.canvas.command;

import com.karthik.canvas.component.Canvas;
import com.karthik.canvas.util.CanvasUtils;
import com.karthik.canvas.command.args.CommandParamBucketFill;
import com.karthik.canvas.model.Operation;

import static com.karthik.canvas.util.CanvasUtils.CommandType.R;

public class BucketFillCommand extends Command {

    public BucketFillCommand(Canvas canvas, Operation param) {
        super(canvas, param);
    }

    @Override
    public boolean execute() {
        return canvas.bucketFill((CommandParamBucketFill) params.getCommandParams());
    }

    @Override
    public CanvasUtils.CommandType getCommandType() {
        return R;
    }


}
