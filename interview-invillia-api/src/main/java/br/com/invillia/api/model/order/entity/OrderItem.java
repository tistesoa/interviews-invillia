package br.com.invillia.api.model.order.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Data
@Table(name ="ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String description;
    private String price;
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
