/*
 * Copyright 2016, TeamDev Ltd. All rights reserved.
 *
 * Redistribution and use in source and/or binary forms, with or without
 * modification, must retain the above copyright notice and the following
 * disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.teamdev.javaclasses.aleksandrov.brainfuck.parser;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.CellDecrement;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.CellIncrement;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Command;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Cycle;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.InputCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.NextCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.PreviousCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.PrintCell;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Parser of Brain Fuck source code to command list.
 *
 * @author Alexander Aleksandrov
 */
public class InterpreterParser {

    /**
     * Goes through a string of Brain fuck code and creates a commands for each char.
     *
     * @param codeString String with text in Brain Fuck format
     * @return List of Command objects
     */
    public List<Command> parse(String codeString) {

        final Stack<List<Command>> stack = new Stack<List<Command>>();
        List<Command> newList = new ArrayList<Command>();
        stack.push(newList);

        for (Character commandIdentifier : codeString.toCharArray()) {
            createCommand(commandIdentifier, stack);
        }
        return stack.pop();
    }

    /*Puts a Command object to stack according to specific char.*/
    private void createCommand(char commandIdentifier, Stack<List<Command>> stackOfCommands) {
        switch (commandIdentifier) {
            case '+':
                stackOfCommands.peek().add(new CellIncrement());
                break;
            case '-':
                stackOfCommands.peek().add(new CellDecrement());
                break;
            case '<':
                stackOfCommands.peek().add(new PreviousCell());
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
