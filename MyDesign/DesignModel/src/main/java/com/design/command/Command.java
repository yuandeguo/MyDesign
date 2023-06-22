package com.design.command;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:23
 * @Description null
 */
public interface Command {
    void execute();
    void undo();
}
