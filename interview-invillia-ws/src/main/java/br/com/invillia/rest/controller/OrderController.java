package br.com.invillia.rest.controller;


import br.com.invillia.api.model.order.OrderDTO;
import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService order;

    @PostMapping("/new")
    public Order create(@Validated @RequestBody OrderDTO newOrder) { //valid order with items
        return order.create(newOrder);
    }


    @PostMapping("/refund/{idOrder}")
    public Order refundOrder(@NotNull @PathVariable Long idOrder, @RequestParam(name="idItem", required = false) Long idItem) { //valid order with items
        return order.refund(idOrder,idItem);
    }



}
