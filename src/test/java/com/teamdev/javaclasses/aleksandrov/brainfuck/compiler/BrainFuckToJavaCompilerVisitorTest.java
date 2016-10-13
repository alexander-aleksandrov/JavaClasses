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

    private final File output = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/Draft.txt");


    @Test
    public void testCellDecrementVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final CellDecrement command = new CellDecrement();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in  = new Scanner(new FileReader(output));
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
        Scanner in  = new Scanner(new FileReader(output));
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
        Scanner in  = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of NextCell command.",
                "pointer++;", actual);
    }

    @Test
    public void testPreviouseCellVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final PreviouseCell command = new PreviouseCell();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in  = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals("Incorrect processing of PreviouseCell command.",
                "pointer--;", actual);
    }

    @Test
    public void testPrintCellVisit() throws Exception {
        final BrainFuckToJavaCompilerVisitor visitor = new BrainFuckToJavaCompilerVisitor();
        final PrintCell command = new PrintCell();
        TestUtil.clearDraft(output);
        visitor.visit(command);
        Scanner in  = new Scanner(new FileReader(output));
        String actual = in.nextLine()+ in.nextLine();
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
        Scanner in  = new Scanner(new FileReader(output));
        String actual = in.nextLine() + in.nextLine() + in.nextLine();
        assertEquals("Incorrect processing of Cycle command.",
                "while(memory[pointer] > 0) {memory[pointer]++;}", actual);
    }



}
