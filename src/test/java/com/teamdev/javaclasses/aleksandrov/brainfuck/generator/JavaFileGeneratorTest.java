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

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class JavaFileGeneratorTest {
    private final File output = new File("C:/Projects/JavaClasses/src/main/resources/files/JavaFileGeneratorTest.txt");
    private final File source = new File("C:/Projects/JavaClasses/src/main/resources/files/JavaBrainFuckTemplate.txt");

    @Test
    public void testGenerateTemplate() throws FileNotFoundException {

        final JavaFileGenerator generator = new JavaFileGenerator();
        File actualFile = generator.generateTemplate(output);
        Scanner in = new Scanner(new FileReader(actualFile));
        String actual = in.next();
        Scanner in2 = new Scanner(new FileReader(source));
        String expected = in2.next();
        assertEquals(actual, expected);
    }

}
