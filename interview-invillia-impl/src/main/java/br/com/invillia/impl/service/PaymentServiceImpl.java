package br.com.invillia.impl.service;

import br.com.invillia.api.model.ConstraintException;
import br.com.invillia.api.model.order.OrderNotFoundException;
import br.com.invillia.api.model.order.OrderRepository;
import br.com.invillia.api.model.payment.ReplicateOrderException;
import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.model.payment.PaymentRepository;
import br.com.invillia.api.service.PaymentService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional(rollbackFor = {OrderNotFoundException.class,ReplicateOrderException.class})
    public Payment create(Payment newPayment) {
        this.orderRepository.findById(newPayment.getOrder().getId()).orElseThrow(() -> new OrderNotFoundException(newPayment.getOrder().getId()));
        try {
            return repository.save(newPayment);
        }catch (ConstraintViolationException e ){
            e.getConstraintName();
            throw new ReplicateOrderException();
        }
    }
}
