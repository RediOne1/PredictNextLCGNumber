package pl.applover;

/**
 * author:  Adrian Kuta
 * date:    08.03.2016
 */
public class LCGFinder {

    private long x0, x1, x2, x3;
    private long modulus;

    public LCGFinder(long x0, long x1, long x2, long x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public void solve() {
        long nwd = nwd(x2 - x1, x1 - x0);
        long nww = Math.abs((x2 - x1) * (x1 - x0) / nwd);
        modulus = Math.abs(((x2 - x1) * nww / (x1 - x0) - (x3 - x2) * nww / (x2 - x1)));
        ;
        long temp1 = (x3 - x2) - (x2 - x1);
        long temp2 = (x2 - x1) - (x1 - x0);
        if (temp1 < 0)
            temp1 += modulus;
        if (temp2 < 0)
            temp2 += modulus;

        long a = calcA(temp1, temp2);
        long b = (x0 * a + modulus) % modulus;
        System.out.println("Modulus = " + modulus);
        System.out.println("Multiplier = " + a);
        System.out.println("Increment = " + b);
        LCG lcg = new LCG(x3, a, b, modulus);
        System.out.println(lcg.nextLong());
    }

    private long calcA(long temp1, long temp2) {
        float k = 0;
        float wynik = ((float) modulus * k + (float) temp1) / (float) temp2;
        while (wynik != (long) wynik) {
            k += 1;
            wynik = ((float) modulus * k + (float) temp1) / (float) temp2;
        }
        return (long) wynik;
    }

    private long nwd(long a, long b) {
        long c;                    // Tworzymy zmienną c o typie int
        while (b != 0)             // Tworzymy pętlę działającą gdy b ≠ 0
        {
            c = a % b;              // Zmienna c przyjmuje wartość a modulo b
            a = b;                // Przypisujemy b do a
            b = c;                // Przypisujemy c do b
        }
        return a;                 // Zwracamy a, czyli żądane NWD(a,b)
    }
}
