package com.senac

import com.senac.config.Database
import com.senac.dao.PessoaVO
import com.senac.dao.VacinaVO
import com.senac.model.PessoaEntity
import com.senac.model.VacinaEntity
import java.time.LocalDate
import java.util.Arrays

// executable for test crud of application

fun main(args: Array<String>) {
    val factory = Database.createEntityManager();

    val entityManager = factory.createEntityManager()

    val date = LocalDate.of(2003,9,10)
    val personTest = PessoaEntity("luiz", date, "M", "123.123.123-01", 2)
    val personDao = PessoaVO(entityManager)
    val personPersist = personDao.insert(personTest)
    val personTestOfPersist = personDao.getById(personPersist.idPessoa)

    val vacinaDao = VacinaVO(entityManager)

    val vacinaTest = VacinaEntity("covid", "Brasil", 2, date, personTestOfPersist)

    vacinaDao.insert(vacinaTest)

    println(Arrays.toString(vacinaDao.getAll().stream().map { "nome: ${it.nome} and stage: ${it.estagioDaPesquisa}" }.toArray()))

    entityManager.close();
    factory.close();
}