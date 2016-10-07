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
package com.teamdev.javaclasses.aleksandrov.brainfuck.compiler;

import com.teamdev.javaclasses.aleksandrov.brainfuck.TestUtil;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BrainFuckToJavaCompilerVisitorTest {

    private final File output = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/Draft.txt");

    @Test
    public void testCellDecrementVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final CellDecrement command = new CellDecrement();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of CellDecrement command.",
                "memory[pointer]--;", actual);
    }

    @Test
    public void testCellIncrementVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final CellIncrement command = new CellIncrement();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of CellIncrement command.",
                "memory[pointer]++;", actual);
    }

    @Test
    public void testNextCellVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final NextCell command = new NextCell();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of NextCell command.",
                "pointer++;", actual);
    }

    @Test
    public void testPreviouseCellVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final PreviousCell command = new PreviousCell();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of PreviousCell command.",
                "pointer--;", actual);
    }

    @Test
    public void testPrintCellVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final PrintCell command = new PrintCell();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.nextLine() + in.nextLine();
        assertEquals("Incorrect processing of PrintCell command.",
                "compiledChar = (char) memory[pointer];System.out.print(compiledChar);", actual);
    }

    @Test
    public void testCycleVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        List<Command> cycle = new ArrayList<>();
        cycle.add(new CellIncrement());
        final Cycle command = new Cycle(cycle);
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.nextLine() + in.nextLine() + in.nextLine();
        assertEquals("Incorrect processing of Cycle command.",
                "while(memory[pointer] > 0) {memory[pointer]++;}", actual);
    }


}
