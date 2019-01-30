package br.com.invillia.rest.controller;


import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService order;

    @PostMapping("/new")
    public Order create(@Valid @RequestBody Order newOrder) { //valid order with items
        return order.create(newOrder);
    }


    @PostMapping("/refund/order/{idOrder}")
    public void refundOrder(@NonNull @PathVariable Long idOrder, @RequestParam("idItem") Long idItem) { //valid order with items
        order.refund(idOrder,idItem);
    }



}
