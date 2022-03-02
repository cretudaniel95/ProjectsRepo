package temaFunctions;

public class SalesRep {

    private String name;
    private int numberOfSales;
    private int quotaPerSale;
    private int worthOfSales;




    public SalesRep(String name, int numberOfSales, int quotaPerSale) {
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.quotaPerSale = quotaPerSale;
        this.worthOfSales = numberOfSales * quotaPerSale;
    }

    public String getName() {
        return name;
    }

    public int getWorthOfSales() {
        return worthOfSales;
    }

    /**
     *
     * @param reps is a list o Salesrep
     * Method sort is a method that sort the worth of sales in ascending
     */
    public void sort(SalesRep[] reps) {
        for (int i = 0; i < reps.length - 1; ++i) {
            for (int j = 0; j < reps.length - i - 1; ++j) {
                if (reps[j + 1].worthOfSales < reps[j].worthOfSales) {
                    int swap = reps[j].worthOfSales;
                    reps[j].worthOfSales = reps[j + 1].worthOfSales;
                    reps[j + 1].worthOfSales = swap;
                }
            }
        }
    }
}
