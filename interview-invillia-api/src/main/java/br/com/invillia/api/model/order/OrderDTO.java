package br.com.invillia.api.model.order;

import br.com.invillia.api.model.order.entity.OrderItem;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDTO {
    @NotNull
    private Long storeId;

    @NotNull
    private String address;

    @NotNull
    private List<OrderItem> items;


}
