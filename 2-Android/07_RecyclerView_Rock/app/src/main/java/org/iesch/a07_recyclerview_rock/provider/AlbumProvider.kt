package org.iesch.a07_recyclerview_rock.provider

import org.iesch.a07_recyclerview_rock.model.Album

class AlbumProvider {
    // 2 - Voy a proporcionar todos los datos mediante un companion objet
    companion object{
        val listaDeAlbums = listOf<Album>(
            Album("Agila", "Extremoduro", 1996, "https://i.scdn.co/image/ab67616d0000b2735a8ba2534695700ef74e797f"),
            Album("La Ley Innata", "Extremoduro", 2008, "https://i.scdn.co/image/ab67616d0000b273fd0dd20940a1c57b2e8b6f85"),
            Album("Lo que aletea en nuestras cabezas", "Robe", 2015, "https://i.scdn.co/image/ab67616d0000b27365bcb9ba49418e6d7cd7f2d0"),
            Album("Destrozares, canciones para el final de los tiempos", "Robe", 2016, "https://i.scdn.co/image/ab67616d0000b27302ba013b92307ecf1bdf5f04"),
            Album("Mayéutica", "Robe", 2021, "https://i.scdn.co/image/ab67616d0000b273f621e6d2f7f54e2c875d291f"),
            Album("Deltoya", "Extremoduro", 1992, "https://i.scdn.co/image/ab67616d0000b273ea3c71e24656b5bff4626b88"),
            Album("Yo, Minoría Absoluta", "Extremoduro", 2002, "https://i.scdn.co/image/ab67616d0000b27337d01cb917e1cfc0e67d80fb"),
            Album("Material Defectuoso", "Extremoduro", 2011, "https://i.scdn.co/image/ab67616d0000b2738dbd98a25b08d0dfcd2dd372"),
            Album("Pedrá", "Extremoduro", 1995, "https://i.scdn.co/image/ab67616d0000b2732f90a5b1f4a73f7ae6e8ba3c"),
            Album("Amor Fino", "Los Enemigos", 2022, "https://i.scdn.co/image/ab67616d0000b273635e96b7cbb3e0c6a3fbb0b0"),
            Album("Polvo en los labios", "Los Enemigos", 1999, "https://i.scdn.co/image/ab67616d0000b2733a5f2df7318e759d8cf9423c"),
            Album("La Tierra está sorda", "Barricada", 2009, "https://i.scdn.co/image/ab67616d0000b27330a97b2783a7d6809424dc93"),
            Album("No hay tregua", "Barricada", 1986, "https://i.scdn.co/image/ab67616d0000b27379a5ae187377ceae13fc031b"),
            Album("Pasión por el ruido", "Platero y Tú", 1991, "https://i.scdn.co/image/ab67616d0000b273d9f47c2e7f593b8cf8e6473d"),
            Album("Hay poco Rock & Roll", "Platero y Tú", 1994, "https://i.scdn.co/image/ab67616d0000b273f56bfc57fd6c5151761ec6be"),
            Album("Correos", "Marea", 1999, "https://i.scdn.co/image/ab67616d0000b273c72e4997d46a2dd44b5cf4d6"),
            Album("28.000 Puñaladas", "Marea", 2004, "https://i.scdn.co/image/ab67616d0000b27301239849ba3c9e21cf1746e6"),
            Album("La Patera", "Marea", 2000, "https://i.scdn.co/image/ab67616d0000b2736a65fc4de02eaf843f5fb63b"),
            Album("Pongamos que hablo de Madrid", "Rosendo", 1999, "https://i.scdn.co/image/ab67616d0000b273626444cc4f36fc9d7cb3e285"),
            Album("Loco por incordiar", "Rosendo", 1985, "https://i.scdn.co/image/ab67616d0000b273b91b5866bdb5273cf87a4d1f"),
            Album("Agradecidos... Rosendo", "Rosendo", 2001, "https://i.scdn.co/image/ab67616d0000b273b18be2715d10434f9c69baed"),
            Album("Pájaros de barro", "Manolo García", 2001, "https://i.scdn.co/image/ab67616d0000b273ea0016df518e5b20ec6b6251"),
            Album("Arena en los bolsillos", "Manolo García", 1998, "https://i.scdn.co/image/ab67616d0000b27380d5d8ac3440f9a2848fcd43"),
            Album("Lo más lejos a tu lado", "Fito & Fitipaldis", 2003, "https://i.scdn.co/image/ab67616d0000b2739a9f6dfb7d91ed2fda2925a0"),
            Album("Antes de que cuente diez", "Fito & Fitipaldis", 2009, "https://i.scdn.co/image/ab67616d0000b27309d88cb21a636df1b4f23c5e"),
            Album("Dios te salve", "Los Suaves", 1999, "https://i.scdn.co/image/ab67616d0000b273a4f9c5a1d7c4b293c632d28a"),
            Album("29 años, 9 meses y 1 día", "Los Suaves", 2009, "https://i.scdn.co/image/ab67616d0000b27357e565db47fcce0247850cd8"),
            Album("Memoria de jóvenes airados", "Ilegales", 1982, "https://i.scdn.co/image/ab67616d0000b27309eb060227d61b87002fae19"),
            Album("Agotados de esperar el fin", "Ilegales", 1994, "https://i.scdn.co/image/ab67616d0000b273d47e0bc7ec0048adce9eae96"),
            Album("Vivo... para contarlo", "Sôber", 2004, "https://i.scdn.co/image/ab67616d0000b27376412f5f9075b88a26e3935d"),
            Album("Superbia", "Sôber", 2011, "https://i.scdn.co/image/ab67616d0000b27310c970d920a04542b5d4099b")
        )
    }
    
}