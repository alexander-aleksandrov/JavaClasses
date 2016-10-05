package com.teamdev.javaclasses.aleksandrov.brainfuck.parser;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;

import java.util.*;

public class InterpreterParser implements Parser {

    @Override
    public List <Command> parse(String codeString){

        final Deque<List<Command>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<Command>());

        for (Character commandIdentifier: codeString.toCharArray()) {
            createCommand(commandIdentifier, stack);
        }
        return stack.pop();
    }

    private void createCommand(char commandIdentifier, Deque<List<Command>> stackOfCommands) {
        switch (commandIdentifier) {
            case '+':
                stackOfCommands.peek().add(new CellIncrement());
                break;
            case '-':
                stackOfCommands.peek().add(new CellDecrement());
                break;
            case '<':
                stackOfCommands.peek().add(new PreviouseCell());
                break;
            case '>':
                stackOfCommands.peek().add(new NextCell());
                break;
            case '.':
                stackOfCommands.peek().add(new PrintCell());
                break;
            case ',':
                stackOfCommands.peek().add(new InputCell());
                break;
            case '[':
                stackOfCommands.push(new ArrayList<Command>());
                break;
            case ']':
                final List<Command> commands = stackOfCommands.pop();
                stackOfCommands.peek().add(new Cycle(commands));
                break;
            default:
                throw new IllegalStateException("Unknown command identifier: " + commandIdentifier);

        }
    }


}
