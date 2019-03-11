package br.com.invillia.api.model.order.entity;

import br.com.invillia.api.model.order.OrderDTO;
import br.com.invillia.api.model.payment.entity.Payment;
import br.com.invillia.api.model.store.entity.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "ORDER_TABLE")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String address;

    @Column(name = "CONFIRMATION_DATE")
    private LocalDateTime confirmationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Payment payment;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "STORE_ID")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Store store;

    @Tolerate
    public Order(OrderDTO dto) {
        setAddress(dto.getAddress());
        setConfirmationDate(LocalDateTime.now());
        setItems(dto.getItems());
        setStore(new Store(dto.getStoreId()));
        setStatus(OrderStatus.AWAITING_PAYMENT);
    }

    @Tolerate
    public Order(Long id) {
        setId(id);
    }

}
