package br.com.invillia.api.model.order.exception;

import br.com.invillia.api.exception.BadRequestException;

public class OrderRefundedException  extends BadRequestException {

    public OrderRefundedException(Long idOrder) {
        super("Order "+idOrder+" refunded");
    }
}
