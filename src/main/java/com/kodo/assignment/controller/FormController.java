package com.kodo.assignment.controller;

import com.kodo.assignment.models.Form;
import com.kodo.assignment.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping
    public ResponseEntity<List<Form>> getAllForms() {
        List<Form> forms = formService.getAllForms();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @GetMapping("/{formId}")
    public ResponseEntity<Form> getFormById(@PathVariable Integer formId) {
        Form form = formService.getFormById(formId);
        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Form> createForm(@RequestBody Form form) {
        Form createdForm = formService.createForm(form);
        return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
    }

    @PutMapping("/{formId}")
    public ResponseEntity<Form> updateForm(@PathVariable Integer formId, @RequestBody Form form) {
        Form updatedForm = formService.updateForm(formId, form);
        if (updatedForm != null) {
            return new ResponseEntity<>(updatedForm, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{formId}")
    public ResponseEntity<String> deleteForm(@PathVariable Integer formId) {
        String response = formService.deleteForm(formId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{formId}/submit")
    public ResponseEntity<Void> submitFormData(@PathVariable Long formId, @RequestBody Form formData) {
        boolean success = formService.submitFormData(formId, formData);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
