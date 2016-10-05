package com.teamdev.javaclasses.aleksandrov.brainfuck.generator;

import java.io.*;

public class JavaFileInserter {

    private final File source = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/Draft.txt");
    private final File output = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/BrainFuckRunner.java");

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

    public String getString(final File file) {
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

