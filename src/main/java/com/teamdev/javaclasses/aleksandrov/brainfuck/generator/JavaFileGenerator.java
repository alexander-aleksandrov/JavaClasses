package com.teamdev.javaclasses.aleksandrov.brainfuck.generator;

import java.io.*;

public class JavaFileGenerator implements Generator {

    private final File templateFile = new File("C:/Projects/BrainFuck1/src/main/java/com/teamdev/javaclasses/files/JavaBrainFuckTemplate.txt");

    @Override
    public File generateTemplate(final File output) {
        try {
            if (!output.exists()) {
                output.createNewFile();
            }
            InputStream in = new FileInputStream(templateFile);
            OutputStream out = new FileOutputStream(output);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
        }
        return output;

    }
}
