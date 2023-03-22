package controller

import config.ViewConst
import interfaces.RunProgram
import javax.persistence.EntityManagerFactory

class RunnerPrograms {
    private val factory: EntityManagerFactory;
    private val listViews: Map<ViewConst, RunProgram>;

    constructor(factory: EntityManagerFactory,listViews: Map<ViewConst, RunProgram>){
        this.factory = factory;
        this.listViews = listViews;
    }

    fun start(baseView: String){
        if (factory.isOpen()){

        }else{
            throw Exception("Factory is close")
        }
    }

    fun finish(){
        if (factory.isOpen()) factory.close();
    }
}