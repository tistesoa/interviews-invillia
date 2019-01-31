package br.com.invillia.api.model.payment;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReplicatePaymentException extends ResponseStatusException {

    public ReplicatePaymentException(Long idOrder) {
        super(HttpStatus.ALREADY_REPORTED, "Order "+idOrder+" already paid out");
    }
}
