package br.com.invillia.api.model.order.exception;

import br.com.invillia.api.exception.BadRequestException;

public class OrderUnableRefundException extends BadRequestException {

    public OrderUnableRefundException(Long id) {
        super("refund order " + id + " can not be refund");
    }
}
