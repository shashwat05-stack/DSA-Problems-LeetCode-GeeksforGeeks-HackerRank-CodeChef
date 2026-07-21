import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0)
        {
            int N = sc.nextInt();

            int max = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++)
            {
                int num = sc.nextInt();

                if(num > max)
                {
                    max = num;
                }
            }

            System.out.println(max);
        }
    }
}