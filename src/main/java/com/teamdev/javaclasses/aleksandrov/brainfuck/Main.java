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
package com.teamdev.javaclasses.aleksandrov.brainfuck;

import com.teamdev.javaclasses.aleksandrov.brainfuck.compiler.BrainFuckToJavaCompiler;
import com.teamdev.javaclasses.aleksandrov.brainfuck.interpreter.BrainFuckInterpreter;

import java.io.File;

/**
 * Start point of Brain Fuck  interpreter.
 *
 * @author Alexander Aleksandrov
 */
public class Main {
    private static final File output = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/BrainFuckRunner.java");
    private static final File program = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/HelloWorld.txt");

    public static void main(String[] args) {
        BrainFuckInterpreter interpreter = new BrainFuckInterpreter();
        interpreter.execute(program);
        BrainFuckToJavaCompiler compiler = new BrainFuckToJavaCompiler();
        compiler.execute(program, output);
    }
}
