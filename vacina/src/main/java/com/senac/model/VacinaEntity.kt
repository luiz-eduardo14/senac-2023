package com.senac.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "vacina", schema = "vacinacao", catalog = "")
class VacinaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VACINA", nullable = false)
    var idVacina = 0

    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    var nome: String? = null

    @Basic
    @Column(name = "PAIS_DE_ORIGEM", nullable = false, length = 200)
    var paisDeOrigem: String? = null

    @Basic
    @Column(name = "ESTAGIO_DA_PESQUISA", nullable = false)
    var estagioDaPesquisa = 0

    @Basic
    @Column(name = "DT_INICIO_PESQUISA", nullable = true, length = 10)
    var dtInicioPesquisa: LocalDate? = null

    @OneToOne
    @JoinColumn(name = "ID_PESQUISADOR_RESPONSAVEL", referencedColumnName = "ID_PESSOA")
    var pesquisador: PessoaEntity? = null

    constructor()
    constructor(
        nome: String?,
        paisDeOrigem: String?,
        estagioDaPesquisa: Int,
        dtInicioPesquisa: LocalDate?,
        pesquisador: PessoaEntity?
    ) {
        this.nome = nome
        this.paisDeOrigem = paisDeOrigem
        this.estagioDaPesquisa = estagioDaPesquisa
        this.dtInicioPesquisa = dtInicioPesquisa
        this.pesquisador = pesquisador
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as VacinaEntity
        return idVacina == that.idVacina && estagioDaPesquisa == that.estagioDaPesquisa && pesquisador == that.pesquisador && nome == that.nome && paisDeOrigem == that.paisDeOrigem && dtInicioPesquisa == that.dtInicioPesquisa
    }

    override fun hashCode(): Int {
        return Objects.hash(idVacina, nome, paisDeOrigem, estagioDaPesquisa, dtInicioPesquisa, pesquisador)
    }
}
