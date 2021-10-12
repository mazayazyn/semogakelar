package apap.ti1.sivaksin.service;
import apap.ti1.sivaksin.model.FaskesModel;
import apap.ti1.sivaksin.model.PasienModel;

import java.util.List;

public interface PasienService {
    void addPasien(PasienModel pasien);

    void updatePasien(PasienModel pasien);

    void deletePasien(PasienModel pasien);

    PasienModel getPasienByIdPasien(Long idPasien);

    List<PasienModel> getPasienList();


}
