package model

import java.sql.Date

enum class Sex(s: String) {
    MALE("M"),
    FEMALE("F")
}

class Person {
    var name: String? = "";
    var age: Short? = 0;
    var sex: Sex? = null;
    var dateOfBirth: Date? = null;
    var cpf: String? = null;
    var id: Int? = null;

    constructor(name: String, age: Short, sex: Sex?, dateOfBirth: Date?, cpf: String?, id: Int?) {
        this.name = name
        this.age = age
        this.sex = sex
        this.dateOfBirth = dateOfBirth
        this.cpf = cpf
        this.id = id
    }

    constructor()
}