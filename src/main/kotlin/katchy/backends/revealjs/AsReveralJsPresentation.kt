package katchy.backends.revealjs

import katchy.dsl.Presentation
import katchy.dsl.Slide
import katchy.dsl.TitleAndContentSlide
import katchy.dsl.TitleSlide
import kotlinx.html.TagConsumer
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.p
import kotlinx.html.section
import org.w3c.dom.HTMLElement

fun Presentation.asRevealJsPresentation(tagConsumer: TagConsumer<HTMLElement>) {
    slides.forEach {
        it.toRevealJs(tagConsumer)
    }
}

private fun Slide.toRevealJs(tagConsumer: TagConsumer<HTMLElement>) =
    when (this) {
        is TitleSlide -> toRevealJs(tagConsumer)
        is TitleAndContentSlide -> toRevealJs(tagConsumer)
    }

private fun TitleSlide.toRevealJs(tagConsumer: TagConsumer<HTMLElement>) {
    with(tagConsumer) {
        section {
            h1 { +title }
        }
    }
}

private fun TitleAndContentSlide.toRevealJs(tagConsumer: TagConsumer<HTMLElement>) {
    with(tagConsumer) {
        section {
            h2 { +title }
            p { +content }
        }
    }
}
