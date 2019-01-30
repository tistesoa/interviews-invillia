package br.com.invillia.api.model.payment;

import br.com.invillia.api.model.order.entity.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {

    @NotNull
    private Long orderId;

    @NotNull
    private String creditCardNumber;


}
