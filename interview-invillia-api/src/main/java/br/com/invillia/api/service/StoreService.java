package br.com.invillia.api.service;


import br.com.invillia.api.model.store.entity.Store;

import java.util.List;

public interface StoreService  {
    Store create(Store store);
    Store update(Store store);
    List<Store> listAll();
    List<Store> findByName(String name);
    Store findById(Long id);
    List<Store> findByAddress(String address);
}
