package com.senac.view

import com.senac.config.ViewConst
import com.senac.interfaces.RunProgram
import com.senac.interfaces.View
import javax.persistence.EntityManagerFactory

@View(value = ViewConst.PERSON)
class PersonView: RunProgram {
    override fun run(factory: EntityManagerFactory): ViewConst?
    {
        return null;
    }

}