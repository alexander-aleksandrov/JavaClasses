package com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.CommandVisitor;

public class BrainFuckInterpreterVisitor implements CommandVisitor {

    final private Memory memory = new Memory(1000);

    public Memory getMemory() {
        return memory;
    }

    @Override
    public void visit(CellDecrement cellDecrement) {
        int currentValue = memory.getCurrentCellValue();
        memory.setCurrentCellValue(--currentValue);

    }

    @Override
    public void visit(CellIncrement cellIncrement) {
        int currentValue = memory.getCurrentCellValue();
        memory.setCurrentCellValue(++currentValue);

    }

    @Override
    public void visit(Cycle cycle) {
        while (memory.getCurrentCellValue() > 0) {
            for (Command command : cycle.getInnerCycleCommands()) {
                command.accept(this);
            }
        }
    }

    @Override
    public void visit(InputCell inputCell) {

    }

    @Override
    public void visit(NextCell nextCell) {
        final int pointer = memory.getPointer();
        memory.setPointer(pointer + 1);

    }

    @Override
    public void visit(PreviouseCell previouseCell) {
        final int pointer = memory.getPointer();
        memory.setPointer(pointer - 1);
    }

    @Override
    public void visit(PrintCell printCell) {
        int currentValue = memory.getCurrentCellValue();
        char compiledChar = (char) currentValue;
        System.out.print(compiledChar);
    }
}
