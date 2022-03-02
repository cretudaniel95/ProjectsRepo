package Marketing;

public class Main {
    public static void main(String[] args) {
        Produs produs1 = new Produs("Corn", 17, 1.3, 0.82);
        Produs produs2 = new Produs("Strudel", 22, 1.4, 0.93);
        Produs produs3 = new Produs("Bere", 18, 2.4, 1.4 );
        Produs produs4 = new Produs("Coca-Cola", 16, 3.4, 2.4);
        Produs produs5 = new Produs("Inghetata", 10, 1.8, 1.1);
        Produs[] listaProduse = new Produs[]{produs1, produs2, produs3, produs4, produs5};

        Magazin magazin = new Magazin("Cora", listaProduse);
        magazin.afisareNumeProdusCuCeaMaiMareVanzarePeZi();
        magazin.afisareProdusCuCelMaiMicPretDeAchizite();
        magazin.afisareProdusCuCelMaiMarePretDeVanzare();


    }
}
