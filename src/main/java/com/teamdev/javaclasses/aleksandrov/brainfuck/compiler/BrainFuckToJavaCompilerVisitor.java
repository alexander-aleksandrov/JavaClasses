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

import com.google.common.collect.Lists;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import com.teamdev.javaclasses.aleksandrov.brainfuck.generator.TempFiles;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.FilePrinter;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.Printer;

import java.io.File;
import java.util.List;

/**
 * {@link CommandVisitor} implementation for compilation BrainFuck commands into Java code.
 *
 * @author Alexander Aleksandrov
 */
public class BrainFuckToJavaCompilerVisitor implements CommandVisitor {

    private final File output = TempFiles.getDraft();
    private final Printer printer = new FilePrinter(output);

    /**
     * States exact string that should be added to the java file when visitor visits {@link CellDecrement} command.
     *
     * @param cellDecrement CellDecrement command object
     */
    @Override
    public void visit(CellDecrement cellDecrement) {
        List<String> text = Lists.newArrayList();
        text.add("memory[pointer]--;");
        printer.printToFile(text);
    }

    /**
     * States exact string that should be added to the java file when visitor visits {@link CellIncrement} command.
     *
     * @param cellIncrement CellIncrement command object
     */
    @Override
    public void visit(CellIncrement cellIncrement) {
        List<String> text = Lists.newArrayList();
        text.add("memory[pointer]++;");
        printer.printToFile(text);
    }

    /**
     * States exact string that should be added to the java file when visitor visits {@link InputCell} command.
     *
     * @param inputCell InputCell command object
     */
    @Override
    public void visit(InputCell inputCell) {
        List<String> text = Lists.newArrayList();
        text.add("Scanner keyboard = new Scanner(System.in);");
        text.add("System.out.println(\"Please enter an integer:\");");
        text.add("int value = keyboard.nextInt();");
        text.add("memory[pointer] = value;");
        printer.printToFile(text);
    }

    /**
     * States exact string that should be added to the java file when visitor visits {@link NextCell} command.
     *
     * @param nextCell NextCell command object
     */
    @Override
    public void visit(NextCell nextCell) {
        List<String> text = Lists.newArrayList();
        text.add("pointer++;");
        printer.printToFile(text);
    }

    /**
     * States exact string that should be added to the java file when visitor visits {@link PreviousCell} command.
     *
     * @param previousCell PreviousCell command object
     */
    @Override
    public void visit(PreviousCell previousCell) {
        List<String> text = Lists.newArrayList();
        text.add("pointer--;");
        printer.printToFile(text);
    }

    /**
     * States exact text that should be added to the java file when visitor visits {@link PrintCell} command.
     *
     * @param printCell PrintCell command object
     */
    @Override
    public void visit(PrintCell printCell) {
        List<String> text = Lists.newArrayList();
        text.add("compiledChar = (char) memory[pointer];");
        text.add("System.out.print(compiledChar);");
        printer.printToFile(text);
    }

    /**
     * States exact string that should be added to the java file when visitor visits {@link Cycle} command.
     *
     * @param cycle Cycle command object
     */
    @Override
    public void visit(Cycle cycle) {
        List<String> text = Lists.newArrayList();
        text.add("while(memory[pointer] > 0) {");
        printer.printToFile(text);

        for (Command command : cycle.getInnerCycleCommands()) {
            command.accept(this);
        }

        text.clear();
        text.add("}");
        printer.printToFile(text);
    }

}
