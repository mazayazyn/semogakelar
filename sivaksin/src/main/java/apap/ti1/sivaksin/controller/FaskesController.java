package apap.ti1.sivaksin.controller;
import apap.ti1.sivaksin.model.FaskesModel;
import apap.ti1.sivaksin.repository.FaskesRepository;
import apap.ti1.sivaksin.service.FaskesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class FaskesController {
    @Qualifier("faskesServiceImpl")
    @Autowired
    private FaskesService faskesService;

    @Autowired
    private FaskesRepository faskesRepository;

    @GetMapping("faskes/viewall")
    public String getFaskesList(Model model) {
        List<FaskesModel> listFaskes = faskesService.getFaskesList();
        model.addAttribute("listFaskes", listFaskes);
        return "viewall-faskes";
    }

    @GetMapping("/faskes/add")
    public String addFaskesForm(Model model) {
        model.addAttribute("faskes", new FaskesModel());
        return "form-add-faskes";
    }

    @PostMapping("/faskes/add")
    public String addFaskesSubmit(
            @ModelAttribute FaskesModel faskes,
            Model model
    ) {
        faskesService.addFaskes(faskes);
        model.addAttribute("idFaskes", faskes.getIdFaskes());
        return "add-faskes";
    }

    @RequestMapping("/faskes/view")
    public String detailFaskes(
            @RequestParam(value = "idFaskes") Long idFaskes,
            Model model
    ) {
        FaskesModel faskesModel = faskesService.getFaskesByIdFaskes(idFaskes);
        model.addAttribute("faskes", faskesModel);

        return "view-faskes";
    }

    @GetMapping ("/faskes/delete/{idFaskes}")
    public String deleteFaskes(
            @PathVariable Long idFaskes,
            Model model
    ) {
        model.addAttribute("idFaskes", idFaskes);
        faskesService.deleteFaskes(faskesService.getFaskesByIdFaskes(idFaskes));
        return "delete-faskes";
    }

    @GetMapping("/faskes/update/{idFaskes}")
    public String updateFaskesForm(
            @PathVariable Long idFaskes,
            Model model
    ) {
        FaskesModel faskes = faskesService.getFaskesByIdFaskes(idFaskes);
        model.addAttribute("faskes", faskes);
        return "form-update-faskes";
    }

    @PostMapping("/faskes/update")
    public String updateFaskesSubmit(
            @ModelAttribute FaskesModel faskes,
            Model model
    ) {
        faskesService.updateFaskes(faskes);
        model.addAttribute("idFaskes", faskes.getIdFaskes());
        return "update-faskes";
    }
}
//    @GetMapping("/{id}")
//    public FaskesModel get(@PathVariable Integer id) {
//        return faskesService.get(id);
//    }
