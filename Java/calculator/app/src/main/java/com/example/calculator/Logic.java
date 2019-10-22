package com.example.calculator;

public class Logic
{
    public double summ(double a, double b) {
        a += b;
        if(!this.isNice(a)) return 1999999999;
        return this.checkLenght(a);
    }
    public double minus(double a, double b) {
        a -= b;
        if(!this.isNice(a)) return 1999999999;
        return this.checkLenght(a);
    }
    public boolean isNice(double a) {
        Integer c = (int) a;
        System.out.println(c + " ccccccccccccccc");
        if (c > 999999999) {
            return false;
        }
        return true;
    }
    public double divide(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        a /= b;
        if(!this.isNice(a)) return 1999999999;
        return this.checkLenght(a);
    }
    public double multiply(double a, double b) {
        a *= b;
        if(!this.isNice(a)) return 1999999999;
        return this.checkLenght(a);
    }
    public String cutDisplay(String a) {
        if (a == null) return "false";
        String Stringa = "";
        int i = 0;
        if (a.length() > 9)
        {
            for (char q : a.toCharArray())
            {
                i++;
                if (i > 9) break;
                Stringa += q;

            }
        }
        else
        {
            return a;
        }
        return Stringa;
    }
    public double checkLenght(Double a) {
        return Double.parseDouble(this.cutDisplay(Double.toString(a)));
    }
}
