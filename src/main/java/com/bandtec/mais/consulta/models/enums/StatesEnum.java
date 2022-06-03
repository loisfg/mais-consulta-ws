package com.bandtec.mais.consulta.models.enums;

public enum StatesEnum {
    AMAZONAS("Amazonas", "AM", "Manaus"),
    ALAGOAS("Alagoas", "AL", "Maceió"),
    ACRE("Acre", "AC", "Rio Branco"),
    AMAPA("Amapá", "AP", "Macapá"),
    BAHIA("Bahia", "BA", "Salvador"),
    PARA("Pará", "PA", "Belém"),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
    GOIAS("Goiás", "GO", "Goiânia"),
    MARANHAO("Maranhão", "MA", "São Luís"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
    TOCANTINS("Tocantins", "TO", "Palmas"),
    PIAUI("Piauí", "PI", "Teresina"),
    SAO_PAULO("São Paulo", "SP", "São Paulo"),
    RONDONIA("Rondônia", "RO", "Porto Velho"),
    RORAIMA("Roraima", "RR", "Boa Vista"),
    PARANA("Paraná", "PR", "Curitiba"),
    CEARA("Ceará", "CE", "Fortaleza"),
    PERNAMBUCO("Pernambuco", "PE", "Recife"),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis"),
    PARAIBA("Paraíba", "PB", "João Pessoa"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    SERGIPE("Sergipe", "SE", "Aracaju"),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília");

    private final String name;
    private final String acronym;
    private final String capital;

    /**
     * Construtor do enum
     *
     * @param name    nome da unidade da federação completo
     * @param acronym sigla da unidade da federação
     * @param capital nome da capital da unidade da federação
     */
    StatesEnum(final String name, final String acronym, final String capital) {
        this.name = name;
        this.acronym = acronym;
        this.capital = capital;
    }

    /**
     * Converte a partir do nome da Unidade da Federacao, para o respectivo enum.
     *
     * @param ufName o nome da Unidade da Federação. Exemplo: "São Paulo"
     * @return o enum da Unidade da Federação
     * @throws IllegalArgumentException caso não ache o enum pelo nome da UF
     */
    public static StatesEnum fromUF(final String ufName) {
        for (final StatesEnum uf : StatesEnum.values()) {
            if (uf.name.equalsIgnoreCase(ufName)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(ufName);
    }

    /**
     * Converte a partir da Sigla da UF no parâmetro, para o enum da Unidade da Federação.
     *
     * @param acronym da Unidade da Federação. Exemplo: "MG"
     * @return a Unidade da Federação
     * @throws IllegalArgumentException caso a sigla da UF não exista
     */
    public static StatesEnum fromSigla(final String acronym) {
        for (final StatesEnum uf : StatesEnum.values()) {
            if (uf.acronym.equalsIgnoreCase(acronym)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(acronym);
    }

    /**
     * Converte, a partir do nome da capital da UF, para o Enum.
     *
     * @param capital da Unidade da Federação. Exemplo: "Porto Alegre"
     * @return a Unidade da Federacao com a capital passada no parâmetro
     * @throws IllegalArgumentException caso o nome da capital não exista
     */
    public static StatesEnum fromCapital(final String capital) {
        for (final StatesEnum uf : StatesEnum.values()) {
            if (uf.capital.equalsIgnoreCase(capital)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(capital);
    }

    /**
     * Obtém a sigla da UF
     *
     * @return a sigla da UF
     */
    public String acronym() {
        return this.acronym;
    }

    /**
     * Nome completo da UF
     *
     * @return nome completo da UF
     */
    public String ufName() {
        return this.name;
    }

    /**
     * Nome da capital da UF
     *
     * @return nome da capital da UF
     */
    public String capital() {
        return this.capital;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstadosEnum{");
        sb.append("nome='").append(name).append('\'');
        sb.append(", sigla='").append(acronym).append('\'');
        sb.append(", capital='").append(capital).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
