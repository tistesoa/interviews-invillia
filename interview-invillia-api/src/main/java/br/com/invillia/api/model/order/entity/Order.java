package br.com.invillia.api.model.order.entity;

import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.model.store.entity.Store;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name="ORDER_TABLE")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String address;

    @Column(name = "CONFIRMATION_DATE")
    private LocalDateTime confirmationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<OrderItem> items;


    @OneToOne(mappedBy = "order",fetch = FetchType.LAZY)
    private Payment payment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

}
