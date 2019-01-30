package br.com.invillia.api.service;

import br.com.invillia.api.model.order.OrderDTO;
import br.com.invillia.api.model.order.entity.Order;

public interface OrderService {
    Order create(OrderDTO newOrder);

    void refund(Long idOrder, Long idItem);
}
