package com.teamdev.javaclasses.aleksandrov.brainfuck.compiler;

import com.teamdev.javaclasses.aleksandrov.brainfuck.comand.*;

public interface CommandVisitor {

    void visit(CellIncrement cellIncrement);

    void visit(CellDecrement cellDecrement);

    void visit(InputCell inputCell);

    void visit(PrintCell printCell);

    void visit(NextCell nextCell);

    void visit(PreviouseCell previouseCell);

    void visit(Cycle cycle);

}
