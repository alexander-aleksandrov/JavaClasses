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
