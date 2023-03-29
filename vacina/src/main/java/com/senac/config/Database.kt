package com.senac.config;

import org.hibernate.cfg.Environment
import java.util.Optional
import java.util.logging.Level
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class Database {
    companion object{
        fun createEntityManager(): EntityManagerFactory{
            val mapConfigHibernete = HashMap<String,String>();
            val listEnv = System.getenv();
            mapConfigHibernete[Environment.URL] = Optional.ofNullable(listEnv["DATABASE_URL"]).orElseThrow();
            mapConfigHibernete[Environment.USER] = Optional.ofNullable(listEnv["DATABASE_USERNAME"]).orElseThrow();
            mapConfigHibernete[Environment.PASS] = Optional.ofNullable(listEnv["DATABASE_PASSWORD"]).orElseThrow();
            mapConfigHibernete[Environment.DIALECT] = Optional.ofNullable(listEnv["DIALECT"]).orElseThrow();
            mapConfigHibernete[Environment.FORMAT_SQL] = "true";
            mapConfigHibernete[Environment.SHOW_SQL] = "false";
            mapConfigHibernete[Environment.CURRENT_SESSION_CONTEXT_CLASS] = "thread";
            mapConfigHibernete[Environment.HBM2DDL_AUTO] = "update";
            java.util.logging.Logger.getLogger("org.hibernate").level = Level.WARNING;
            return Persistence.createEntityManagerFactory("main",mapConfigHibernete)
        }

    }
}


