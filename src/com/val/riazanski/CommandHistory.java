package com.val.riazanski;

import java.util.Stack;

public class CommandHistory {
    //fields
    private final Stack<Command> history;
    //constructors
    public CommandHistory() {
        this.history = new Stack<>();
    }
    //methods
    public void push(Command command) {
        this.history.push(command);
    }
    public Command pop() {
        return history.pop();
    }
    public int stackSize() {
        return this.history.size();
    }
}
