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

import java.util.ArrayList;
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

    @GetMapping("/store/{id}/assign-boba/")
    public String addBobainStoreForm(Model model, @PathVariable Long id){
        model.addAttribute("ids", id);
        model.addAttribute("storeBobaRelation", new Store_Boba_TeaModel());
        model.addAttribute("boba_tea", boba_TeaService.getBoba_TeaList());
        return "form-add-boba-to-store";
    }

    @PostMapping(value = "/store/{id}/assign-boba/")
    public String saveBobainStore(
        @PathVariable Long id,
        @ModelAttribute Store_Boba_TeaModel storeBobaRelation,
        @RequestParam(value = "boba") Long[] boba_Tea,
        Model model
    ){
        //store_Boba_TeaService.addStoreBobaTea(storeBobaRelation.getStore(), storeBobaRelation.getBoba_tea());
        model.addAttribute("boba_list", boba_Tea);
        List<Boba_TeaModel> bobaDiStore= new ArrayList<>();
        for(Long bobba : boba_Tea){
            Boba_TeaModel boba = boba_TeaService.getBoba_TeaById(bobba);
            StoreModel store = storeService.getStoreById(id);
            store_Boba_TeaService.addStoreBobaTea(store, boba);
            bobaDiStore.add(boba);
        }
        model.addAttribute("bobaDiStore", bobaDiStore);
        return "add-boba-to-store";
    }

    @GetMapping("/boba/{id}/assign-store/")
    public String addstoreinBobaForm(Model model, @PathVariable Long id){
        model.addAttribute("storeBobaRelation", new Store_Boba_TeaModel());
        model.addAttribute("store", storeService.getStoreList());
        return "form-add-store-to-boba";
    }

    @PostMapping(value = "/boba/{id}/assign-store/")
    public String saveStoreinBoba(
        @PathVariable Long id,
        @ModelAttribute Store_Boba_TeaModel storeBobaRelation,
        @RequestParam(value = "store") Long[] store,
        Model model
    ){
        //store_Boba_TeaService.addStoreBobaTea(storeBobaRelation.getStore(), storeBobaRelation.getBoba_tea());
        model.addAttribute("store", store);
        List<StoreModel> storeDiBoba = new ArrayList<>();
        for(Long storeEach : store){
            StoreModel storee = storeService.getStoreById(storeEach);
            Boba_TeaModel boba = boba_TeaService.getBoba_TeaById(id);
            store_Boba_TeaService.addStoreBobaTea(storee, boba);
            storeDiBoba.add(storee);
        }
        model.addAttribute("storeDiBoba", storeDiBoba);
        return "add-boba-to-store";
    }
}
