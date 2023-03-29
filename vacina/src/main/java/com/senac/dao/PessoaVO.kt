package com.senac.dao

import com.senac.model.PessoaEntity
import java.sql.SQLException
import javax.persistence.EntityManager

class PessoaVO {

    private val entityManager: EntityManager;

    constructor(entityManager: EntityManager){
        this.entityManager = entityManager;
    }

    fun getById(id: Int): PessoaEntity?{
        return this.entityManager.find(PessoaEntity::class.java,id)
    }

    fun insert(pessoa: PessoaEntity): PessoaEntity {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.merge(pessoa)
        }catch (exception: SQLException){
            throw SQLException("Failed in save person with name ${pessoa.nome} and cpf ${pessoa.cpf}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }

    fun update(pessoa: PessoaEntity): PessoaEntity {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.merge(pessoa)
        }catch (exception: SQLException){
            throw SQLException("Failed in save person with name ${pessoa.nome} and cpf ${pessoa.cpf}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }

    fun remove(pessoa: PessoaEntity) {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.remove(pessoa);
        }catch (exception: SQLException){
            throw SQLException("Failed in remove person with name ${pessoa.nome} and cpf ${pessoa.cpf}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }
    fun getAll(): MutableList<PessoaEntity> {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.createQuery("select table from PessoaEntity table").resultList as MutableList<PessoaEntity>
        }catch (exception: SQLException){
            throw SQLException("Failed in get all persons")
        }finally {
            this.entityManager.transaction.commit();
        }
    }
}