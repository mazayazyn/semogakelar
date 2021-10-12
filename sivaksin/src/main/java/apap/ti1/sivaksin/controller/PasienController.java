package apap.ti1.sivaksin.controller;
import apap.ti1.sivaksin.model.FaskesModel;
import apap.ti1.sivaksin.model.PasienModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import apap.ti1.sivaksin.service.FaskesService;
import apap.ti1.sivaksin.service.PasienService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PasienController {
    @Qualifier("pasienServiceImpl")
    @Autowired
    PasienService pasienService;

    @Qualifier("faskesServiceImpl")
    @Autowired
    FaskesService faskesService;

    @GetMapping("/pasien/add/{idFaskes}")
    public String addPasienForm(
            @PathVariable Long idFaskes,
            Model model
    ) {
        FaskesModel faskes = faskesService.getFaskesByIdFaskes(idFaskes);
        model.addAttribute("listFaskes", Arrays.asList(faskes));
        return "form-add-pasien";
    }

    @PostMapping("/pasien/add")
    public String addPasienSubmit(
            @ModelAttribute("pasien") PasienModel pasien,
            Model model
    ){
        pasienService.addPasien(pasien);
//        model.addAttribute("idFaskes", pasien.getListFaskes().getIdFaskes());

        model.addAttribute("namaPasien", pasien.getNamaPasien());
        model.addAttribute("idFaskes", pasien.getListFaskes());
        return "add-pasien";
    }


//    @PostMapping("/pasien/add")
//    public String addPasienSubmit(
//            @ModelAttribute PasienModel pasien,
//            Model model
//    ){
//        pasienService.addPasien(pasien);
//        model.addAttribute("idPasien", pasien.getIdPasien());
//        return "add-pasien";
//    }

//    @GetMapping("/pasien/update/{idPasien}")
//    public String updatePasienForm(
//            @PathVariable Long idPasien,
//            Model model
//    ) {
//        PasienModel pasien = pasienService.getPasienByIdPasien(idPasien);
//        model.addAttribute("pasien", pasien);
//        return "form-update-pasien";
//    }
//
//    @PostMapping("/pasien/update")
//    public String updatePasienSubmit(
//            @ModelAttribute PasienModel pasien,
//            Model model
//    ) {
//        pasienService.updatePasien(pasien);
//        model.addAttribute("idPasien", pasien.getIdPasien());
////        model.addAttribute("id", pasien.getId().getIdPasien());
//        return "update-pasien";
//    }

//    @PostMapping("/pasien/delete")
//    public String deletePasienSubmit(
//            @ModelAttribute FaskesModel faskes,
//            Model model
//    ) {
//        model.addAttribute("id", faskes.getId());
//        for (PasienModel pasien : faskes.getListPasien()){
//            pasienService.deletePasien(pasien);
//        }
//        return "delete-pasien";
//    }
}


