DROP SCHEMA if exists vacinacao;
CREATE SCHEMA vacinacao ;

CREATE TABLE vacinacao.pessoa(
                                 ID_PESSOA INT NOT NULL auto_increment PRIMARY KEY,
                                 NOME VARCHAR(200) NOT NULL,
                                 DT_NASCIMENTO varchar(10),
                                 SEXO VARCHAR(1) NOT NULL,
                                 CPF VARCHAR(14),
                                 TIPO INT NOT NULL -- 1.PESQUISADOR 2.VOLUNTARIO 3.GERAL
);

CREATE TABLE vacinacao.vacina(
                                 ID_VACINA INT NOT NULL auto_increment PRIMARY KEY,
                                 NOME VARCHAR(100) NOT NULL,
                                 PAIS_DE_ORIGEM VARCHAR(200) NOT NULL,
                                 ESTAGIO_DA_PESQUISA INT NOT NULL, -- 1.INICIAL 2.TESTES 3.APLIÇÃO EM MASSA
                                 DT_INICIO_PESQUISA varchar(10),
                                 ID_PESQUISADOR_RESPONSAVEL INT NOT NULL,
                                 FOREIGN KEY (ID_PESQUISADOR_RESPONSAVEL) REFERENCES pessoa(ID_PESSOA)
);

CREATE TABLE vacinacao.vacinacao(
                                    ID_VACINACAO INT NOT NULL auto_increment PRIMARY KEY,
                                    ID_PESSOA INT NOT NULL,
                                    ID_VACINA INT NOT NULL,
                                    REACAO INT NOT NULL, -- 1(PÉSSIMA) - 5(ÓTIMA)
                                    DT_APLICACAO varchar(10),
                                    FOREIGN KEY (ID_PESSOA) REFERENCES pessoa(ID_PESSOA),
                                    FOREIGN KEY (ID_VACINA) REFERENCES vacina(ID_VACINA)
);