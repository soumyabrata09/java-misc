package com.sam09.mappings.mappers;

import com.sam09.mappings.model.CardAndCustomerValidation;
import com.sam09.mappings.model.CustomerValidation;
import com.sam09.mappings.rto.CardValidationRto;
import com.sam09.mappings.rto.CustomerValidationRto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CardAndCustomerValidationMapper {

    CardAndCustomerValidationMapper INSTANCE = Mappers.getMapper(CardAndCustomerValidationMapper.class);

    @Mapping(target = "customerValidation", source = "customerValidationRto")
    @Mapping(target = "reasons", source = "cardValidationRto.reasons")
    CardAndCustomerValidation mapTo(CardValidationRto cardValidationRto, CustomerValidationRto customerValidationRto);

    CustomerValidation mapToCustomerValidation(CustomerValidationRto customerValidationRto);

}
