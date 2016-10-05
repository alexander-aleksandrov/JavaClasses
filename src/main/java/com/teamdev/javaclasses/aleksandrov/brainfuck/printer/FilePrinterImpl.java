package com.teamdev.javaclasses.aleksandrov.brainfuck.printer;
import java.io.*;
import java.util.List;

public class FilePrinterImpl implements Printer {

    final File output;

    public FilePrinterImpl(final File output) {
        this.output = output;
    }

    public void printToFile(final List<String> text) {
        int i = 0;
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(output, true)));
            while (i < text.size()) {
                writer.println(text.get(i));
                i++;
            }
            writer.close();
        }catch (IOException e) {}

    }
    public void clearFile(final File output){
        try{PrintWriter writer = new PrintWriter(output);
            writer.print("");
            writer.close();}catch (IOException e) {}
    }
}

