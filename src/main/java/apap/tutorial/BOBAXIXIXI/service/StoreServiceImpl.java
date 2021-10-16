package apap.tutorial.BOBAXIXIXI.service;

import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.repository.StoreDb;

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
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreDb storeDb;

    @Override
    public void addStore(StoreModel store){
        storeDb.save(store);
    }

    @Override
    public void updateStore(StoreModel store){
        store.setNoTeleponToko(addStoreCode(store));
        storeDb.save(store);
    }

    @Override
    public String addStoreCode(StoreModel store){
        String kode1 = (store.getNamaToko().substring(0, 3).toUpperCase());
        char ch;
        String pecahKode = "";
        for (int i = 0 ; i<kode1.length(); i++){
            ch = kode1.charAt(i);
            pecahKode = ch+pecahKode;
        }
        String openHour = store.getWaktuBuka().toString().substring(0,2);
        int closeHour = store.getWaktuTutup().getHour();
        int jam = (int)Math.floor(closeHour/10);

        //Untuk random last, source code dari baeldung untuk generate random char
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 2;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        String hasil = "SC" + pecahKode + openHour + Integer.toString(jam) + randomString;
        return hasil;
    }

    @Override
    public List<StoreModel> getStoreList(){
        return storeDb.findAll();
    }

    @Override
    public StoreModel getStoreById(Long id){
        Optional<StoreModel> store = storeDb.findById(id);
        if (store.isPresent()){
            return store.get();
        }
        return null;
    }

    @Override
    public Boolean jamWaktuTutup(StoreModel store){
        LocalTime now = LocalTime.now();
        if(now.isBefore(store.getWaktuBuka()) || now.isAfter(store.getWaktuTutup())){
            return true;
        }
        return false;
    }

    @Override
    public void deleteStore(StoreModel store){
        if(jamWaktuTutup(store) == true){
            storeDb.delete(store);
        }
    }
}
