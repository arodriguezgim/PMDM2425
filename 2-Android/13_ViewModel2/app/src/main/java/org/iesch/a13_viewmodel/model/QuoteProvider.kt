package org.iesch.a13_viewmodel.model

class QuoteProvider {

    companion object {

        fun random(): QuoteModel {
            val number = (0..19).random()
            return quotes[number]
        }

        private val quotes = listOf<QuoteModel>(
            QuoteModel("La simplicidad es la máxima sofisticación.", "Leonardo da Vinci"),
            QuoteModel("Los mejores programas son los que menos código tienen.", "James Gosling"),
            QuoteModel("Hablar es barato. Muéstrame el código.", "Linus Torvalds"),
            QuoteModel(
                "Cualquier código que no hayas probado es un código roto.",
                "Tom Preston-Werner"
            ),
            QuoteModel("Si no puedes programarlo, no lo entiendes.", "Richard Feynman"),
            QuoteModel(
                "Si piensas que tu usuario es idiota, solo diseñarás tecnología idiota.",
                "Linus Torvalds"
            ),
            QuoteModel(
                "Un buen programador es alguien que siempre mira en ambas direcciones antes de cruzar una calle de un solo sentido.",
                "Doug Linder"
            ),
            QuoteModel(
                "La experiencia no es lo que te ocurre, sino lo que haces con lo que te ocurre.",
                "Aldous Huxley"
            ),
            QuoteModel("El software es una gran combinación de arte e ingeniería.", "Bill Gates"),
            QuoteModel(
                "La mayoría de los programadores intentan hacer el software tan fácil como les sea posible. No saben lo que hacen, pero lo hacen bien.",
                "Alan J. Perlis"
            ),
            QuoteModel("Los problemas simples deben resolverse de forma simple.", "Dennis Ritchie"),
            QuoteModel(
                "La perfección se alcanza, no cuando no hay más que añadir, sino cuando no hay más que quitar.",
                "Antoine de Saint-Exupéry"
            ),
            QuoteModel(
                "Nunca confíes en un ordenador que no puedas lanzar por una ventana.",
                "Steve Wozniak"
            ),
            QuoteModel(
                "Cualquier tonto puede escribir código que una computadora entienda. Los buenos programadores escriben código que los humanos entiendan.",
                "Martin Fowler"
            ),
            QuoteModel("El software es como el sexo: es mejor cuando es gratis.", "Linus Torvalds"),
            QuoteModel(
                "La lógica te llevará de A a B. La imaginación te llevará a todas partes.",
                "Albert Einstein"
            ),
            QuoteModel(
                "Los lenguajes de programación más poderosos son aquellos que combinan la simplicidad con la expresión.",
                "John Carmack"
            ),
            QuoteModel(
                "Los buenos juicios provienen de la experiencia. La experiencia proviene de los malos juicios.",
                "Fred Brooks"
            ),
            QuoteModel(
                "Si construyes algo para que el usuario lo entienda, nunca lo usará.",
                "Donald Norman"
            ),
            QuoteModel(
                "Si piensas que la educación es cara, prueba con la ignorancia.",
                "Derek Bok"
            )
        )
    }
}