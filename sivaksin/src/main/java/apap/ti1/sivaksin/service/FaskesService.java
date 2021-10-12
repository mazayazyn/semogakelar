package apap.ti1.sivaksin.service;

//import apap.ti1.sivaksin.model.PasienModel;
import apap.ti1.sivaksin.model.FaskesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaskesService {
    void addFaskes(FaskesModel faskes);
    List<FaskesModel> getFaskesList();
    FaskesModel getFaskesByIdFaskes(Long idFaskes);
    FaskesModel getFaskesByNamaFaskes(String namaFaskes);
    void deleteFaskes(FaskesModel faskes);
    void updateFaskes(FaskesModel faskes);
}
//
//    @Autowired
//    private FaskesRepository faskesRepository;
//    public List<FaskesModel> getFaskesList(){
//        return faskesRepository.findAll();
//    }
//
//    public FaskesModel get(Integer id){
//        return faskesRepository.findById(id).orElseThrow(RuntimeException::new);
//    }
