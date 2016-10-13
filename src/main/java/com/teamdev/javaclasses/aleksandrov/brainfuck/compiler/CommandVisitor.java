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

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;

/**
 * This interface defines classes that the visitor can work with.
 *
 * @author Alexander Aleksandrov
 */
public interface CommandVisitor {
    /**
     * Allows to describe actions in specific visitor class for CellIncrement command.
     *
     * @param cellIncrement CellIncrement command object
     */
    void visit(CellIncrement cellIncrement);

    /**
     * Allows to describe actions in specific visitor class for CellDecrement command.
     *
     * @param cellDecrement CellDecrement command object
     */
    void visit(CellDecrement cellDecrement);

    /**
     * Allows to describe actions in specific visitor class for InputCell command.
     *
     * @param inputCell InputCell command object
     */
    void visit(InputCell inputCell);

    /**
     * Allows to describe actions in specific visitor class for PrintCell command.
     *
     * @param printCell PrintCell command object
     */
    void visit(PrintCell printCell);

    /**
     * Allows to describe actions in specific visitor class for NextCell command.
     *
     * @param nextCell NextCell command object
     */
    void visit(NextCell nextCell);

    /**
     * Allows to describe actions in specific visitor class for PreviousCell command.
     *
     * @param previousCell PreviousCell command object
     */
    void visit(PreviousCell previousCell);

    /**
     * Allows to describe actions in specific visitor class for Cycle command.
     *
     * @param cycle Cycle command object
     */
    void visit(Cycle cycle);

}
