package apap.tutorial.BOBAXIXIXI.service;

import java.util.List;

import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.model.Store_Boba_TeaModel;

public interface Store_Boba_TeaService{
    List<StoreModel> findAllStorebyId(Long id);
    List<Boba_TeaModel> findAllBobabyId(Long id);
    String addProductionCode(Boba_TeaModel boba, StoreModel store);
    void addStoreBobaTea(StoreModel store, Boba_TeaModel boba_Tea);
    List<Store_Boba_TeaModel> getStoreBobalist();
}
