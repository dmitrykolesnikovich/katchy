package katchy.backends.revealjs

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.dom.append
import kotlinx.html.h1
import org.w3c.dom.Node
import org.w3c.dom.get
import thisPresentation

fun main() {
    window.onload = {
        val revealNode: Node = document.getElementsByClassName("slides").let {
            if (it.length == 1) {
                it[0]!!
            } else {
                val message = "Couldn't inject presentation code to Reveal.JS structure from Kotlin/JS!"
                document.body?.append { h1 { +message } }
                throw IllegalStateException(message)
            }
        }
        revealNode.append {
            thisPresentation.asRevealJsPresentation(this)
        }
        window["Reveal"]["initialize"]()
    }
}
