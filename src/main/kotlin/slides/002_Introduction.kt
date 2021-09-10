package slides

import _internal.RevealJsSlides
import kotlinx.html.h2
import kotlinx.html.p
import kotlinx.html.section

fun RevealJsSlides.introduction() {
    section {
        h2 { +"Hello There" }
        p {
            +"""
             reveal.js enables you to create beautiful interactive slide decks using HTML. This presentation will show
             you examples of what it can do.
             """
        }
    }
}
