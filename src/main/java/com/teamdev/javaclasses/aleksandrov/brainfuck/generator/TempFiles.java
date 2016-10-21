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

import com.google.common.collect.Lists;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.FilePrinter;
import com.teamdev.javaclasses.aleksandrov.brainfuck.printer.Printer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Temporary files used for compiler purposes.
 *
 * @author Alexander Aleksandrov
 */
public class TempFiles {
    private static File draft;
    private static File brainFuckJavaFile;
    private static boolean exist = false;

    public TempFiles(File draft) {
        this.draft = draft;
    }

    public static TempFiles createTempFile(String fileName) {
        draft = TempFiles.createDraft(fileName);
        brainFuckJavaFile = TempFiles.createBrainFuckJavaFile();
        TempFiles files = new TempFiles(draft);
        exist = true;
        return files;
    }

    private static File createDraft(String fileName) {
        try {
            File draft = File.createTempFile(fileName, ".txt");
            return draft;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static File createBrainFuckJavaFile(){
        try {
            File tempJavaFile = File.createTempFile("brainFuckJavaFile", ".java");
            List<String> text = Lists.newArrayList();
            text.add("package com.teamdev.javaclasses.files;");
            text.add("public class BrainFuckRunner {");
            text.add("    private final int[] memory = new int[3000];");
            text.add("    int i = 0;");
            text.add("    int pointer = 0;");
            text.add("    char compiledChar;");
            text.add("    public static void main(String... args) {");
            text.add("        BrainFuckRunner program = new BrainFuckRunner();");
            text.add("        program.execute();");
            text.add("    }");
            text.add("    public void execute() {");
            text.add("        ${code}");
            text.add("    }");
            text.add("}");
            final Printer printer = new FilePrinter(tempJavaFile);
            printer.printToFile(text);
            return brainFuckJavaFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Obtains a draft file.
     * @return draft file
     */
    public static File getDraft() {
        return draft;
    }
    public static File getJavaFile(){
        return brainFuckJavaFile;
    }

    /**
     * Checks if the instance of a class is created.
     *
     * @return true if instance of this class is already exists
     */
    public static boolean isCreated() {
        if (exist) {
            return true;
        }
        return exist;
    }
}
