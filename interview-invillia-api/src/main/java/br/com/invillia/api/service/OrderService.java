package br.com.invillia.api.service;

import br.com.invillia.api.model.order.entity.Order;

public interface OrderService {
    Order create(Order newOrder);

    void refund(Long idOrder, Long idItem);
}
