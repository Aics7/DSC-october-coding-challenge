import java.util.Scanner;
public class Solution_easy 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //start point of house
        int t = sc.nextInt(); //end point of house
        int a = sc.nextInt(); //apple tree
        int b = sc.nextInt(); //orange tree
        int m = sc.nextInt(); //number of apples
        int n = sc.nextInt(); //number of oranges

        int i,j,x, applesOnHouse=0,orangesOnHouse=0;
        for(i=0;i<m+n;i++)
        {
            if(i<m) //apple distances
            {
                x = sc.nextInt() + a;
                if(x >= s && x <= t) //apple falls on house
                {
                    applesOnHouse++;
                }
            }
            else //orange distances
            {
                x = sc.nextInt() + b;
                if(x >= s && x <= t) //orange falls on house
                {
                    orangesOnHouse++;
                }
            }
        }        
        sc.close();
        System.out.println(applesOnHouse+"\n"+orangesOnHouse);
    }
}
/*By Issifu*/