package apap.tutorial.BOBAXIXIXI.service;

import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import java.util.List;

public interface StoreService {
    void addStore(StoreModel store);
    void updateStore(StoreModel store);
    List<StoreModel> getStoreList();
    StoreModel getStoreById(Long id);
    Boolean jamWaktuTutup(StoreModel store);
    String addStoreCode(StoreModel store);
    void deleteStore(StoreModel store);
}
