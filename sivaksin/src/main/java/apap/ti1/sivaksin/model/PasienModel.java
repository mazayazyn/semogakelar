package apap.ti1.sivaksin.model;
import apap.ti1.sivaksin.JenisKelaminEnum;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pasien")
@EqualsAndHashCode

public class PasienModel implements Serializable{
    @ManyToMany
    @JoinTable(
            name = "pasien_faskes",
            joinColumns = @JoinColumn(name = "id_pasien"),
            inverseJoinColumns = @JoinColumn(name = "id_faskes"))
    private List<FaskesModel> listFaskes;

    @ManyToMany
    @JoinTable(
            name = "dokter_pasien",
            joinColumns = @JoinColumn(name = "id_pasien"),
            inverseJoinColumns = @JoinColumn(name = "id_dokter"))
    private List<DokterModel> listDokter;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPasien;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String namaPasien;

    @NotNull
    @Size(max = 16)
    @Column(nullable = false)
    private String nik;

    @NotNull
    @Size(max = 13)
    @Column(nullable = false)
    private String nomorTelepon;

    @NotNull
    @Column(nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Column(nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Column(nullable = false)
    @Size(max = 255)
    private String tempatLahir;

    @NotNull
    @Column(nullable = false)
    @Size(max = 255)
    private String pekerjaan;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_faskes", referencedColumnName = "idFaskes")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private FaskesModel faskes;
//
//    public FaskesModel getFaskesModel() {
//        return faskes;
//    }
//    public void setFaskesModel(FaskesModel faskesModel) {
//        this.faskes = faskesModel;
//    }


//    @ManyToOne
//    @JoinColumn(name = "id_faskes", referencedColumnName = "idFaskes")
//    private FaskesModel faskes;

}

