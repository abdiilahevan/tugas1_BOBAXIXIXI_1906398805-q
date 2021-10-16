package apap.tutorial.BOBAXIXIXI.repository;
import apap.tutorial.BOBAXIXIXI.model.Store_Boba_TeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface Store_Boba_TeaDb extends JpaRepository<Store_Boba_TeaModel, Long>{
    Optional<Store_Boba_TeaModel> findById(Long id);
}
