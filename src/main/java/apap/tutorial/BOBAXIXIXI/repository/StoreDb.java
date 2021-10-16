package apap.tutorial.BOBAXIXIXI.repository;
import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface StoreDb extends JpaRepository<StoreModel, Long>{
    Optional<StoreModel> findById(Long id);
    List<StoreModel> findAllById(Long id);
}
