package com.design.command;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:22
 * @Description 命令调用者类
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void undoCommand() {
        command.undo();
    }
}
