package com.teamdev.javaclasses.aleksandrov.calculator;

import java.util.Set;

public interface BinaryOperatorRepository {
    Set<String> getRepresentations();
    BinaryOperator getBinaryOperator(String represetation);
}
