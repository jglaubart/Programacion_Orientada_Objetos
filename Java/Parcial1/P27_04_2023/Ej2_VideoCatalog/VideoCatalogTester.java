package Parcial1.P27_04_2023.Ej2_VideoCatalog;

import java.time.LocalDate;

public class VideoCatalogTester {
    public static void main(String[] args) {
        VideoCatalog videoCatalog = new VideoCatalog();


        // Agrega el episodio "Good News, Bad News" emitido el 20/11/1989 de la temporada 1
        videoCatalog.add("Good News, Bad News", LocalDate.of(1989,11,20), 1);
        // Agrega la película "Back to the Future" emitida el 03/07/1985 del est. "Universal"
        videoCatalog.add("Back to the Future", LocalDate.of(1985,7,3), "Universal");

        //mi comentario: con esto veo que add debe devolver el VideoCatalog con el nuevo elemento para poder seguir agregando
        videoCatalog.add("The Finale",LocalDate.of(1998,5,14), 9)
                .add("Back to the Future Part II", LocalDate.of(1989,11,20), "Universal");


        // Obtiene los elementos del catálogo (películas y episodios)
        // con orden descendente por fecha de emisión y desempata alfabéticamente por título
        for(VideoElem element : videoCatalog.getDescendingDateCopy()) {
            System.out.println(element);
        }
        // The Finale aired on 1998-05-14 is a TV Episode of Season 9
        // Back to the Future Part II aired on 1989-11-20 is a Movie from Studio Universal
        // Good News, Bad News aired on 1989-11-20 is a TV Episode of Season 1
        // Back to the Future aired on 1985-07-03 is a Movie from Studio Universal


        // Obtiene los elementos del catálogo (películas y episodios)
        // con orden cronológico por fecha de emisión y desempata descendente por título
        for(VideoElem element : videoCatalog.getChronologicalDateCopy()) {
            System.out.println(element);
        }
        // Back to the Future aired on 1985-07-03 is a Movie from Studio Universal
        // Good News, Bad News aired on 1989-11-20 is a TV Episode of Season 1
        // Back to the Future Part II aired on 1989-11-20 is a Movie from Studio Universal
        // The Finale aired on 1998-05-14 is a TV Episode of Season 9
    }
}
