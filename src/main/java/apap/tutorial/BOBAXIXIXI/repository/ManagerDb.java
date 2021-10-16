package apap.tutorial.BOBAXIXIXI.repository;
import apap.tutorial.BOBAXIXIXI.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface ManagerDb extends JpaRepository<ManagerModel, Long> {
    Optional<ManagerModel> findById(Long id);
}
