package Marketing;

public class Magazin {
    private String nume;
    private Produs[] listaProduse;

    public Magazin(String nume, Produs[] listaProduse) {
        this.nume = nume;
        this.listaProduse = listaProduse;
    }

    public void afisareNumeProduse(Produs produs){
        System.out.println("NUmele produselor din magazin sunt: "+ produs.getNume());
    }

    public void afisareNumeProdusCuCeaMaiMareVanzarePeZi(){
        Produs produsCuVanzareMaxima = listaProduse[0];
        for (Produs produs : listaProduse){
            if (produs.getNrVanzariPeZi() > produsCuVanzareMaxima.getNrVanzariPeZi()){
                produsCuVanzareMaxima = produs;
            }
        }
        System.out.println("Produsul cu cea mai mare vanzare pe zi este: "+ produsCuVanzareMaxima.getNume());
    }

    public void afisareProdusCuCelMaiMarePretDeVanzare(){
        Produs produsCuPretulCelMaiMare = listaProduse[0];
        for (Produs produs: listaProduse){
            if (produs.getPret() > produsCuPretulCelMaiMare.getPret()){
                produsCuPretulCelMaiMare = produs;
            }
        }
        System.out.println("Produsul cu cel mai mare pret este: "+ produsCuPretulCelMaiMare.getNume());
    }





















    public void afisareProdusCuCelMaiMicPretDeAchizite(){
        Produs produsCuCelMaiMicPretDeAchizitie = listaProduse[0];
        for (Produs produs : listaProduse){
            if (produs.getPretAchizitie() < produsCuCelMaiMicPretDeAchizitie.getPretAchizitie()){
                produsCuCelMaiMicPretDeAchizitie = produs;
            }
        }
        System.out.println("Produsul cu cel mai mic pret de achizite este: "+ produsCuCelMaiMicPretDeAchizitie.getNume());
    }
}
