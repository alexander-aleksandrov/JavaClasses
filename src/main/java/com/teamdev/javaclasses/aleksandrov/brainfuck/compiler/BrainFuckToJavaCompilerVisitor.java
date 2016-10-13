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
