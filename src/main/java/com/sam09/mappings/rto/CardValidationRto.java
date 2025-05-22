package com.sam09.mappings.rto;

import com.sam09.mappings.enums.CardInstallmentCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardValidationRto {

    private Boolean cardInstallmentActive;
    private CardInstallmentCheck[] reasons;

}
