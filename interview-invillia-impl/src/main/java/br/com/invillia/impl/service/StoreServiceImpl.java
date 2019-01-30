package br.com.invillia.impl.service;

import br.com.invillia.api.store.StoreNotFoundException;
import br.com.invillia.api.store.entity.Store;
import br.com.invillia.api.store.repository.StoreRepository;
import br.com.invillia.api.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("store")
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository repository;

    @Override
    public Store createStore(Store store) {
        store.setId(null);
        return repository.save(store);
    }

    @Override
    public Store updateStore(Store store) {

        return repository.findById(store.getId())
                .map(value -> {
                    value.setName(store.getName());
                    value.setAddress(store.getAddress());
                    return repository.save(store);
                })
                .orElseGet(() -> {
                    store.setId(null);
                    return repository.save(store);
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
}
