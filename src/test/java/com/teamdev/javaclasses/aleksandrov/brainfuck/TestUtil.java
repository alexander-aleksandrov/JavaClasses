package com.teamdev.javaclasses.aleksandrov.brainfuck;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtil {

    public static void clearDraft(final File output){
        try (FileWriter writer = new FileWriter(output)) {
            writer.write("");
            writer.close();
        } catch (IOException e) {}


    }

}
