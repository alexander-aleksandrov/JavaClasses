package com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine;

public interface StateRecognizer<
        InputContext, OutputContext, State extends Enum> {

    boolean accept(InputContext inputContext, OutputContext outputContext, State possibleState);
}
