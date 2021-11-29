package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Paciente")
@Builder
@Table(name = "Paciente", schema = "dbo")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @NotBlank
    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    private String telefone;

    private String sexo;

    @Column(name = "numero_carteira_sus")
    private String numeroCarteiraSus;

    @Transient
    private String peso = "";

    @Transient
    private Double altura = 0.0;

    @Transient
    private Boolean isVirgem = false;

    @Transient
    private Boolean isFumante = false;

    @Transient
    private BloodTypeEnum tipoSanguineo = BloodTypeEnum.DEFAULT;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PacienteHasDoencas> doencas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PacienteHasRemedios> remedios;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PacienteHasDeficiencia> deficiencias;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PacienteHasAlergia> alergias;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PacienteHasAtividade> atividades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paciente paciente = (Paciente) o;

        return Objects.equals(idPaciente, paciente.idPaciente);
    }

    @Override
    public int hashCode() {
        return 38015519;
    }
}
