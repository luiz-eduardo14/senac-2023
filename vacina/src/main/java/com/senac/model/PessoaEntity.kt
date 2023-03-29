package com.senac.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pessoa", schema = "vacinacao", catalog = "")
class PessoaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PESSOA", nullable = false)
    var idPessoa = 0

    @Basic
    @Column(name = "NOME", nullable = false, length = 200)
    var nome: String? = null

    @Basic
    @Column(name = "DT_NASCIMENTO", nullable = true, length = 10)
    var dtNascimento: LocalDate? = null

    @Basic
    @Column(name = "SEXO", nullable = false, length = 1)
    var sexo: String? = null

    @Basic
    @Column(name = "CPF", nullable = true, length = 14)
    var cpf: String? = null

    @Basic
    @Column(name = "TIPO", nullable = false)
    var tipo = 0
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as PessoaEntity
        return idPessoa == that.idPessoa && tipo == that.tipo && nome == that.nome && dtNascimento == that.dtNascimento && sexo == that.sexo && cpf == that.cpf
    }

    constructor()
    constructor(nome: String?, dtNascimento: LocalDate?, sexo: String?, cpf: String?, tipo: Int) {
        this.nome = nome
        this.dtNascimento = dtNascimento
        this.sexo = sexo
        this.cpf = cpf
        this.tipo = tipo
    }


    override fun hashCode(): Int {
        return Objects.hash(idPessoa, nome, dtNascimento, sexo, cpf, tipo)
    }
}
