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

import java.util.Scanner;

/**
 * {@link CommandVisitor} implementation  for interpreting commands into actions.
 *
 * @author Alexander Aleksandrov
 */
public class BrainFuckInterpreterVisitor implements CommandVisitor {

    private final Memory memory = new Memory(1000);

    /**
     * Gets the memory array.
     *
     * @return Memory object
     */
    public Memory getMemory() {
        return memory;
    }

    /**
     * States the logic when visitor is  called by {@link CellDecrement} object.
     *
     * @param cellDecrement CellDecrement command object
     */
    @Override
    public void visit(CellDecrement cellDecrement) {
        int currentValue = memory.getCurrentCellValue();
        memory.setCurrentCellValue(--currentValue);
    }

    /**
     * States the logic when visitor is  called by {@link CellIncrement} object.
     *
     * @param cellIncrement CellIncrement command object
     */
    @Override
    public void visit(CellIncrement cellIncrement) {
        int currentValue = memory.getCurrentCellValue();
        memory.setCurrentCellValue(++currentValue);
    }

    /**
     * States the logic when visitor is  called by {@link Cycle} object.
     *
     * @param cycle Cycle command object
     */
    @Override
    public void visit(Cycle cycle) {
        while (memory.getCurrentCellValue() > 0) {
            for (Command command : cycle.getInnerCycleCommands()) {
                command.accept(this);
            }
        }
    }

    /**
     * States the logic when visitor is  called by {@link InputCell} object.
     *
     * @param inputCell InputCell command object
     */
    @Override
    public void visit(CommandImpl inputCell) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int value = keyboard.nextInt();
        memory.setCurrentCellValue(value);
    }

    /**
     * States the logic when visitor is  called by {@link NextCell} object.
     *
     * @param nextCell NextCell command object
     */
    @Override
    public void visit(NextCell nextCell) {
        final int pointer = memory.getPointer();
        memory.setPointer(pointer + 1);
    }

    /**
     * States the logic when visitor is  called by {@link PreviousCell} object.
     *
     * @param previousCell PreviousCell command object
     */
    @Override
    public void visit(PreviousCell previousCell) {
        final int pointer = memory.getPointer();
        memory.setPointer(pointer - 1);
    }

    /**
     * States the logic when visitor is  called by {@link PrintCell} object.
     *
     * @param printCell PrintCell command object
     */
    @Override
    public void visit(PrintCell printCell) {
        int currentValue = memory.getCurrentCellValue();
        char compiledChar = (char) currentValue;
        System.out.print(compiledChar);
    }
}
