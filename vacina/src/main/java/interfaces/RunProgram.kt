package interfaces;

import javax.persistence.EntityManagerFactory

interface RunProgram {
    fun run(factory: EntityManagerFactory): String?;
}