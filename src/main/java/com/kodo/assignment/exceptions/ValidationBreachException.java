package com.kodo.assignment.exceptions;

import java.util.List;
import java.util.Map;

public class ValidationBreachException extends RuntimeException{

    private Map<Integer, List<String>> inValidMessages;
    public ValidationBreachException(Map<Integer, List<String>> messagesMap) {
        super(String.valueOf("ValidationBreachException"));
        inValidMessages = messagesMap;
    }

    public Map<Integer, List<String>> getInValidMessages() {
        return inValidMessages;
    }
}
