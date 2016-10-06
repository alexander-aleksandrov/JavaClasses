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
    public void execute(File program, File output) {
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
