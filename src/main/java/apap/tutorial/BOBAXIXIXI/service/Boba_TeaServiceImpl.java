package apap.tutorial.BOBAXIXIXI.service;

import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.repository.Boba_TeaDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class Boba_TeaServiceImpl implements Boba_TeaService {
    
    @Autowired
    Boba_TeaDb boba_TeaDb;

    @Override
    public void addBoba(Boba_TeaModel boba_tea){
        boba_TeaDb.save(boba_tea);
    }

    @Override
    public void updateBoba(Boba_TeaModel boba_tea){
        boba_TeaDb.save(boba_tea);
    }

    @Override
    public List<Boba_TeaModel> getBoba_TeaList(){
        return boba_TeaDb.findAll();
    }

    @Override
    public Boba_TeaModel getBoba_TeaById(Long id){
        Optional<Boba_TeaModel> boba_tea = boba_TeaDb.findById(id);
        if (boba_tea.isPresent()){
            return boba_tea.get();
        }
        return null;
    }

    @Override
    public void deleteBoba(Boba_TeaModel boba_tea){
        boba_TeaDb.delete(boba_tea);
    }




}
