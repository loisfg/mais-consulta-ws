package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostSameRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostSameRemedioImpl implements PostSameRemedio {

    @Autowired
    RemedioRepository remedioRepository;

    @Override
    public void execute() {
        Set<Remedio> remedios = Set.of(
//                new Remedio(1, "Abacavir", false),
//                new Remedio(2, "Abaloparatida", true),
//                new Remedio(3, "Abatacepte", false),
//                new Remedio(4, "Abciximabe", false),
//                new Remedio(5, "Acamprosato", false),
//                new Remedio(6, "Acarbose", false),
//                new Remedio(7, "Acebutolol", false),
//                new Remedio(8, "Acetazolamida", false),
//                new Remedio(9, "Acetilcisteína", false),
//                new Remedio(10, "Acetilprocainamida", false)
//                new Remedio(null, "Acitretina", false),
//                new Remedio(null, "Aclidínio", false),
//                new Remedio(null, "Aciclovir", false),
//                new Remedio(null, "Adalimumabe", false),
//                new Remedio(null, "Adapaleno", false),
//                new Remedio(null, "Adefovir", false),
//                new Remedio(null, "Adenosina", false),
//                new Remedio(null, "Aflibercepte", false),
//                new Remedio(null, "Agalsidase beta", false),
//                new Remedio(null, "Albendazol", false),
//                new Remedio(null, "Albiglutida", false),
//                new Remedio(null, "Albuterol", false),
//                new Remedio(null, "Alcaftadina", false),
//                new Remedio(null, "Aldesleucina", false),
//                new Remedio(null, "Alectinibe", false),
//                new Remedio(null, "Alentuzumabe", false),
//                new Remedio(null, "Alendronato", false),
//                new Remedio(null, "Alfuzosina", false),
//                new Remedio(null, "Alirocumabe", false),
//                new Remedio(null, "Alisquireno", false),
//                new Remedio(null, "Alopurinol", false),
//                new Remedio(null, "Almotriptana", false),
//                new Remedio(null, "Alogliptina", false),
//                new Remedio(null, "Alosetrona", false),
//                new Remedio(null, "Alprazolam", false),
//                new Remedio(null, "Alprostadil", false),
//                new Remedio(null, "Alteplase", false),
//                new Remedio(null, "Amantadina", false),
//                new Remedio(null, "Ambrisentana", false),
//                new Remedio(null, "Amifostina", false),
//                new Remedio(null, "Amicacina", false),
//                new Remedio(null, "Amilorida", false),
//                new Remedio(null, "Aminofilina", false),
//                new Remedio(null, "Amiodarona", false),
//                new Remedio(null, "Amitriptilina", false),
//                new Remedio(null, "Anlodipino", false),
//                new Remedio(null, "Amobarbital", false),
//                new Remedio(null, "Amoxapina", false),
//                new Remedio(null, "Amoxicilina", false),
//                new Remedio(null, "Amoxicilina/clavulanato", false),
//                new Remedio(null, "Anfetamina", false),
//                new Remedio(null, "Anfotericina B", false),
//                new Remedio(null, "Ampicilina", false),
//                new Remedio(null, "Ampicilina/sulbactam", false),
//                new Remedio(null, "Anagrelida", false),
//                new Remedio(null, "Anacinra", false),
//                new Remedio(null, "Anastrozol", false),
//                new Remedio(null, "Andexanet alfa", false),
//                new Remedio(null, "Andexxa", false),
//                new Remedio(null, "Anidulafungina", false),
//                new Remedio(null, "Antralina", false),
//                new Remedio(null, "Apalutamida", false),
//                new Remedio(null, "Apixabana", false),
//                new Remedio(null, "Apomorfina", false),
//                new Remedio(null, "Apraclonidina", false),
//                new Remedio(null, "Apremilaste", false),
//                new Remedio(null, "Aprepitanto", false),
//                new Remedio(null, "Arformoterol", false),
//                new Remedio(null, "Argatrobana", false),
//                new Remedio(null, "Arginina", false),
//                new Remedio(null, "Aripiprazol", false),
//                new Remedio(null, "Armodafinila", false),
//                new Remedio(null, "Arteméter/lumefantrina", false),
//                new Remedio(null, "Artesunato", false),
//                new Remedio(null, "Asparaginase", false),
//                new Remedio(null, "Aspirina", false),
//                new Remedio(null, "Atazanavir", false),
//                new Remedio(null, "Atracúrio", false),
//                new Remedio(null, "Atenolol", false),
//                new Remedio(null, "Atezolizumabe", false),
//                new Remedio(null, "Atomoxetina", false),
//                new Remedio(null, "Atorvastatina", false),
//                new Remedio(null, "Atovaquona", false),
//                new Remedio(null, "Atracúrio", false),
//                new Remedio(null, "Atropina", false),
//                new Remedio(null, "Auranofina", false),
//                new Remedio(null, "Avanafila", false),
//                new Remedio(null, "Avelumabe", false),
//                new Remedio(null, "Axicabtagene ciloleucel", false),
//                new Remedio(null, "Azacitidina", false),
//                new Remedio(null, "Azatioprina", false),
//                new Remedio(null, "Azelastina", false),
//                new Remedio(null, "Azilsartana", false),
//                new Remedio(null, "Azitromicina", false),
//                new Remedio(null, "Aztreonam", false),
//                new Remedio(null, "Antitoxina botulínica", false),
//                new Remedio(null, "Alfadarbepoetina", false),
//                new Remedio(null, "Alfadornase", false),
//                new Remedio(null, "Alfaepoetina", false),
//                new Remedio(null, "Acetato de glatirâmero", false),
//                new Remedio(null, "Alfainterferona 2b", false),
//                new Remedio(null, "Alfainterferona n3", false),
//                new Remedio(null, "Azul de metileno", false),
//                new Remedio(null, "Alfapeginterferona 2a", false),
//                new Remedio(null, "Alfapeginterferona 2b", false),
//                new Remedio(null, "Alfaporactanto", false)
        );

        remedioRepository.saveAll(remedios);
    }
}
