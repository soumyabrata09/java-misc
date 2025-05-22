package com.sam09.mappings.model;

import com.sam09.mappings.enums.CustomerInstallmentCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerValidation {

    private Boolean customerInstallmentActive;
    private String[] cardsWithInstallments;
    private String[] cardsWithActiveInstallments;
    private CustomerInstallmentCheck reasons;

}
