package view

import config.ViewConst
import interfaces.RunProgram
import interfaces.View
import javax.persistence.EntityManagerFactory

@View(value = ViewConst.PERSON)
class PersonView: RunProgram {
    override fun run(factory: EntityManagerFactory): String? {
        return null;
    }

}