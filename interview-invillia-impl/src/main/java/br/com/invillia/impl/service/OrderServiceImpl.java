package br.com.invillia.impl.service;


import br.com.invillia.api.model.order.OrderNotFoundException;
import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.model.order.OrderRepository;
import br.com.invillia.api.model.store.StoreNotFoundException;
import br.com.invillia.api.model.store.StoreRepository;
import br.com.invillia.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    StoreRepository storeRepository;


    @Override
    @Transactional(rollbackFor = StoreNotFoundException.class)
    public Order create(Order newOrder) {
        storeRepository.findById(newOrder.getStore().getId()).orElseThrow(() -> new StoreNotFoundException(newOrder.getStore().getId()));
        return repository.save(newOrder);
    }

    @Override
    public void refund(Long idOrder, Long idItem) {
        Order order = repository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException(idOrder));
        if(order.getConfirmationDate().minusDays(10).getDayOfMonth() > LocalDateTime.now().getDayOfMonth()){

        }
        if(Objects.nonNull(idItem)){

        }
    }
}
