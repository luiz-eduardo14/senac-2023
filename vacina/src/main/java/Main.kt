import config.Database
import model.Person
import model.Sex
import java.time.LocalDate
import javax.xml.crypto.Data

fun main(args: Array<String>) {
    val factory = Database.entityManager
    val entityManager = factory.createEntityManager()
    entityManager.transaction.begin()

    val person = Person()
    person.cpf = "robertosdadpolasp´dlaspdasdas~daçs"
    person.age = 12
    person.name = "lui2"
    person.sex = Sex.MALE
    person.dateOfBirth = LocalDate.now()

    entityManager.merge(person)

    entityManager.transaction.commit()


    entityManager.close()
    factory.close()
}