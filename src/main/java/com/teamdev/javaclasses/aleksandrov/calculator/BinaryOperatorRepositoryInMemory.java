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

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

import static com.teamdev.javaclasses.aleksandrov.calculator.BinaryOperatorImpl.Priority.PRIORITY_LOW;
import static com.teamdev.javaclasses.aleksandrov.calculator.BinaryOperatorImpl.Priority.PRIORITY_MEDIUM;

/**
 * Implementation of {@link BinaryOperatorRepository} that stores all binary operators in memo.
 *
 * @author Alexander Aleksandrov
 */
public class BinaryOperatorRepositoryInMemory implements BinaryOperatorRepository {

    private static final Logger log = LoggerFactory.getLogger(BinaryOperatorRepositoryInMemory.class);

    private final ImmutableMap<String, BinaryOperator> repo = ImmutableMap.<String, BinaryOperator>builder()
            .put("+", new BinaryOperatorImpl("+", PRIORITY_LOW))
            .put("-", new BinaryOperatorImpl("-", PRIORITY_LOW))
            .put("*", new BinaryOperatorImpl("*", PRIORITY_MEDIUM))
            .put("/", new BinaryOperatorImpl("/", PRIORITY_MEDIUM))
            .build();

    /**
     * Gets a set of representations.
     *
     * @return Set of keys that represents binary operators
     */
    @Override
    public Set<String> getRepresentations() {
        return repo.keySet();
    }

    /**
     * Gets some Binary operator according to representation.
     *
     * @param representation
     * @return {@link BinaryOperator} object
     */
    @Override
    public Optional<BinaryOperator> getBinaryOperator(String representation) {
        log.info("Someone requesting operator: " + representation);
        final BinaryOperator operator = repo.get(representation);
        final Optional<BinaryOperator> binaryOperator = Optional.ofNullable(operator);
        return binaryOperator;
    }
}
