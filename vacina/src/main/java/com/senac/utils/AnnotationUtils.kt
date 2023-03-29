package com.senac.utils

import com.senac.config.ViewConst
import com.senac.interfaces.RunProgram;
import com.senac.interfaces.View
import org.reflections.Reflections
import java.util.logging.Level
import kotlin.collections.ArrayList

class AnnotationUtils {
    companion object {
        fun getMapOfPackageViewAnnotation(): Map<ViewConst,Class<RunProgram>>{
            val mapViewMutation: MutableMap<ViewConst,Class<RunProgram>> = mutableMapOf()
            for (classProgram in findAllClassInPackage()){
                if(classProgram.isAnnotationPresent(View::class.java)){
                    val annotationView = classProgram.getAnnotation(View::class.java);
                    mapViewMutation[annotationView.value] = classProgram;
                }else{
                    throw Exception("Class ${classProgram.simpleName} not present annotation ${View::class.java.simpleName}");
                }
            }
            return mapViewMutation.toMap();
        }

        private fun findAllClassInPackage(): List<Class<RunProgram>> {
            java.util.logging.Logger.getLogger("org.reflections").level = Level.OFF
            val reflections = Reflections("com.senac.view")
            val listPrograms = ArrayList<Class<RunProgram>>()

            reflections.getSubTypesOf(RunProgram::class.java)
                .stream()
                .forEach() {
                    if(it.getConstructor().newInstance() is RunProgram){
                        listPrograms.add(it as Class<RunProgram>)
                    }else{
                        throw Exception("Class ${it.name} not implement interface ${RunProgram::class.java.simpleName}");
                    }
                }
            return listPrograms;
        }
    }
}
