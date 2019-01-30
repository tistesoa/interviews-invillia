package br.com.invillia.api.model.store.entity;

import br.com.invillia.api.model.order.entity.Order;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;

    @Tolerate
    public Store(String name, String address){
        setName(name);
        setAddress(address);
    }

    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
    private List<Order> orders;


    @Tolerate
    public Store(Long id) {
        setId(id);
    }



}
