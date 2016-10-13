package com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrainFuckInterpreterVisitorTest {

    @Test
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
    public void testPreviouseCellVisit() throws Exception {

        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();
        final PreviouseCell command = new PreviouseCell();
        final Memory memory = visitor.getMemory();
        memory.setPointer(10);
        visitor.visit(command);
        assertEquals("Incorrect processing of PreviouseCell command.",
                9, memory.getPointer());

    }

    @Test
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
