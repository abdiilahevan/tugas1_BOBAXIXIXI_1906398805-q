package apap.tutorial.BOBAXIXIXI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter 
@Getter
@Entity
@Table(name = "boba_tea")

public class Boba_TeaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String namaBoba;

    @NotNull
    @Column(name = "price", nullable = false)
    private int hargaBoba;

    @NotNull
    @Column(name = "size", nullable = false)
    private int ukuranBoba;

    @NotNull
    @Column(name = "ice_level", nullable = false)
    private int esBoba;

    @NotNull
    @Column(name = "sugar_level", nullable = false)
    private int gulaBoba;

    //many to one ke topping
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_topping", referencedColumnName = "id", nullable = true)
    private ToppingModel topping;

    //one to many ke boba store
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boba_tea", cascade = CascadeType.ALL)
    private List<Store_Boba_TeaModel> storeBobaRelation;
}
