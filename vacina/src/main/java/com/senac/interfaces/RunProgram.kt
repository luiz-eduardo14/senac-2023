package com.senac.interfaces;

import com.senac.config.ViewConst
import javax.persistence.EntityManagerFactory

interface RunProgram {
    fun run(factory: EntityManagerFactory): ViewConst?;
}