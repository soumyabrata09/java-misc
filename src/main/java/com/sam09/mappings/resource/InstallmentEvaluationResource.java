package com.sam09.mappings.resource;

import com.sam09.mappings.model.CardAndCustomerValidation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/installments")
public interface InstallmentEvaluationResource {

    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    CardAndCustomerValidation getCardAndCustomerValidate();

}
