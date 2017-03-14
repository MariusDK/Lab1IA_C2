import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static sun.misc.Version.print;

/**
 * Created by MariusDK on 11.03.2017.
 */
public class Concurs
{



    public static List<String> ordineParticipare = new ArrayList<String>();
    public static List<String> folosite = new ArrayList<String>();
    public static List<String> nefolosite = new ArrayList<String>();

    public static void initializareMultime(int n)
    {
        for (int i=0;i<n;i++)
        {
            int k=i+1;
            nefolosite.add("C"+k);
        }
    }




    public static void back(int n)
    {
        String forma="";
        while (true)
        {
            if (nefolosite.size() == 0) {
                if (validare(forma, n) == false) {
                    System.out.println(validare(forma,n));
                    forma = forma.substring(0, forma.length() - 2);
                    nefolosite.add(folosite.get(folosite.size() - 1));
                    folosite.remove(folosite.size() - 1);
                    if (folosite.size()==n-1)
                    {
                        forma = forma.substring(0, forma.length() - 2);
                        nefolosite.add(folosite.get(folosite.size() - 1));
                        folosite.remove(folosite.size() - 1);
                    }

                    /**while (folosite.size() != n) {
                        nefolosite.add(folosite.get(folosite.size() - 1));
                        folosite.remove(folosite.size() - 1);

                        for (int j=0;j<nefolosite.size();j++) {

                            forma=forma+nefolosite.get(j);
                            folosite.add(nefolosite.get(j));
                            nefolosite.remove(j);
                        }
                    }
                     **/
                }
                else {
                    ordineParticipare.add(forma);
                    System.out.println(forma);
                }
            } else {
                int i = 0;
                while (folosite.size() < n) {
                    forma = forma+nefolosite.get(i);
                    folosite.add(nefolosite.get(i));
                    nefolosite.remove(i);
                }
            }
        }
    }
    public static boolean validare(String cuvant,int n)
    {
        if (cuvant.length()!=2*n)
        {
            return false;
        }
        if (ordineParticipare.contains(cuvant)) {
            return false;
        }
        return true;
    }
    public static void solutii()
    {

    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Add next: ");
        int n=sc.nextInt();
        initializareMultime(n);
        back(n);
    }
}

