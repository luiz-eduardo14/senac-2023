package model

import java.time.LocalDate

enum class Sex(s: String) {
    MALE("M"),
    FEMALE("F")
}

class Person {
    var name: String? = "";
    var age: Short? = 0;
    var sex: Sex? = null;
    var dateOfBirth: LocalDate? = null;
    var cpf: String? = null;
    var id: Int? = null;

    constructor(name: String, age: Short, sex: Sex?, dateOfBirth: LocalDate?, cpf: String?, id: Int?) {
        this.name = name
        this.age = age
        this.sex = sex
        this.dateOfBirth = dateOfBirth
        this.cpf = cpf
        this.id = id
    }

    constructor()
}