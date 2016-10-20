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
package com.teamdev.javaclasses.aleksandrov.brainfuck.generator;

import java.io.*;

/**
 * Allows to insert draft generated code into a specific place in template generated file.
 *
 * @author Alexander Aleksandrov
 */
public class JavaFileInserter {

    private final File source = TempFiles.getDraft();
    private final File output = TempFiles.getJavaFile();

    /**
     * Inserts the source string in a specific position into the output File.
     */
    public void generateJavaFile() {

        final String sourceLine = getString(source);
        final String outputLine = getString(output);

        final String newLine = outputLine.substring(0, 330) + sourceLine + outputLine.substring(330);
        try {
            FileWriter writer = new FileWriter(output);
            writer.write(newLine);
            writer.close();
        } catch (IOException e) {
        }
    }

    /**
     * Transforms all the content from file to single string without spaces or breaking
     *
     * @param file File with text
     * @return String
     */
    private String getString(File file) {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            final StringBuilder stringBuilder = new StringBuilder();
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            } catch (IOException e) {
            }
        } catch (FileNotFoundException e) {
        }
        return "";
    }
}

