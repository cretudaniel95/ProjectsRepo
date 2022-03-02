package temaFunctions;


public class Main {
    public static void main(String[] args) {

        /**
         * Creating some SalesReps
         */
        SalesRep rep1 = new SalesRep("Daniel", 24, 145);
        SalesRep rep2 = new SalesRep("Ionut", 20, 140);
        SalesRep rep3 = new SalesRep("Maria", 35, 111);
        SalesRep rep4 = new SalesRep("George", 15, 350);
        SalesRep rep5 = new SalesRep("George", 15, 2);
        /**
         * Add the SalesReps in a Array
         */
        SalesRep[] reps = new SalesRep[]{rep1, rep2, rep3, rep4, rep5};

        System.out.println("Lista initiala este: ");
        /**
         * Print the original order of the Array
         */
        for (SalesRep salesRep : reps) {
            System.out.println("Reprezentantul " + salesRep.getName() + " are o valoare totala de vanzari de " + salesRep.getWorthOfSales() + "$");
        }
        /**
         * Call the SalesRep method sort
         */
        rep1.sort(reps);
        System.out.println("Lista in ordine descendenta este urmatoarea: ");
        /**
         * Print the sorted order of the Array
         */
        for (SalesRep salesRep : reps) {
            System.out.println("Reprezentantul " + salesRep.getName() + " are o valoare totala de vanzari de " + salesRep.getWorthOfSales() + "$");
        }
    }
}

