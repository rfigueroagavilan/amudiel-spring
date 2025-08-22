package models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cervezas")
public class CervezaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 50)
    private String nombre;
    
    @NotNull
    private Double alcohol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipos", nullable = false) // crea la FK en la tabla cerveza
    private TipoEntity tipos;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = BarEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bares", joinColumns = @JoinColumn(name = "cerveza_id"), inverseJoinColumns = @JoinColumn(name = "bar_id"))
    private Set<BarEntity> bares;


}
