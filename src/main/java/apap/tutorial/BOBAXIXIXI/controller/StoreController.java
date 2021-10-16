package apap.tutorial.BOBAXIXIXI.controller;

import apap.tutorial.BOBAXIXIXI.model.StoreModel;
import apap.tutorial.BOBAXIXIXI.model.ManagerModel;
import apap.tutorial.BOBAXIXIXI.service.StoreService;
import apap.tutorial.BOBAXIXIXI.service.ManagerService;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StoreController {
    @Qualifier("storeServiceImpl")
    @Autowired
    private StoreService storeService;

    @Qualifier("managerServiceImpl")
    @Autowired
    private ManagerService managerService;

    @GetMapping("/store")
    public String listStore(Model model){
        List<StoreModel> listStore = storeService.getStoreList();
        model.addAttribute("listStore", listStore);
        return "viewall-store";
    }

    @GetMapping("/store/add")
    public String addStoreForm(Model model){
        model.addAttribute("store", new StoreModel());
        List<ManagerModel> listManager = managerService.getManagerList();
        model.addAttribute("listManager", listManager);
        return "form-add-store";
    }

    @PostMapping(value = "/store/add", params = "save")
    public String saveStore(
        @ModelAttribute StoreModel store,
        Model model,
        @RequestParam("manager") String manager
    ){
        store.setNoTeleponToko(storeService.addStoreCode(store));
        storeService.addStore(store);
        model.addAttribute("store_code", store.getNoTeleponToko());
        model.addAttribute("id_store", store.getId());
        model.addAttribute("name", store.getNamaToko());
        return "add-store";
    }

    @GetMapping("/store/view/{id}")
    public String viewDetailStore(
        @PathVariable Long id,
        Model model
    ) {
        StoreModel store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        model.addAttribute("manager", store.getManager().getNamaManager());

        return "view-store";
    }

    @GetMapping("/store/update/{id}")
    public String updateStoreForm(
        @PathVariable Long id,
        Model model
    ) {
        StoreModel store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        store.setNoTeleponToko(storeService.addStoreCode(store));
        List<ManagerModel> listManager = managerService.getManagerList();
        model.addAttribute("listManager", listManager);
        model.addAttribute("store_code", store.getNoTeleponToko());
        if(storeService.jamWaktuTutup(store)){
            return "form-update-store";
        }
        return "error-page";
    }

    @PostMapping("/store/update")
    public String updateStoreSubmit(
        @ModelAttribute StoreModel store,
        Model model
    ) {
        storeService.updateStore(store);
        store.setNoTeleponToko(storeService.addStoreCode(store));
        model.addAttribute("store_code", store.getNoTeleponToko());
        model.addAttribute("store", store);
        return "update-store";
    }

    
    @GetMapping("/store/delete/{id}")
    public String deleteStore(
        @PathVariable Long id,
        Model model
    ) {
        StoreModel store = storeService.getStoreById(id);
        model.addAttribute("name", store.getNamaToko());
        if(storeService.jamWaktuTutup(store)){
            storeService.deleteStore(store);
            return "delete-store";
        }
        return "error-page";
    }
}
