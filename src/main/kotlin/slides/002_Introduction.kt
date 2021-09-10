package slides

import katchy.dsl.Presentation
import katchy.dsl.titleAndContent

fun Presentation.introduction() =
    titleAndContent(
        title = "Hello There",
        content = """
             katchy enables you to create beautiful interactive slide decks using Kotlin. This presentation will show
             you examples of what it can do.
        """
    )
