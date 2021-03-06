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

import com.teamdev.javaclasses.aleksandrov.brainfuck.generator.TempFiles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("File Printer should")
public class FilePrinterTest {

    private File output;

    @BeforeEach
    public void precondition() {
        final boolean tempFileExists = TempFiles.isCreated();
        if (tempFileExists) {
            output = TempFiles.getDraft();
        } else {
            TempFiles.createTempFile("draft-file1");
            output = TempFiles.getDraft();
        }
    }

    @Test
    @DisplayName("print specified text to file")
    public void testPrintToFile() throws FileNotFoundException {
        final String expected = "compiledChar";
        final Printer filePrinter = new FilePrinter(output);
        List<String> text = new ArrayList<>();
        text.add(expected);
        filePrinter.printToFile(text);
        Scanner in = new Scanner(new FileReader(output));
        String actual = in.next();
        assertEquals(actual, expected);
    }
}
