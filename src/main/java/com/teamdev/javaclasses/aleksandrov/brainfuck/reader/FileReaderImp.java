package com.teamdev.javaclasses.aleksandrov.brainfuck.reader;
import java.io.*;
import java.util.Scanner;

public class FileReaderImp implements Reader {

    @Override
    public String read(File file) {
        try {
            Scanner in  = new Scanner(new FileReader(file));
            return in.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
    }


