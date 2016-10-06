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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.javaclasses.aleksandrov.calculator.BinaryOperatorImpl.Priority.LOW;
import static com.teamdev.javaclasses.aleksandrov.calculator.BinaryOperatorImpl.Priority.MEDIUM;

public class BinaryOperatorRepositoryInMemo implements BinaryOperatorRepository {

    private final static Logger LOG = LoggerFactory.getLogger(BinaryOperatorRepositoryInMemo.class);

    private final Map<String, BinaryOperator> repository = new HashMap<String, BinaryOperator>() {{
        put("+", new BinaryOperatorImpl("leftOperand + rightOperand", LOW));
        put("-", new BinaryOperatorImpl("leftOperand - rightOperand", LOW));
        put("*", new BinaryOperatorImpl("leftOperand * rightOperand", MEDIUM));
        put("/", new BinaryOperatorImpl("leftOperand / rightOperand", MEDIUM));
    }};


    @Override
    public Set<String> getRepresentations() {
        return repository.keySet();
    }

    @Override
    public BinaryOperator getBinaryOperator(String representation) {

        if (LOG.isInfoEnabled()) {
            LOG.info("Someone requesting operator: " + representation);
        }

        return repository.get(representation);
    }
}
