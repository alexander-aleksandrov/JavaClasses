package com.teamdev.javaclasses.aleksandrov.brainfuck.compiler;
import java.io.File;

public interface BrainFuckToJavaCompiler {
    void execute (final File program, final File output);
}
