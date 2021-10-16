package apap.tutorial.BOBAXIXIXI.service;

import java.util.List;

import apap.tutorial.BOBAXIXIXI.model.ManagerModel;

public interface ManagerService {
    ManagerModel getManagerbyId(Long id);
    List<ManagerModel> getManagerList();
}
