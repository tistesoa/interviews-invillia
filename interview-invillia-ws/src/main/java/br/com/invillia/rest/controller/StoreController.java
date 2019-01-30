package br.com.invillia.rest.controller;

import br.com.invillia.api.store.entity.Store;
import br.com.invillia.api.store.service.StoreService;
import br.com.invillia.impl.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    StoreService store;

    @PostMapping("/new")
    public Long createStore(@RequestBody Store newStore) {//Welcome page, non-rest
        return store.createStore(newStore);
    }

    @PutMapping("/update")
    public Long updateStore(@RequestBody Store newStore) {//Welcome page, non-rest
        return store.updateStore(newStore);
    }

    @GetMapping("/find/name/{name}")
    public List<Store> listAll(@PathVariable String name) {//REST Endpoint.
        return store.findByName(name);
    }

    @GetMapping("/get/{id}")
    public Store listAll(@PathVariable Long id) {//REST Endpoint.
        return store.findById(id);
    }


    @GetMapping("/list/all")
    public List<Store> listAll() {//REST Endpoint.
        return store.listAll();
    }
}