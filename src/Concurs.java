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
        System.out.println(nefolosite);

    }
    public static String initializareSolInitiala()
    {
        String cuvant="";
        while(nefolosite.size()!=0)
        {
            cuvant=push(cuvant);
        }
        return cuvant;
    }
    public static String push(String cuvant)
    {

        if ((nefolosite.size()==0)) {
            return cuvant;
        }
        else{
            cuvant = cuvant + nefolosite.get(0);

        }
        folosite.add(nefolosite.get(0));
        nefolosite.remove(0);
        return  cuvant;
    }
    public static String pop(String forma)
    {
        if (forma.length()==0)
        {
            return "0";
        }
        forma = forma.substring(0, forma.length() - 2);
        nefolosite.add(folosite.get(folosite.size() - 1));
        folosite.remove(folosite.size() - 1);
        return forma;
    }
    public static void back(int n)
    {
        String forma=initializareSolInitiala();
        String retineBack="";
        while (!forma.equals("0"))
        {

            if (nefolosite.size() == 0)
            {
                if (validare(forma) == false)
                {
                    //System.out.println("1");
                    forma = pop(forma);
                    if (retineBack.length()!=forma.length()) {
                        retineBack = forma;
                    }
                    if (next(0, forma).length() == 2 * n) {
                        forma = pop(forma);
                    }
                } else {
                    ordineParticipare.add(forma);
                }

            }
            if (next(0,forma).equals(retineBack))
            {
            forma=pop(forma);
            }
            else{
                forma=push(forma);
            }
            if (forma.length()==0)
            {
                retineBack="";
            }
        }
        //forma=pop(forma);
    }


    public static String next(int i,String cuvant)
    {
        //System.out.println(forma);
        if (nefolosite.size()!=0) {
            cuvant = cuvant + nefolosite.get(i);
        }
        return cuvant;
    }
    public static boolean validare(String cuvant)
    {
        for (int i=0;i<ordineParticipare.size();i++)
        {
            if (ordineParticipare.get(i)==cuvant)
            {
                return false;
            }
        }
        return true;
    }
    public static void solutii()
    {
        for (int i=0;i<ordineParticipare.size();i++)
        {
            System.out.println(ordineParticipare.get(i));
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Add size: ");
        int n=sc.nextInt();
        initializareMultime(n);
        back(n);
        solutii();
    }
}

