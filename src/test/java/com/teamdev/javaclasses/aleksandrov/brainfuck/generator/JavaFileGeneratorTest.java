package com.teamdev.javaclasses.aleksandrov.brainfuck.generator;

import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;


public class JavaFileGeneratorTest {
    final private File output = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/JavaFileGeneratorTest.txt");
    final private File source = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/JavaBrainFuckTemplate.txt");


    @Test
    public void testGenerateTemplate() throws Exception {

        final JavaFileGenerator generator = new JavaFileGenerator();

        File actualFile = generator.generateTemplate(output);

        Scanner in = new Scanner(new FileReader(actualFile));
        String actual = in.next();

        Scanner in2 = new Scanner(new FileReader(source));
        String expected = in2.next();

        assertEquals(actual, expected);
    }

}
