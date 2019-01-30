package br.com.invillia.rest.controller;

import br.com.invillia.api.model.store.entity.Store;
import br.com.invillia.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    StoreService store;

    @PostMapping("/new")
    public Store createStore(@Valid @RequestBody Store newStore) {
        return store.create(newStore);
    }

    @PutMapping("/update")
    public Store updateStore(@Valid @RequestBody Store newStore) {
        return store.update(newStore);
    }

    @GetMapping("/find/name/{name}")
    public List<Store> listByName(@NonNull @PathVariable String name) {
        return store.findByName(name);
    }

    @GetMapping("/find/address/{address}")
    public List<Store> listByAddress(@NonNull @PathVariable String address) {
        return store.findByAddress(address);
    }

    @GetMapping("/get/{id}")
    public Store findById(@NonNull @PathVariable Long id) {
        return store.findById(id);
    }

    @GetMapping("/list/all")
    public List<Store> listAll() {
        return store.listAll();
    }

/*    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}