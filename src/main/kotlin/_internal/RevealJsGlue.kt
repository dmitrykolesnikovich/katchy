package _internal

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.TagConsumer
import kotlinx.html.dom.append
import kotlinx.html.h1
import org.w3c.dom.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.get
import presentation

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
            presentation()
        }
        window["Reveal"]["initialize"]()
    }
}

typealias RevealJsSlides = TagConsumer<HTMLElement>
