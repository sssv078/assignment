package com.kodo.assignment.models;

import com.kodo.assignment.entity.FormEntity;
import com.kodo.assignment.entity.FormFieldEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Form {
    private String title;
    private String submitButtonLabel;
    private List<FormField> formFields;

    public Form convertFormObjectFromEntity(FormEntity formEntity) {
        return Form.builder()
                .title(formEntity.getTitle())
                .submitButtonLabel(formEntity.getSubmitButtonLabel())
                .formFields(formEntity.getFormFields().stream()
                        .map(field -> {
                            return new FormField().convertFormFieldFromEntity(field);
                        })
                        .toList())
                .build();
    }
}
