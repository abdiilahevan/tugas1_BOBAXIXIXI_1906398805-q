package apap.tutorial.BOBAXIXIXI.repository;
import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface Boba_TeaDb extends JpaRepository<Boba_TeaModel,Long>{
    Optional<Boba_TeaModel> findById(Long id);
    List<Boba_TeaModel> findAllById(Long id);
}
