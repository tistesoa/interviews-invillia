package br.com.invillia.api.order.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Currency;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String description;
    private Currency price;
    private Long quantity;

}
