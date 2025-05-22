package com.sam09.mappings.resource;

import com.sam09.mappings.model.CardAndCustomerValidation;
import com.sam09.mappings.service.InstallmentEvaluationService;

public class InstallmentEvaluationResourceImpl implements InstallmentEvaluationResource {

    private final InstallmentEvaluationService installmentEvaluationService;

    public InstallmentEvaluationResourceImpl(InstallmentEvaluationService installmentEvaluationService) {
        this.installmentEvaluationService = installmentEvaluationService;
    }

    @Override
    public CardAndCustomerValidation getCardAndCustomerValidate() {
        return installmentEvaluationService.getInstallmentEvaluation();
    }

}
