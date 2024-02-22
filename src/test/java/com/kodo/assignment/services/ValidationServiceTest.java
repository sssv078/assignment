package com.kodo.assignment.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {

    @InjectMocks
    private ValidationService validationService;

    @Test
    void testMandatoryFieldBreachedValidation() {
        List<String> messages = new ArrayList<>();
        messages.add("Mandatory field empty");
        List<String> inValidMessages = validationService.mandatoryFieldBreachedValidation(true, "", new ArrayList<>());
        assertEquals(messages, inValidMessages);
    }
}
