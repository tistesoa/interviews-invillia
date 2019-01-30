package br.com.invillia.api.model.order;

import br.com.invillia.api.model.ConstraintException;

public class OrderUnableRefund extends ConstraintException {

    public OrderUnableRefund(Long id) {
        super("refund order " + id + " can not be refund");
    }
}
