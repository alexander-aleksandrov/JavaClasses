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
        assertTrue("Should be PreviousCell object", actual.get(0) instanceof PreviousCell);
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
