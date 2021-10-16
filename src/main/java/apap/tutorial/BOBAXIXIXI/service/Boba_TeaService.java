package apap.tutorial.BOBAXIXIXI.service;

import java.util.List;

import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;

public interface Boba_TeaService {
    void addBoba(Boba_TeaModel boba_tea);
    void updateBoba(Boba_TeaModel boba_tea);
    List<Boba_TeaModel> getBoba_TeaList();
    Boba_TeaModel getBoba_TeaById(Long id);
    void deleteBoba(Boba_TeaModel boba_tea);
}
