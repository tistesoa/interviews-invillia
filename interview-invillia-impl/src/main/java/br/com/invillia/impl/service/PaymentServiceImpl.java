package br.com.invillia.impl.service;

import br.com.invillia.api.model.order.exception.OrderNotFoundException;
import br.com.invillia.api.model.order.OrderRepository;
import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.model.payment.PaymentDTO;
import br.com.invillia.api.model.payment.ReplicatePaymentException;
import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.model.payment.PaymentRepository;
import br.com.invillia.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = {OrderNotFoundException.class, ReplicatePaymentException.class})
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Payment create(PaymentDTO newPayment) {
        Order order = this.orderRepository.findById(newPayment.getOrderId()).orElseThrow(() -> new OrderNotFoundException(newPayment.getOrderId()));
        switch (order.getStatus()) {
            case PAID:
                throw new ReplicatePaymentException(order.getId());
            case AWAITING_PAYMENT:
                try {
                    Payment payment = repository.save(new Payment(newPayment));
                    order.setStatus(payment.getStatus());
                    order.setPayment(payment);
                    return payment;
                } catch (Exception e) {
                    throw new ReplicatePaymentException(order.getId());
                }
            case REFUNDED:
                throw new ReplicatePaymentException(order.getId());
        }
        return null;
    }
}