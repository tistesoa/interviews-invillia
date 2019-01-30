package br.com.invillia.api.store.service;


import br.com.invillia.api.store.entity.Store;

import java.util.List;

public interface StoreService  {
    Store createStore(Store store);
    Store updateStore(Store store);
    List<Store> listAll();

    List<Store> findByName(String name);

    Store findById(Long id);
}
