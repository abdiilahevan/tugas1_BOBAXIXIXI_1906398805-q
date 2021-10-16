package apap.tutorial.BOBAXIXIXI.service;

import apap.tutorial.BOBAXIXIXI.model.ToppingModel;
import apap.tutorial.BOBAXIXIXI.repository.ToppingDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class ToppingServiceImpl implements ToppingService{
    @Autowired
    ToppingDb toppingDb;
    
    @Override
    public ToppingModel getToppingbyId(Long id){
        Optional<ToppingModel> topping = toppingDb.findById(id);
        if (topping.isPresent()){
            return topping.get();
        }
        return null;
    }

    
    @Override
    public List<ToppingModel> getToppingList(){
        return toppingDb.findAll();
    }


}
