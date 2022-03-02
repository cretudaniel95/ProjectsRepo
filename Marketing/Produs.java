package Marketing;

public class Produs {
    private String nume;
    private int nrVanzariPeZi;
    private double pret;
    private double pretAchizitie;

    public Produs(String nume, int nrVanzariPeZi, double pret, double pretAchizitie) {
        this.nume = nume;
        this.nrVanzariPeZi = nrVanzariPeZi;
        this.pret = pret;
        this.pretAchizitie = pretAchizitie;
    }

    public String getNume() {
        return nume;
    }

    public int getNrVanzariPeZi() {
        return nrVanzariPeZi;
    }

    public double getPret() {
        return pret;
    }

    public double getPretAchizitie() {
        return pretAchizitie;
    }
}
