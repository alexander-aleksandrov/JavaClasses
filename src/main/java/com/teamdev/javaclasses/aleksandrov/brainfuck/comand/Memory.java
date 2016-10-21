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
package com.teamdev.javaclasses.aleksandrov.brainfuck.comand;

/**
 * A model of memory made of indexed cells that is used for execution of BrainFuck commands and storing results.
 *
 * @author Alexander Aleksandrov
 */
public class Memory {

    private final int[] cells;
    private int pointer = 0;

    /**
     * Creates a Memory object of desired size.
     *
     * @param memorySize Desired number of cells
     */
    public Memory(int memorySize) {
        cells = new int[memorySize];
    }

    /**
     * Stores a value into a currently active cell specified by pointer.
     *
     * @param value Value
     */
    public void setCellValue(int value) {
        cells[pointer] = value;
    }

    /**
     * Sets a new position of cell pointer.
     *
     * @param pointer An index number of the cell
     */
    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    /**
     * Gets a current pointer position.
     *
     * @return Value stored in pointer
     */
    public int getPointer() {
        return pointer;
    }

    /**
     * Gets the current value stored in a cell specified by pointer.
     *
     * @return The value stored in the specified cell
     */
    public int getCellValue() {
        return cells[pointer];
    }
}
