package apap.tutorial.BOBAXIXIXI.service;

import java.util.List;

import apap.tutorial.BOBAXIXIXI.model.ToppingModel;

public interface ToppingService {
    ToppingModel getToppingbyId(Long id);
    List<ToppingModel> getToppingList();
}
