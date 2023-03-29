package com.senac.dao

import com.senac.model.VacinaEntity
import java.sql.SQLException
import javax.persistence.EntityManager

class VacinaVO {

    private val entityManager: EntityManager;

    constructor(entityManager: EntityManager){
        this.entityManager = entityManager;
    }

    fun getById(id: Int): VacinaEntity?{
        return this.entityManager.find(VacinaEntity::class.java,id)
    }

    fun insert(vacina: VacinaEntity): VacinaEntity {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.merge(vacina)
        }catch (exception: SQLException){
            throw SQLException("Failed in save vacina with name ${vacina.nome}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }

    fun update(vacina: VacinaEntity): VacinaEntity {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.merge(vacina)
        }catch (exception: SQLException){
            throw SQLException("Failed in save vacina with name ${vacina.nome}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }

    fun remove(vacina: VacinaEntity) {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.remove(vacina);
        }catch (exception: SQLException){
            throw SQLException("Failed in remove vacina with name ${vacina.nome}")
        }finally {
            this.entityManager.transaction.commit();
        }
    }
    fun getAll(): MutableList<VacinaEntity> {
        this.entityManager.transaction.begin();
        try {
            return this.entityManager.createQuery("select table from VacinaEntity table").resultList as MutableList<VacinaEntity>
        }catch (exception: SQLException){
            throw SQLException("Failed in get all persons")
        }finally {
            this.entityManager.transaction.commit();
        }
    }
}