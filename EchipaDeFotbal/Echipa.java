package EchipaDeFotbal;

import org.apache.commons.lang3.ArrayUtils;

public class Echipa {
    private String nume;
    private Jucator[] listaJucatori;

    public Echipa(String nume, Jucator[] listaJucatori) {
        this.nume = nume;
        this.listaJucatori = listaJucatori;
    }

    public void afisareJucatori(){
        for (Jucator jucator : listaJucatori){
            System.out.println(jucator.getNume());
        }
    }

    public void cumparaFotbalist(Jucator jucator){
        ArrayUtils.add(listaJucatori, jucator);
    }
    public void afisareJucatorCuNrMaxDeAparitii(){
        Jucator jucatorulCuNrMaxDeAparitii = listaJucatori[0];

        for (Jucator jucator : listaJucatori){
            if (jucator.getNrAparitii() > jucatorulCuNrMaxDeAparitii.getNrAparitii()){
                jucatorulCuNrMaxDeAparitii = jucator;
            }
        }
        System.out.println("Jucatorul cu numarul maxim de aparitii este: "+ jucatorulCuNrMaxDeAparitii.getNume());
    }

    public void afisareJucatorCuNrMaxDeGoluri(){
        Jucator jucatorulCuNrMaximDeGoluri = listaJucatori[0];
        for (Jucator jucator : listaJucatori){
            if (jucator.getNrGoluri() > jucatorulCuNrMaximDeGoluri.getNrGoluri()){
                jucatorulCuNrMaximDeGoluri = jucator;
            }
        }
        System.out.println("Jucatorul cu numarul maxim de goluri este: " + jucatorulCuNrMaximDeGoluri.getNume());
    }
}
