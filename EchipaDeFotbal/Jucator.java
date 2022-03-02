package EchipaDeFotbal;

public class Jucator {

    private String nume;
    private int nrGoluri;
    private int nrAparitii;

    public Jucator(String nume, int nrGoluri, int nrAparitii) {
        this.nume = nume;
        this.nrGoluri = nrGoluri;
        this.nrAparitii = nrAparitii;
    }

    public String getNume() {
        return nume;
    }

    public int getNrGoluri() {
        return nrGoluri;
    }

    public int getNrAparitii() {
        return nrAparitii;
    }

}
