package apap.ti1.sivaksin.service;
import apap.ti1.sivaksin.model.FaskesModel;
import apap.ti1.sivaksin.repository.FaskesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FaskesServiceImpl implements FaskesService {

    @Autowired
    FaskesRepository faskesRepository;

    @Override
    public void addFaskes(FaskesModel faskes) {
        faskesRepository.save(faskes);
    }

    @Override
    public List<FaskesModel> getFaskesList() {
        return faskesRepository.findAll();
    }

    @Override
    public FaskesModel getFaskesByIdFaskes(Long idFaskes) {
        Optional<FaskesModel> faskes = faskesRepository.findFaskesByIdFaskes(idFaskes);
        if (faskes.isPresent()) {
            return faskes.get();
        }
        return null;
    }

    @Override
    public FaskesModel getFaskesByNamaFaskes(String namaFaskes) {
        Optional<FaskesModel> faskes = faskesRepository.findFaskesByNamaFaskes(namaFaskes);
        if (faskes.isPresent()) {
            return faskes.get();
        }
        return null;
    }

    @Override
    public void deleteFaskes(FaskesModel faskes) {
        faskesRepository.delete(faskes);
    }

    @Override
    public void updateFaskes(FaskesModel faskes) {
        faskesRepository.save(faskes);
    }
}