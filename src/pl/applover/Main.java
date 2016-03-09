package pl.applover;

public class Main {

    public static void main(String[] args) {
        LCG lcg = new LCG(2, 4, 8, 13);
        for (int i = 0; i < 5; i++)
            System.out.println(lcg.nextLong());

        LCGFinder lcgFinder = new LCGFinder(2, 3, 7, 10);
        lcgFinder.solve();
    }
}