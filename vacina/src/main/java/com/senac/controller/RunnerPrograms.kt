package com.senac.controller

import com.senac.config.ViewConst
import com.senac.interfaces.RunProgram
import javax.persistence.EntityManagerFactory

class RunnerPrograms(
    private val factory: EntityManagerFactory,
    private val listViews: Map<ViewConst, Class<RunProgram>>
) {

    private fun validateView(viewConst: ViewConst){
        if(!listViews.containsKey(viewConst)){
            throw Exception("Not found base com.senac.view.ViewConst with value $viewConst in Map<ViewConst, Class<RunProgram>>")
        }
    }

    fun run(baseView: ViewConst){
        validateView(baseView)
        if (factory.isOpen()){
            var currentViewClass: Class<RunProgram>? = this.listViews[baseView];
            while (currentViewClass != null && this.factory.isOpen()){
                val newInstanceOfCurrentView = currentViewClass.getConstructor().newInstance()
                val resultOfRunView = newInstanceOfCurrentView.run(this.factory)
                currentViewClass = this.listViews[resultOfRunView]
            }
       }else{
            throw Exception("Factory is close")
       }
    }

    fun finish(){
        if (factory.isOpen()) factory.close();
    }
}