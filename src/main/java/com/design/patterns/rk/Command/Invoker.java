package com.design.patterns.rk.Command;

/**
 * Created by renkai on 2017/3/22.
 */
public class Invoker {
    private Command command;



    public Command getCommand() {
        return command;
    }

    public Invoker setCommand(Command command) {
        this.command = command;
        return this;
    }

    public Invoker(Command command) {
        this.command = command;
    }
    void action(){
        command.exe();
    }
}
