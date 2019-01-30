package br.com.invillia.impl.service;

import br.com.invillia.api.model.store.StoreNotFoundException;
import br.com.invillia.api.model.store.entity.Store;
import br.com.invillia.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.invillia.api.model.store.StoreRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("store")
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository repository;

    @Override
    public Store create(Store store) {
        store.setId(null);
        return repository.save(store);
    }

    @Override
    public Store update(Store store) {
        return repository.findById(store.getId())
                .map(value -> {
                    value.setName(store.getName());
                    value.setAddress(store.getAddress());
                    return repository.save(store);
                })
                .orElseGet(() -> {
                   return create(store);
                });
    }

    @Override
    public List<Store> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Store> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Store findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new StoreNotFoundException(id));
    }

    @Override
    public List<Store> findByAddress(String address) {
        return repository.findByAddress(address);
    }
}
