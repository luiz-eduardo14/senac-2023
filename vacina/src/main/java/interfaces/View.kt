package `interfaces`

import config.ViewConst

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class View(val value: ViewConst)
