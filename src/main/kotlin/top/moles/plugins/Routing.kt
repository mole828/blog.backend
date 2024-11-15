package top.moles.plugins

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.title

fun Application.configureRouting() {
    routing {
        get("/") {
            val hello = "Hello, Ktor."
            call.respondHtml {
                head {
                    title = hello
                }
                body {
                    h1 {
                        +hello
                    }
                }
            }
        }

        var count = 0
        get("/count") {
            count++
            call.respond(mapOf("count" to count))
        }
    }
}
