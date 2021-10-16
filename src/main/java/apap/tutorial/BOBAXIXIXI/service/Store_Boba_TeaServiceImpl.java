package apap.tutorial.BOBAXIXIXI.service;

import apap.tutorial.BOBAXIXIXI.model.Store_Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.repository.Store_Boba_TeaDb;
import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.repository.StoreDb;
import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.repository.Boba_TeaDb;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class Store_Boba_TeaServiceImpl implements Store_Boba_TeaService{
    @Autowired
    Store_Boba_TeaDb store_Boba_TeaDb;

    @Autowired
    StoreDb storeDb;

    @Autowired
    Boba_TeaDb boba_TeaDb;

    @Override
    public List<StoreModel> findAllStorebyId(Long id){
        return storeDb.findAllById(id);
    }

    @Override
    public List<Boba_TeaModel> findAllBobabyId(Long id){
        return boba_TeaDb.findAllById(id);
    }

    @Override
    public String addProductionCode(Store_Boba_TeaModel storeBobaRelation){
        Long codeFromStoreAsli = storeBobaRelation.getStore().getId();
        String codeFromStore = String.format("%03d", codeFromStoreAsli);
        String tengah;
        if(storeBobaRelation.getBoba_tea().getTopping() != null){
            tengah = "1";
        }
        else{
            tengah = "0";
        }
        Long codeFromBobaAsli = storeBobaRelation.getBoba_tea().getId();
        String codeFromBoba = String.format("%03d", codeFromBobaAsli);
        String production = "PC" + codeFromStore + tengah + codeFromBoba;
        return production;
    }
    @Override
    public void addStoreBobaTea(Long id, Store_Boba_TeaModel storeBobaRelation, StoreModel store, Boba_TeaModel boba_Tea){
        storeBobaRelation.setId(id);
        storeBobaRelation.setStore(store);
        storeBobaRelation.setBoba_tea(boba_Tea);
        store_Boba_TeaDb.save(storeBobaRelation);
    }


}
