package com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Command;
import com.teamdev.javaclasses.aleksandrov.brainfuck.parser.InterpreterParser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.parser.Parser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.reader.FileReaderImp;
import com.teamdev.javaclasses.aleksandrov.brainfuck.reader.Reader;

import java.io.File;
import java.util.List;

public class BrainFuckInterpreterImpl implements BrainFuckInterpreter {

    private String result;

    public void execute(final File program) {
        final Reader reader = new FileReaderImp();
        final Parser parser = new InterpreterParser();
        final String programText = reader.read(program);

        System.out.println("Program text: ");
        System.out.println(programText);
        System.out.println("Result: ");

        final List<Command> commands = parser.parse(programText);

        final BrainFuckInterpreterVisitor visitor = new BrainFuckInterpreterVisitor();

        for (Command command : commands) {
            command.accept(visitor);
        }

    }
}






