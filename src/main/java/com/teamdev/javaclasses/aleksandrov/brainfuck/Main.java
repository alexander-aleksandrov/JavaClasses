package com.teamdev.javaclasses.aleksandrov.brainfuck;

import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.BrainFuckToJavaCompilerImpl;
import com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter.BrainFuckInterpreterImpl;

import java.io.File;

public class Main {
    static private final File output = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/BrainFuckRunner.java");
    static private final File program = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/HelloWorld.txt");

    public static void main(String[] args) {
        BrainFuckInterpreterImpl interpreter = new BrainFuckInterpreterImpl();
        interpreter.execute(program);
        BrainFuckToJavaCompilerImpl compiler = new BrainFuckToJavaCompilerImpl();
        compiler.execute(program, output);
    }
}
