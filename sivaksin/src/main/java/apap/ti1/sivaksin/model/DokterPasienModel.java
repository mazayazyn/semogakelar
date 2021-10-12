package apap.ti1.sivaksin.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "dokter_pasien")
public class DokterPasienModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String batchId;

    @NotNull
    @Column(nullable = false)
    private Date waktuSuntik;

    @NotNull
    @Size(max = 20)
    @Column(nullable = false)
    private Long idFaskes;
}
