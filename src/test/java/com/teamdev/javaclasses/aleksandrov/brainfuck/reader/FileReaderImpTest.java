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
    private final File program = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/FileReaderImpTest.txt");
    final private String expected = "+++<><+++";

    @Before
    public void testReadPreconditions(){
        try {
            if (!program.exists()) {
                program.createNewFile();
                try {
                    Files.write(Paths.get("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/FileReaderImpTest.txt"),
                            expected.getBytes(), StandardOpenOption.APPEND);
                    System.out.println();
                }catch (IOException e) {}
            }
        }catch (IOException e){}
    }

    @Test
    public void testRead() throws Exception {
        final FileReaderImp fileReader = new FileReaderImp();
        final String actual = fileReader.read(program);
        assertEquals(actual, expected);


    }

}
