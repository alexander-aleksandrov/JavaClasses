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
package com.teamdev.javaclasses.aleksandrov.brainfuck.compiler;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.AbstractCommand;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Commands;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.Cycle;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.InputCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.NextCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.PreviousCell;
import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.PrintCell;

/**
 * This interface defines types of acceptor classes that the visitor can work with.
 *
 * @author Alexander Aleksandrov
 */
public interface CommandVisitor {

    /**
     * {@inheritDoc}
     */
    void visit(Commands.CellIncrement cellIncrement);

    /**
     * {@inheritDoc}
     */
    void visit(Commands.CellDecrement cellDecrement);

    /**
     * {@inheritDoc}
     */
    void visit(InputCell inputCell);

    /**
     * {@inheritDoc}
     */
    void visit(PrintCell printCell);

    /**
     * {@inheritDoc}
     */
    void visit(NextCell nextCell);

    /**
     * {@inheritDoc}
     */
    void visit(PreviousCell previousCell);

    /**
     * {@inheritDoc}
     */
    void visit(Cycle cycle);

    void visit(AbstractCommand command);

}
