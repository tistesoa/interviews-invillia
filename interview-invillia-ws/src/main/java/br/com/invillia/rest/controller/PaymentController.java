package br.com.invillia.rest.controller;

import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService payment;

    @PostMapping("/new")
    public Payment createPayment(@RequestBody Payment newPayment) { //valid order with items
        return payment.create(newPayment);
    }
}
