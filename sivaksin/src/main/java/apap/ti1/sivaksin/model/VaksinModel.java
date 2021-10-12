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

@Data
@NoArgsConstructor
@Entity
@Table(name = "vaksin")
@EqualsAndHashCode

public class VaksinModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVaksin;

    @NotNull
    @Column(nullable = false)
    private double efikasi;

    @NotNull
    @Column(nullable = false)
    @Size(max = 50)
    private String jenisVaksin;

    @NotNull
    @Column(nullable = false)
    @Size(max = 50)
    private String asalNegara;

//    @OneToMany(mappedBy = "vaksin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<FaskesModel> listFaskes;

}
