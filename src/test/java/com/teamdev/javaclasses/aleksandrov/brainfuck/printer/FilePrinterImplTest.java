package com.teamdev.javaclasses.aleksandrov.brainfuck.printer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
public class FilePrinterImplTest {
    private final File output = new File ("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/FilePrinterImplTest.txt");

    @Before
    public void testReadPreconditions(){
        try {
            if (!output.exists()) {
                output.createNewFile();
                            }
        }catch (IOException e){}
    }


    @Test
    public void testPrintToFile() throws Exception {
        final String expected  = "testString";
        final FilePrinterImpl filePrinter = new FilePrinterImpl(output);
        List<String> text = new ArrayList<>();
        text.add(expected);
        filePrinter.printToFile(text);
        Scanner in  = new Scanner(new FileReader(output));
        String actual = in.next();

        assertEquals(actual, expected);
    }

    @Test
    public void clearFile() throws Exception {

    }

 }
