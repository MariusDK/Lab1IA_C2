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

    public static void back(int n)
    {
        String forma="";
        while (true)
        if (nefolosite.size()==0)
        {
            if (validare(forma,n)==false)
            {
                forma.replace(forma.substring(forma.length()-1),"");
                nefolosite.add(folosite.get(folosite.size()-1));
                folosite.remove(folosite.size()-1);
                int k=0;
                String next;
                while (nefolosite.size()!=0)
                {
                    next=forma+nefolosite.get(k);
                    if (validare(next,n))
                    {
                        forma=next;
                        folosite.add(nefolosite.get(k));
                        nefolosite.remove(k);
                    }
                    

                }
            }
            ordineParticipare.add(forma);
        }
        else
        {
            int i=0;
            while(nefolosite.size()>0)
            {
                forma = forma + nefolosite.get(i);
                folosite.add(nefolosite.get(i));
                nefolosite.remove(i);
            }
        }
    }
    public static boolean validare(String cuvant,int n)
    {
        if (cuvant.length()!=n)
        {
            return false;
        }
        if (ordineParticipare.contains(cuvant))
        {
            return false;
        }
        return true;
    }



}

