package br.com.invillia.api.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String address;
    private LocalDateTime confirmationDate;
    private OrderStatus status;
}
