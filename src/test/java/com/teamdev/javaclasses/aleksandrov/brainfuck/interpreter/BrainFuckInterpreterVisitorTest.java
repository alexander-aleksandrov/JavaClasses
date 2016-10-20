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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@DisplayName("Brainfuck interpreter should")
public class BrainFuckInterpreterVisitorTest {

    @Test
    @DisplayName("Decrease cell value on one point")
    public void testCellDecrementVisit() throws Exception {
        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final CellDecrement command = new CellDecrement();
        final Memory memory = visitor.getMemory();
        memory.setCurrentCellValue(10);
        visitor.visit(command);
        assertEquals("Incorrect processing of CellDecrement command.",
                9, memory.getCurrentCellValue());
    }

    @Test
    @DisplayName("Increase cell value on one point")
    public void testCellIncrementVisit() throws Exception {
        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final CellIncrement command = new CellIncrement();
        final Memory memory = visitor.getMemory();
        memory.setCurrentCellValue(10);
        visitor.visit(command);
        assertEquals("Incorrect processing of CellIncrement command.",
                11, memory.getCurrentCellValue());
    }

    @Test
    @DisplayName("Change pointer position on next cell value.")
    public void testNextCellVisit() throws Exception {
        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final NextCell command = new NextCell();
        final Memory memory = visitor.getMemory();
        memory.setPointer(10);
        visitor.visit(command);
        assertEquals("Incorrect processing of NextCell command.",
                11, memory.getPointer());
    }

    @Test
    @DisplayName("Change pointer position on previous cell value")
    public void testPreviousCellVisit() throws Exception {
        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final PreviousCell command = new PreviousCell();
        final Memory memory = visitor.getMemory();
        memory.setPointer(10);
        visitor.visit(command);
        assertEquals("Incorrect processing of PreviousCell command.",
                9, memory.getPointer());
    }

    @Test
    @DisplayName("Print cell value to console.")
    public void testPrintCellVisit() throws Exception {
        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final PrintCell command = new PrintCell();
        final Memory memory = visitor.getMemory();
        memory.setCurrentCellValue(108);
        visitor.visit(command);
        assertEquals("Incorrect processing of PrintCell command.",
                108, memory.getCurrentCellValue());
    }
}
