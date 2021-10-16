package apap.tutorial.BOBAXIXIXI.controller;


import apap.tutorial.BOBAXIXIXI.model.ToppingModel;
import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.service.Boba_TeaService;
import apap.tutorial.BOBAXIXIXI.service.ToppingService;
import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.model.Store_Boba_TeaModel;
import apap.tutorial.BOBAXIXIXI.model.ManagerModel;
import apap.tutorial.BOBAXIXIXI.service.StoreService;
import apap.tutorial.BOBAXIXIXI.service.Store_Boba_TeaService;
import apap.tutorial.BOBAXIXIXI.service.ManagerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.BOBAXIXIXI.model.Boba_TeaModel;

@Controller
public class Store_Boba_TeaController {
    @Qualifier("boba_TeaServiceImpl")
    @Autowired
    private Boba_TeaService boba_TeaService;

    @Qualifier("storeServiceImpl")
    @Autowired
    private StoreService storeService;

    @Qualifier("store_Boba_TeaServiceImpl")
    @Autowired
    private Store_Boba_TeaService store_Boba_TeaService;
//////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/store/{id}/assign-boba/")
    public String addBobainStoreForm(Model model){
        model.addAttribute("storeBobaRelation", new Store_Boba_TeaModel());
        model.addAttribute("boba_tea", boba_TeaService.getBoba_TeaList());
        return "form-add-boba-to-store";
    }

    @PostMapping(value = "/store/{id}/assign-boba/", params = "save")
    public String saveBobainStore(
        @PathVariable Long id,
        @ModelAttribute Store_Boba_TeaModel storeBobaRelation,
        @RequestParam(value = "boba") Long[] boba_Tea,
        Model model
    ){
        storeBobaRelation.setKodeProduksi(store_Boba_TeaService.addProductionCode(storeBobaRelation));
        store_Boba_TeaService.addStoreBobaTea(storeBobaRelation.getId(), storeBobaRelation, id, boba_Tea);
        return "add-store";
    }
}
