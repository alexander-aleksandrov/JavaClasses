package com.teamdev.javaclasses.aleksandrov.brainfuck.parser;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InterpreterParserTest {

    @Test
    public void testParseCellIncrement() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse("+");
        assertTrue("Should be CellIncrenment object", actual.get(0) instanceof CellIncrement);
    }
    @Test
    public void testParseCellDecrement() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse("-");
        assertTrue("Should be CellDecrement object", actual.get(0) instanceof CellDecrement);
    }
    @Test
    public void testParseNextCell() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse(">");
        assertTrue("Should be NextCell object", actual.get(0) instanceof NextCell);
    }
    @Test
    public void testParsePreviouseCell() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse("<");
        assertTrue("Should be PreviouseCell object", actual.get(0) instanceof PreviouseCell);
    }
    @Test
    public void testParsePrintCell() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse(".");
        assertTrue("Should be PrintCell object", actual.get(0) instanceof PrintCell);
    }
    @Test
    public void testParseInputCell() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse(",");
        assertTrue("Should be InputCell object", actual.get(0) instanceof InputCell);
    }
    @Test
    public void testParseCycle() throws Exception {
        final Parser parser = new InterpreterParser();
        final List<Command> actual = parser.parse("[]");
        assertNotNull("Should be Cycle object", actual.get(0));
    }


}
