package com.senac.interfaces

import com.senac.config.ViewConst

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class View(val value: ViewConst)
