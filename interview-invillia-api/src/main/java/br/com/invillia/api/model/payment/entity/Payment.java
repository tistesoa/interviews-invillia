package br.com.invillia.api.model.payment.entity;

import br.com.invillia.api.model.order.entity.Order;
import lombok.Data;

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

    private String status;
    @NotNull
    private String creditCardNumber;

    @NotNull
    private LocalDateTime paymentDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

}
