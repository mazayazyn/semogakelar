package apap.ti1.sivaksin.repository;

import apap.ti1.sivaksin.model.FaskesModel;
import apap.ti1.sivaksin.model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface FaskesRepository extends JpaRepository<FaskesModel, Long> {
    Optional<FaskesModel> findFaskesByIdFaskes(Long idFaskes);
    Optional<FaskesModel> findFaskesByNamaFaskes(String namaFaskes);
    Optional<FaskesModel> findFaskesByListPasien(List<PasienModel> listPasien);
}