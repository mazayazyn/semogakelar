package apap.ti1.sivaksin.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
@Table(name = "faskes")
public class FaskesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFaskes;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String namaFaskes;

    @NotNull
    @Column(nullable = false)
    private Integer kuota;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String provinsi;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String kabupaten;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime jamMulai;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime jamTutup;

    @NotNull
    @Column(nullable = false)
    private Integer vaksin;

//    @ManyToMany(mappedBy = "listFaskes")
//    private List<PasienModel> listPasien;

//    @ManyToMany(mappedBy = "listFaskes")
//    private List<PasienModel> listPasien;

    @ManyToMany
    @JoinTable(
            name = "pasien-faskes",
            joinColumns = @JoinColumn(name = "id_faskes"),
            inverseJoinColumns = @JoinColumn(name = "id_pasien"))
    List<FaskesModel> listPasien;


    //soon
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "id_vaksin", referencedColumnName = "idVaksin", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private VaksinModel vaksin;



}






