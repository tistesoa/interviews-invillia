package br.com.invillia.impl.service;


import br.com.invillia.api.model.order.OrderDTO;
import br.com.invillia.api.model.order.exception.OrderNotFoundException;
import br.com.invillia.api.model.order.exception.OrderUnableRefundException;
import br.com.invillia.api.model.order.entity.Order;
import br.com.invillia.api.model.order.OrderRepository;
import br.com.invillia.api.model.order.entity.OrderStatus;
import br.com.invillia.api.model.store.StoreNotFoundException;
import br.com.invillia.api.model.store.StoreRepository;
import br.com.invillia.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    StoreRepository storeRepository;


    @Override
    @Transactional(rollbackFor = StoreNotFoundException.class)
    public Order create(OrderDTO dto) {
        storeRepository.findById(dto.getStoreId()).orElseThrow(() -> new StoreNotFoundException(dto.getStoreId()));
        Order newOrder = new Order(dto);
        return repository.save(newOrder);
    }

    @Override
    public Order refund(Long idOrder, Long idItem) {
        Order order = repository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException(idOrder));
        if (order.getStatus().equals(OrderStatus.AWAITING_PAYMENT)) {
            if (order.getConfirmationDate().minusDays(10).getDayOfMonth() > LocalDateTime.now().getDayOfMonth()) {
                throw new OrderUnableRefundException(order.getId());
            }
            if (Objects.nonNull(idItem)) {
                order.setItems(order.getItems().stream().filter(item -> !item.getId().equals(idItem)).collect(Collectors.toList()));
            } else {
                order.setStatus(OrderStatus.REFUNDED);
            }
        }else{
            throw new OrderUnableRefundException(order.getId());
        }
        return repository.save(order);
    }
}
