package br.com.invillia.api.store.entity;

import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @Tolerate
    public Store(String name, String address){
        setName(name);
        setAddress(address);
    }

}
