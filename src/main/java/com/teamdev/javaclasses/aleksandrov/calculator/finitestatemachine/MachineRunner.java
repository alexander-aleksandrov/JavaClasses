package com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


abstract public class MachineRunner<
        Result,
        State extends Enum,
        InputContext,
        OutputContext,
        Recognizer extends StateRecognizer<InputContext, OutputContext, State>,
        Matrix extends TransitionMatrix<State>> {

    final private Matrix matrix;
    final private Recognizer recognizer;

    private final static Logger LOG = Logger.getLogger(MachineRunner.class.getName());


    public MachineRunner(Matrix matrix, Recognizer recognizer) {
        this.matrix = matrix;
        this.recognizer = recognizer;
    }


    public Result move(InputContext inputContext, OutputContext outputContext) {

        State currentState = matrix.getStartState();

        if (LOG.isLoggable(Level.INFO)){
            LOG.info("Start State is set to: " + currentState);
        }

        while (currentState != matrix.getFinishState()) {

            currentState = acceptNewState(inputContext, outputContext, matrix.getPossibleTransitions(currentState));

            if (LOG.isLoggable(Level.INFO)) {
                LOG.info("Accepted a new state: " + currentState);
            }

            if (currentState == null) {
                deadlock(inputContext);
            }
        }

        return prepareResult(outputContext);
    }

    private State acceptNewState(InputContext inputContext, OutputContext outputContext,
                                 Set<State> possibleTransitions) {

        for (State possibleState : possibleTransitions) {
            if (recognizer.accept(inputContext, outputContext, possibleState)) {

                if (LOG.isLoggable(Level.INFO)) {
                    LOG.info("Trying to accept new state: " + possibleState);
                }

                return possibleState;
            }
        }
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Unable to accept state: " + possibleTransitions);
        }
        return null;
    }

    abstract protected void deadlock(InputContext inputContext);

    abstract protected Result prepareResult(OutputContext outputContext);

}
