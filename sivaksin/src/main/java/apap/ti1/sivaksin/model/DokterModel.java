package apap.ti1.sivaksin.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "dokter")
public class DokterModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDokter;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String namaDokter;

    @NotNull
    @Size(max = 18)
    @Column(nullable = false)
    private String nip;

    @NotNull
    @Size(max = 13)
    @Column(nullable = false)
    private String nomorTelepon;

//    @ManyToMany
//    @JoinTable(
//            name = "dokter-pasien",
//            joinColumns = @JoinColumn(name = "id_dokter"),
//            inverseJoinColumns = @JoinColumn(name = "id_pasien"))
//    List<DokterModel> listPasien;

//    @ManyToMany(mappedBy = "listPasien")
//    private List<DokterModel> listDokter;

}
