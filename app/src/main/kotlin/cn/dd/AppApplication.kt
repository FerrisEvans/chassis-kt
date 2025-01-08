package cn.dd

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppApplication

val log: Logger = LoggerFactory.getLogger(AppApplication::class.java)

fun main(args: Array<String>) {
    val context = runApplication<AppApplication>(*args)
    val env = context.environment
    env.activeProfiles.forEach(log::info)
    log.info("---------- {} is running ----------", env.getProperty("spring.application.name"))
}