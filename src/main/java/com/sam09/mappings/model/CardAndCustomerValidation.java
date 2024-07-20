package com.sam09.mappings.model;

import com.sam09.mappings.enums.CardInstallmentCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardAndCustomerValidation {

    private Boolean cardInstallmentActive;
    private CustomerValidation customerValidation;
    private CardInstallmentCheck[] reasons;

}
