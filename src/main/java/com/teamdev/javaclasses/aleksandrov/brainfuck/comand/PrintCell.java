package com.teamdev.javaclasses.aleksandrov.brainfuck.comand;

import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.CommandVisitor;

public class PrintCell implements Command{

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
