package br.com.invillia.api.service;

import br.com.invillia.api.model.payment.PaymentDTO;
import br.com.invillia.api.model.payment.entity.Payment;

public interface PaymentService {
    Payment create(PaymentDTO newPayment);
}
