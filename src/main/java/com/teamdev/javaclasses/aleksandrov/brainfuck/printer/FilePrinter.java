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
package com.teamdev.javaclasses.aleksandrov.brainfuck.printer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Printer implementation that takes  a file on constructor and prints a text inside it.
 *
 * @author Alexander Aleksandrov
 */
public class FilePrinter implements AutoCloseable, Printer {

    final File output;

    /**
     * Constructor that gets some file as a parameter.
     *
     * @param output File object
     */
    public FilePrinter(File output) {
        this.output = output;
    }

    /**
     * Writes a list of strings into this FilePrinter.
     *
     * @param text List of Strings
     */
    public void printToFile(List<String> text) {
        int i = 0;
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output, true)))) {
            while (i < text.size()) {
                writer.println(text.get(i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a {@code String} into this FilePrinter.
     *
     * @param text Text
     */
    public void printLine(String text) {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output, true)))) {
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {}
}

