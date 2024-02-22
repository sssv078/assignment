package com.kodo.assignment.services;

import com.kodo.assignment.exceptions.ValidationBreachException;
import com.kodo.assignment.models.FieldConfiguration;
import com.kodo.assignment.models.FieldType;
import com.kodo.assignment.models.Form;
import com.kodo.assignment.models.FormField;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ValidationService {


    public boolean validateFormResponse(Form form) {
        Map<Integer, List<String>> invalidCauses = new HashMap<>();
        try {
            invalidCauses = form.getFormFields().stream().collect(Collectors.toMap(
                    FormField::getId,
                    formField -> {

                        String data = formField.getLabel();
                        FieldConfiguration fieldConfiguration = formField.getConfiguration();
                        if (FieldType.TEXT.equals(fieldConfiguration.getFieldType())) {
                            return validateFieldDataByConfigurationForNumber(data, fieldConfiguration);
                        }
                        return formFieldvalidateFieldDataByConfigurationForText(data, fieldConfiguration);
                    }));
            if (invalidCauses.isEmpty()) {
                return true;
            } else {
                throw new RuntimeException();
            }
        }
        catch(RuntimeException vbe) {
            throw new ValidationBreachException(invalidCauses);
        }
    }

    private List<String> validateFieldDataByConfigurationForNumber(String data, FieldConfiguration fieldConfiguration) {
        List<String> inValidMessages = new ArrayList<>();
        try {
            inValidMessages = mandatoryFieldBreachedValidation(fieldConfiguration.isRequired(), data, inValidMessages);
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            if (!data.isEmpty() && !pattern.matcher(data).matches()) {
                inValidMessages.add("non-numeric");
            } else {
                Integer numericData = Integer.parseInt(data);
                if (!(numericData>fieldConfiguration.getMinSize() && numericData< fieldConfiguration.getMaxSize())) {
                    inValidMessages.add("length should be b/w " +fieldConfiguration.getMinSize()+ "and" + fieldConfiguration.getMaxSize());
                }
            }
        }
        catch(NumberFormatException nfe) {
            inValidMessages.add("Enter a numeric value: "+ nfe.getMessage());
        }
        catch (Exception e) {
            inValidMessages.add("Exception occured: "+ e.getMessage());
        }
        return inValidMessages;
    }


    private List<String> formFieldvalidateFieldDataByConfigurationForText(String data, FieldConfiguration fieldConfiguration) {
        List<String> inValidMessages = new ArrayList<>();
        try {
            inValidMessages = mandatoryFieldBreachedValidation(fieldConfiguration.isRequired(), data, inValidMessages);
            if(data.length()< fieldConfiguration.getMinSize() || data.length()> fieldConfiguration.getMaxSize()) {
                inValidMessages.add("length should be b/w " +fieldConfiguration.getMinSize()+ "and" + fieldConfiguration.getMaxSize());
            }
        }
        catch(Exception e) {
            inValidMessages.add("Exception occured: "+ e.getMessage());
        }
        return inValidMessages;
    }

    public List<String> mandatoryFieldBreachedValidation(boolean isRequired, String data, List<String> inValidMessages) {
        if (isRequired && data.trim().isEmpty()) {
            inValidMessages.add("Mandatory field empty");
        }
        return inValidMessages;
    }
    
}
