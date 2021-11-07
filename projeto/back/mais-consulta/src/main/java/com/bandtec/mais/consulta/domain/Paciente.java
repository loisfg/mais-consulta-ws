package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
@ToString(exclude = "usuario")
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    private String telefone;

    private String sexo;

    @Column(name = "numero_carteira_sus")
    private String numeroCarteiraSus;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Doenca> doencas = new HashSet<>();

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Remedio> remedios = new HashSet<>();

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Deficiencia> deficiencias = new HashSet<>();

    @OneToMany(mappedBy = "paciente")
    private Set<PacienteHasAlergia> pacienteAlergias;
}
