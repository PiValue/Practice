import java.io.*;

/* pow(a, n) with complexity theta(log(n)) */
class GFG {
    public long powOfN(int base, int pow) {
        if (pow == 0) {
            return 1;
        }
        final long temp = powOfN(base, pow/2);
        if (pow % 2 == 0) {
            return temp * temp;
        }
        return temp * temp * base;
        
    }
}
