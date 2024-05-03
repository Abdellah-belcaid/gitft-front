package ma.fsa.appwebcadeaux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReduction;
    private int pourcentage;
    private Date debutReduction;
    private Date finReduction;

    @OneToMany(mappedBy = "reduction",fetch=FetchType.EAGER)
    private List<Article> articles;

}
