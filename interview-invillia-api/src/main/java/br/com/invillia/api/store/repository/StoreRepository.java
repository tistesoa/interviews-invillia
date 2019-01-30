package br.com.invillia.api.store.repository;

import br.com.invillia.api.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByName(String name);


}
