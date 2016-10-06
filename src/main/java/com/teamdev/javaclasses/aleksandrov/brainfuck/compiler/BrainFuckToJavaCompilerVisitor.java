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

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.FilePrinterImpl;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.Printer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BrainFuckToJavaCompilerVisitor implements CommandVisitor {
    private final File output = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/Draft.txt");
    private final Printer printer = new FilePrinterImpl(output);


    @Override
    public void visit(CellDecrement cellDecrement) {
        List<String> text = new ArrayList<>();
        text.add("memory[pointer]--;");
        printer.printToFile(text);
    }

    @Override
    public void visit(CellIncrement cellIncrement) {
        List<String> text = new ArrayList<>();
        text.add("memory[pointer]++;");
        printer.printToFile(text);
    }

    @Override
    public void visit(InputCell inputCell) {
        System.out.println("input cell");
    }

    @Override
    public void visit(NextCell nextCell) {
        List<String> text = new ArrayList<>();
        text.add("pointer++;");
        printer.printToFile(text);
    }

    @Override
    public void visit(PreviouseCell previouseCell) {
        List<String> text = new ArrayList<>();
        text.add("pointer--;");
        printer.printToFile(text);
    }

    @Override
    public void visit(PrintCell printCell) {
        List<String> text = new ArrayList<>();
        text.add("compiledChar = (char) memory[pointer];");
        text.add("System.out.print(compiledChar);");
        printer.printToFile(text);
    }

    @Override
    public void visit(Cycle cycle) {
        List<String> text = new ArrayList<>();
        text.add("while(memory[pointer] > 0) {");
        printer.printToFile(text);

        for (Command command: cycle.getInnerCycleCommands()){
            command.accept(this);
        }

        text.clear();
        text.add("}");
        printer.printToFile(text);
    }

}
