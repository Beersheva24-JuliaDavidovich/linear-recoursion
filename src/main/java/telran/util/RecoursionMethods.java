package telran.util;

public class RecoursionMethods {
    public static void f(int a) {
        if (a > 3) {
            f(a - 1);
        }
    }

    public static long factorial(int n) {
        // n! = 1 * 2 * 3 * ... * n
        if (n < 0) {
            n = -n;
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    public static long pow(int num, int degree) {
        if(degree < 0) {
            throw new IllegalArgumentException();
        }
        return degree == 0 ? 1 : num * pow(num, degree - 1);
    }

    //@param num - any number
    // degree - any positive
    // return num ^ degree
    //limitations:
    //1. no sycles allowed
    //2. arithmetic operators +; - are allowed only
    //bitwise operators like >>, <<, &&, ect disallowed
    public static long powHW(int num, int degree) {
        long res = 0;
        int count = num > 0 ? num : - num;
        if(degree < 0) {
            throw new ArithmeticException();
        }else if(degree == 0) {
            res = 1;
        } else if(degree == 1) {
            res = num;
        } else if(degree > 0){
            res = sDegree(num, degree - 1, count);
        }
        return res;
    }
  
    private static long sDegree(int num, int i, int count) {
        long res = 0;
        if(count < 0) {
            num = - num;
        }
        if(count > 0) {
            res = num + sDegree(num, i, count - 1);
        }
        return res;
    }

    //no sycles allowed
    public static int sum(int [] array) {

        return sum(array, array.length);
    }

    private static int sum(int[] array, int length) {
        return length == 0 ? 0 : array[length -1] + sum(array, length -1);
    }

    //limitation
    // return x^ 2
    //1. no sycles
    // 2. arithmetic opetarors only +; -
    //3. no bitwise operators
    //4. no standarts and additional functions are allowed
    //5. no additional fields of the class RecoursionMethods are allowed
    public static int square(int x) {
        int res = 0;
        if(x != 0) {
            res = x < 0 ? square(-x) : x + x - 1 + square(x - 1);
        }
        return res;
    }

    // return true if subString is of the given string
    //1.methods of class String allowed
    //1.1 charAt(int index)
    //1.2 length()
    //1.3 subString(int beginIndex)
    //no sycles
    //
    public static boolean isSubstring(String str, String subString) {
        boolean res = false;
        if(str.length() < subString.length()) {
            res = false;
        } else {
            res = includeS(str, subString);
        }
        return res;
    }

    private static boolean includeS(String str, String subString) {
        boolean res = false;
        if(str.length() < subString.length()) {
            res = false;
        } else if (equalsStrings(str, subString, 0)) {
            res = true;
        } else {
            res = includeS(str.substring(1), subString);
        }
        return res;
    }

    private static boolean equalsStrings(String str, String subString, int i) {
       boolean res;
       if(i == subString.length()) {
        res = true;
       } else if (str.charAt(i) != subString.charAt(i)) {
        res = false;
       } else {
        res = equalsStrings(str, subString, i + 1);
       }
    return res;
    }
}
