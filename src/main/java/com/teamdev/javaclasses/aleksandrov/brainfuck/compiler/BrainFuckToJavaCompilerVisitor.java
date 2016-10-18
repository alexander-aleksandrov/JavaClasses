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
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.FilePrinter;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.Printer;

import java.io.File;
import java.util.List;

/**
 * Prints to file a text that means BrainFuck commands declared on Java.
 *
 * @author Alexander Aleksandrov
 */
public class BrainFuckToJavaCompilerVisitor implements CommandVisitor {
    private final File output = new File("C:/Projects/JavaClasses/src/main/resources/files/Draft.txt");

    private final Printer printer = new FilePrinter(output);

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(Commands.CellDecrement cellDecrement) {
        printer.printLine("memory[pointer]--;");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(Commands.CellIncrement cellIncrement) {
        printer.printLine("memory[pointer]++;");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(InputCell inputCell) {
        final List<String> text = Lists.newArrayList();
        text.add("Scanner keyboard = new Scanner(System.in);");
        text.add("System.out.println(\"Please enter an integer:\");");
        text.add("int value = keyboard.nextInt();");
        text.add("memory[pointer] = value;");
        printer.printToFile(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(NextCell nextCell) {
        printer.printLine("pointer++;");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(PreviousCell previousCell) {
        printer.printLine("pointer--;");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(PrintCell printCell) {
        final List<String> text = Lists.newArrayList();
        text.add("compiledChar = (char) memory[pointer];");
        text.add("System.out.print(compiledChar);");
        printer.printToFile(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(Cycle cycle) {
        final List<String> text = Lists.newArrayList();
        text.add("while(memory[pointer] > 0) {");
        printer.printToFile(text);
        for (Command command : cycle.getInnerCycleCommands()) {
            command.accept(this);
        }
        text.clear();
        text.add("}");
        printer.printToFile(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(AbstractCommand command) {

    }
}
