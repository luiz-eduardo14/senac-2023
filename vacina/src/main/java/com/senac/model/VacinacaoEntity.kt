package com.senac.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "vacinacao", schema = "vacinacao", catalog = "")
class VacinacaoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VACINACAO", nullable = false)
    var idVacinacao = 0

    @Basic
    @Column(name = "ID_PESSOA", nullable = false)
    var idPessoa = 0

    @Basic
    @Column(name = "ID_VACINA", nullable = false)
    var idVacina = 0

    @Basic
    @Column(name = "REACAO", nullable = false)
    var reacao = 0

    @Basic
    @Column(name = "DT_APLICACAO", nullable = true, length = 10)
    var dtAplicacao: String? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as VacinacaoEntity
        return idVacinacao == that.idVacinacao && idPessoa == that.idPessoa && idVacina == that.idVacina && reacao == that.reacao && dtAplicacao == that.dtAplicacao
    }

    override fun hashCode(): Int {
        return Objects.hash(idVacinacao, idPessoa, idVacina, reacao, dtAplicacao)
    }
}
