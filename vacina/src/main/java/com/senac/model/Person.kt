package com.senac.model

import java.time.LocalDate
import javax.persistence.*

enum class Sex(s: String) {
    MALE("M"),
    FEMALE("F")
}

@Entity
@Table(name = "person")
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "name")
    var name: String? = "";
    @Column(name = "age")
    var age: Int? = 0;
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    var sex: Sex? = null;
    @Column(name = "dateOfBirth")
    var dateOfBirth: LocalDate? = null;
    @Column(name = "cpf")
    var cpf: String? = null;

    constructor(name: String, age: Int, sex: Sex?, dateOfBirth: LocalDate?, cpf: String?, id: Long?) {
        this.name = name
        this.age = age
        this.sex = sex
        this.dateOfBirth = dateOfBirth
        this.cpf = cpf
        this.id = id
    }

    constructor()
}