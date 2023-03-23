package com.senac

import com.senac.config.Database
import com.senac.config.ViewConst
import com.senac.controller.RunnerPrograms
import com.senac.utils.AnnotationUtils

fun main(args: Array<String>) {
    val factory = Database.entityManagerFactory;
    val runner = RunnerPrograms(factory,AnnotationUtils.getMapOfPackageViewAnnotation());
    runner.run(ViewConst.PERSON)
    runner.finish();
}