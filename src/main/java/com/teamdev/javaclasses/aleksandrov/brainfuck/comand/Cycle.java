package com.teamdev.javaclasses.aleksandrov.brainfuck.comand;

import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.CommandVisitor;

import java.util.List;

public class Cycle implements Command {

    private final List<Command> innerCycleCommands;

    public Cycle(List<Command> innerCycleCommands) {
        this.innerCycleCommands = innerCycleCommands;
    }

    public List<Command> getInnerCycleCommands() {
        return innerCycleCommands;
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
