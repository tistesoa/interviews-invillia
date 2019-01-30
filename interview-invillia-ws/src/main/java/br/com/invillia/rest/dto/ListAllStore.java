package br.com.invillia.rest.dto;

import br.com.invillia.api.model.store.entity.Store;
import lombok.Data;

import java.util.List;

@Data
public class ListAllStore {

    private List<Store> stores;
}
