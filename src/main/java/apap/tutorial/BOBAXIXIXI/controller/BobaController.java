package apap.tutorial.BOBAXIXIXI.controller;

import apap.tutorial.BOBAXIXIXI.model.ToppingModel;
import apap.tutorial.BOBAXIXIXI.service.Boba_TeaService;
import apap.tutorial.BOBAXIXIXI.service.ToppingService;

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
public class BobaController {
    @Qualifier("boba_TeaServiceImpl")
    @Autowired
    private Boba_TeaService boba_TeaService;

    @Qualifier("toppingServiceImpl")
    @Autowired
    private ToppingService toppingService;

    @GetMapping("/boba")
    public String listBoba(Model model){
        List<Boba_TeaModel> listBoba = boba_TeaService.getBoba_TeaList();
        model.addAttribute("listBoba",listBoba);
        List<ToppingModel> listToppingModels = toppingService.getToppingList();
        model.addAttribute("listTopping", listToppingModels);
        return "viewall-Boba";
    }

    @GetMapping("/boba/add")
    public String addBobaForm(Model model){
        model.addAttribute("boba_tea", new Boba_TeaModel());
        List<ToppingModel> listToppingModels = toppingService.getToppingList();
        model.addAttribute("listTopping", listToppingModels);
        return "form-add-boba";
    }

    @PostMapping(value = "/boba/add", params = "save")
    public String saveBoba(
        @ModelAttribute Boba_TeaModel boba_tea,
        Model model,
        @RequestParam("topping") String topping
    ){
        model.addAttribute("name", boba_tea.getNamaBoba());
        model.addAttribute("id_boba", boba_tea.getId());
        boba_TeaService.addBoba(boba_tea);
        return "add-boba";
    }

    @GetMapping("/boba/update/{id}")
    public String updateBobaForm(
        @PathVariable Long id,
        Model model
    ) {
        Boba_TeaModel boba_tea = boba_TeaService.getBoba_TeaById(id);
        model.addAttribute("boba_tea", boba_tea);
        List<ToppingModel> listToppingModels = toppingService.getToppingList();
        model.addAttribute("listTopping", listToppingModels);
        return "form-update-boba";
    }

    @PostMapping("/boba/update")
    public String updateBobaSubmit(
        @ModelAttribute Boba_TeaModel boba_tea,
        Model model
    ) {
        boba_TeaService.updateBoba(boba_tea);
        model.addAttribute("boba_tea", boba_tea);
        model.addAttribute("name", boba_tea.getNamaBoba());
        return "update-boba";
    }

    
    @GetMapping("/boba/delete/{id}")
    public String deleteStore(
        @PathVariable Long id,
        Model model
    ) {
        Boba_TeaModel boba_tea = boba_TeaService.getBoba_TeaById(id);
        model.addAttribute("name", boba_tea.getNamaBoba());
        boba_TeaService.deleteBoba(boba_tea);
        return "delete-boba";
    }
}
