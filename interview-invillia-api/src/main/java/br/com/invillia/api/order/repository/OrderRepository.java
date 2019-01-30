package br.com.invillia.api.order.repository;

import br.com.invillia.api.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
