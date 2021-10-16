package apap.tutorial.BOBAXIXIXI.repository;
import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.model.ToppingModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface ToppingDb extends JpaRepository<ToppingModel, Long>{
    Optional<ToppingModel> findById(Long id);
    List<ToppingModel> findAllById(Long id);
}
