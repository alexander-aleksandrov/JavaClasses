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
package com.teamdev.javaclasses.aleksandrov.brainfuck.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;

public class FileReaderImpTest {
    private final File program = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/FileReaderImpTest.txt");
    final private String expected = "+++<><+++";

    @Before
    public void testReadPreconditions() {
        try {
            if (!program.exists()) {
                program.createNewFile();
                try {
                    Files.write(Paths.get("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/FileReaderImpTest.txt"),
                            expected.getBytes(), StandardOpenOption.APPEND);
                    System.out.println();
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
        }
    }

    @Test
    public void testRead() throws Exception {
        final FileReaderImp fileReader = new FileReaderImp();
        final String actual = fileReader.read(program);
        assertEquals(actual, expected);


    }

}
