package com.teamdev.javaclasses.aleksandrov.brainfuck.compiler;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Command;
import com.teamdev.javaclasses.aleksandrov.brainfuck.generator.Generator;
import com.teamdev.javaclasses.aleksandrov.brainfuck.generator.JavaFileGenerator;
import com.teamdev.javaclasses.aleksandrov.brainfuck.generator.JavaFileInserter;
import com.teamdev.javaclasses.aleksandrov.brainfuck.parser.InterpreterParser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.parser.Parser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.reader.FileReaderImp;
import com.teamdev.javaclasses.aleksandrov.brainfuck.reader.Reader;

import java.io.File;
import java.util.List;

public class BrainFuckToJavaCompilerImpl implements BrainFuckToJavaCompiler {

    @Override
    public void execute(final File program, final File output) {
        final Reader reader = new FileReaderImp();
        final Parser parser = new InterpreterParser();
        final Generator generator = new JavaFileGenerator();
        final JavaFileInserter javaFile = new JavaFileInserter();
        final String programText;

        programText = reader.read(program);
        generator.generateTemplate(output);


        System.out.println("Program text: ");
        System.out.println(programText);
        System.out.println("Result: ");

        final List<Command> commands = parser.parse(programText);

        final BrainFuckToJavaCompilerVisitor visitor =
                new BrainFuckToJavaCompilerVisitor();

        for (Command command : commands) {
            command.accept(visitor);
        }

        javaFile.generateJavaFile();

    }
}
