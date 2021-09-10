package katchy.dsl

data class Presentation(var slides: MutableList<Slide> = mutableListOf())

fun presentation(block: Presentation.() -> Unit): Presentation {
    val presentation = Presentation()
    presentation.block()
    return presentation
}

sealed interface Slide

data class TitleSlide(
    val title: String,
) : Slide

fun Presentation.title(title: String) {
    slides += TitleSlide(title = title)
}

data class TitleAndContentSlide(
    val title: String,
    val content: String,
) : Slide

fun Presentation.titleAndContent(title: String, content: String) {
    slides += TitleAndContentSlide(
        title = title,
        content = content,
    )
}
