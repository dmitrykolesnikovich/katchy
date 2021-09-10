package slides

import _internal.RevealJsSlides
import kotlinx.html.h1
import kotlinx.html.section

fun RevealJsSlides.titleSlide() {
    section {
        h1 { +"Title slide" }
    }
}
