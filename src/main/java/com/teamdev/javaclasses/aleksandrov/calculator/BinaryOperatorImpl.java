package com.teamdev.javaclasses.aleksandrov.calculator;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorImpl implements BinaryOperator<BinaryOperatorImpl> {

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private final static Logger LOG = Logger.getLogger(BinaryOperatorImpl.class.getName());
    private final String script;
    private final Priority priority;

    public BinaryOperatorImpl(String script, Priority priority) {
        this.script = script;
        this.priority = priority;
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {

        Binding binding = new Binding();
        binding.setVariable("leftOperand", leftOperand);
        binding.setVariable("rightOperand", rightOperand);
        GroovyShell shell = new GroovyShell(binding);
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Made a calculation");
        }
        return (Double) shell.evaluate(script);
    }

    @Override
    public int compareTo(BinaryOperatorImpl o) {

        return priority.compareTo(o.priority);
    }
}
