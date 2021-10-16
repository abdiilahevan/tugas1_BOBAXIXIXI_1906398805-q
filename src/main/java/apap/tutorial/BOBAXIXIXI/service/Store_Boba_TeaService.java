package apap.tutorial.BOBAXIXIXI.service;

import java.util.List;

import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.model.Store_Boba_TeaModel;

public interface Store_Boba_TeaService{
    List<StoreModel> findAllStorebyId(Long id);
    List<Boba_TeaModel> findAllBobabyId(Long id);
    String addProductionCode(Store_Boba_TeaModel storeBobaRelation);
    void addStoreBobaTea(Long id, Store_Boba_TeaModel storeBobaRelation, StoreModel store, Boba_TeaModel boba_Tea);
}
