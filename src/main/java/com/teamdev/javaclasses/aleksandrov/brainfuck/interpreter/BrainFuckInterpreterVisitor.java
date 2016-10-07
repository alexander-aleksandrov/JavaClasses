/*
 * Copyright 2016, TeamDev Ltd. All rights reserved.
 *
 * Redistribution and use in source and/or binary forms, with or without
 * modification, must retain the above copyright notice and the following
 * disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.CommandVisitor;

public class BrainFuckInterpreterVisitor implements CommandVisitor {

    private final Memory memory = new Memory(1000);

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
    public void visit(PreviousCell previousCell) {
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
