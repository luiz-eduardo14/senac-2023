package dao

import config.Database
import model.Person

class PersonDAO {

    fun getPersonById(id: Int): Person? {
        val connection = Database.getConnection();
        try {
            val statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            val result = statement.executeQuery();
            return if(result.next()){
                val person = Person();
                person.id = result.getInt("id");
                person.name = result.getString("name");
                person.age = result.getInt("age").toShort();
                person.cpf = result.getString("cpf");
                person.dateOfBirth = result.getDate("dateOfBirth").toLocalDate();
                person;
            }else{
                null;
            }
        } catch (e: Exception) {
            e.printStackTrace();
        } finally {
            connection?.close()
        }
        return null;
    }
}