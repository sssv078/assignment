package com.kodo.assignment.services.impl;

import com.kodo.assignment.entity.FieldConfigurationEntity;
import com.kodo.assignment.entity.FormEntity;
import com.kodo.assignment.entity.FormFieldEntity;
import com.kodo.assignment.models.FieldConfiguration;
import com.kodo.assignment.models.Form;
import com.kodo.assignment.repository.FieldConfigurationRepository;
import com.kodo.assignment.repository.FormFieldRepository;
import com.kodo.assignment.repository.FormRepository;
import com.kodo.assignment.services.FormService;
import com.kodo.assignment.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    FormFieldRepository formFieldRepository;

    @Autowired
    FieldConfigurationRepository fieldConfigurationRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll().stream()
                .map(form -> {
                    return new Form().convertFormObjectFromEntity(form);
                }).toList();
    }

    @Override
    public Form getFormById(Integer formId) {
        return new Form().convertFormObjectFromEntity(formRepository.findById(formId).get());
    }

    @Override
    public Form createForm(Form form) {
        formRepository.save(FormEntity.builder()
                        .title(form.getTitle())
                        .submitButtonLabel(form.getSubmitButtonLabel())
                .build());
        form.getFormFields()
                .forEach(formField -> {
                    FieldConfiguration fieldConfiguration = formField.getConfiguration();
                    fieldConfigurationRepository.save(
                            FieldConfigurationEntity.builder()
                                    .id(fieldConfiguration.getId())
                                    .type(fieldConfiguration.getFieldType())
                                    .maxSize(fieldConfiguration.getMaxSize())
                                    .minSize(fieldConfiguration.getMinSize())
                                    .integerOnly(fieldConfiguration.isIntegerOnly())
                                    .required(fieldConfiguration.isRequired())
                            .build()
                    );
                });
        return form;
    }

    @Override
    public Form updateForm(Integer formId, Form form) {
        formRepository.save(FormEntity.builder()
                        .id(formId)
                        .title(form.getTitle())
                        .submitButtonLabel(form.getSubmitButtonLabel())
                .build());
        return form;
    }

    @Override
    public String deleteForm(Integer formId) {
        formRepository.deleteById(formId);
        return "Deleted successfully";
    }

    @Override
    public boolean submitFormData(Long formId, Form form) {
        //TODO: validate the request
        if(validationService.validateFormResponse(form)) {
            form.getFormFields().stream()
                    .forEach(formField -> {
                        FieldConfiguration fieldConfiguration = formField.getConfiguration();
                        formFieldRepository.save(FormFieldEntity.builder()
                                .label(formField.getLabel())
                                .form(FormEntity.builder()
                                        .title(form.getTitle())
                                        .submitButtonLabel(form.getSubmitButtonLabel())
                                        .build())
                                .configuration(FieldConfigurationEntity.builder()
                                        .id(fieldConfiguration.getId())
                                        .type(fieldConfiguration.getFieldType())
                                        .maxSize(fieldConfiguration.getMaxSize())
                                        .minSize(fieldConfiguration.getMinSize())
                                        .integerOnly(fieldConfiguration.isIntegerOnly())
                                        .required(fieldConfiguration.isRequired())
                                        .build())
                                .build());
                    });
            return true;
        }
        return false;
    }
}
