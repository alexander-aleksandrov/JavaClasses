package com.teamdev.javaclasses.aleksandrov.brainfuck.parser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Command;

import java.util.List;

public interface Parser {
    List<Command> parse(final String codeText);
}
