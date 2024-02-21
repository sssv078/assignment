package com.kodo.assignment.services;

import com.kodo.assignment.models.Form;
import com.kodo.assignment.models.FormField;

import java.util.List;

public interface FormService {

    public List<Form> getAllForms();
    public Form getFormById(Integer formId);
    public Form createForm(Form form);
    public Form updateForm(Integer formId, Form form);
    public String deleteForm(Integer formId);
    public boolean submitFormData(Long formId, Form form);
}
