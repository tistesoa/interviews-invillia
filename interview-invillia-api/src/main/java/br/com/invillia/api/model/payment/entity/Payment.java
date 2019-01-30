package br.com.invillia.api.model.payment.entity;

import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.model.order.entity.OrderStatus;
import br.com.invillia.api.model.payment.PaymentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private OrderStatus status;

    @NotNull
    private String creditCardNumber;

    @NotNull
    private LocalDateTime paymentDate;

    @JsonIgnore
    @OneToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @Tolerate
    public Payment(PaymentDTO newPayment) {
        setCreditCardNumber(newPayment.getCreditCardNumber());
        setOrder(new Order(newPayment.getOrderId()));
        setPaymentDate(LocalDateTime.now());
        setStatus(OrderStatus.PAID);
    }
}
