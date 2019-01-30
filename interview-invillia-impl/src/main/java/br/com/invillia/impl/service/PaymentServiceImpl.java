package br.com.invillia.impl.service;

import br.com.invillia.api.model.order.OrderNotFoundException;
import br.com.invillia.api.model.order.OrderRepository;
import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.model.payment.PaymentDTO;
import br.com.invillia.api.model.payment.ReplicateOrderException;
import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.model.payment.PaymentRepository;
import br.com.invillia.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = {OrderNotFoundException.class,ReplicateOrderException.class})
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Payment create(PaymentDTO newPayment) {
        Order order = this.orderRepository.findById(newPayment.getOrderId()).orElseThrow(() -> new OrderNotFoundException(newPayment.getOrderId()));
        try {
            Payment payment = repository.save(new Payment(newPayment));
            order.setStatus(payment.getStatus());
            return payment;
        }catch (Exception e){
            throw new ReplicateOrderException();
        }

    }
}
