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
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter 
@Getter
@Entity
@Table(name = "store")
public class StoreModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=255)
    @Column(name = "name", nullable = false)
    private String namaToko;

    @NotNull
    @Size(max=255)
    @Column(name = "address", nullable = false)
    private String alamatToko;

    @NotNull
    @Size(max=10)
    @Column(name="store_code", unique=true, nullable = false)
    private String noTeleponToko;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    //one to one dari store ke manager
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    private ManagerModel manager;

    //ke boba store
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
    private List<Store_Boba_TeaModel> storeBobaRelation;
}
