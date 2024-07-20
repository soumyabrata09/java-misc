package com.sam09.mappings.service;

import com.sam09.mappings.mappers.CardAndCustomerValidationMapper;
import com.sam09.mappings.model.CardAndCustomerValidation;
import com.sam09.mappings.rto.CardValidationRto;
import com.sam09.mappings.rto.CustomerValidationRto;
import org.springframework.stereotype.Service;

@Service
public class InstallmentEvaluationImpl implements InstallmentEvaluationService {

    private final String[] DUMMY_CARDS_WITH_INSTALLMENT = new String[]{
            "viywhwertb",
            "wu9ugr3zfs",
            "saw3392fg7",
            "cnkpv6h16u"
    };
    private final String[] DUMMY_CARDS_WITH_ACTIVE_INSTALLMENT = new String[]{
            "wu9ugr3zfs",
            "cnkpv6h16u"
    };
    private CardValidationRto cardValidationRto;
    private CustomerValidationRto customerValidationRto;

    @Override
    public CardAndCustomerValidation getInstallmentEvaluation() {
        buildMockedCardAndCustomerValidationData(Boolean.TRUE);
        return CardAndCustomerValidationMapper.INSTANCE.mapTo(cardValidationRto, customerValidationRto);
    }

    private void buildMockedCardAndCustomerValidationData(Boolean cardInstallmentActive) {
        if (Boolean.TRUE.equals(cardInstallmentActive)) {
            buildMockedCardValidationRtoData();
        } else {
            buildMockedCustomerValidationRtoData();
        }
    }

    private void buildMockedCustomerValidationRtoData() {
        cardValidationRto = new CardValidationRto();
        cardValidationRto.setCardInstallmentActive(Boolean.TRUE);
    }

    private void buildMockedCardValidationRtoData() {
        customerValidationRto = new CustomerValidationRto();
        customerValidationRto.setCustomerInstallmentActive(Boolean.TRUE);
        customerValidationRto.setCardsWithInstallments(DUMMY_CARDS_WITH_INSTALLMENT);
        customerValidationRto.setCardsWithActiveInstallments(DUMMY_CARDS_WITH_ACTIVE_INSTALLMENT);
    }

}
