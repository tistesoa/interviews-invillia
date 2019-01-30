package br.com.invillia.api.payment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String status;
    private String creditCard;
    private LocalDateTime paymentDate;


}
