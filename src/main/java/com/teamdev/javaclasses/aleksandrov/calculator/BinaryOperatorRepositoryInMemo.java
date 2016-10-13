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
