/**
 *
 *  @author Kaszlewicz Tomasz S16165
 *
 */

package zad3;


public class ReverseTest {

  public static void main(String[] args) {
  
        Reversible[] revers = new Reversible[] {
            new ReversibleString("Kot"),
            new ReversibleDouble(2),
            new ReversibleDouble(3),
            new ReversibleString("Pies"),
            new ReversibleString("Ala ma kota i psa"),
            new ReversibleDouble(10),
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        for (Reversible r : revers) {
          r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
           r.reverse();
           if(r.getClass().equals(ReversibleString.class))
        	   System.out.println("Tekst " + r);
           else{
        	   double res = Double.parseDouble(r.toString());
        	   res += 10;
        	   System.out.println(res);
           }
        }
      }
    }
