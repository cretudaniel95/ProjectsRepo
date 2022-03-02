package EchipaDeFotbal;

public class Main {
    public static void main(String[] args) {
        Jucator jucator1 = new Jucator("Messi", 75, 25);
        Jucator jucator2 = new Jucator("Neynmar", 68, 27);
        Jucator jucator3 = new Jucator("Pique", 22, 30);
        Jucator jucator4 = new Jucator("Pirlo", 21, 29);
        Jucator[] listaJucatori = new Jucator[]{jucator1, jucator2, jucator3, jucator4};
        Echipa echipa = new Echipa("Barcelona", listaJucatori);



        echipa.afisareJucatori();
        echipa.afisareJucatorCuNrMaxDeAparitii();
        echipa.afisareJucatorCuNrMaxDeGoluri();
    }
}
