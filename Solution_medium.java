import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;
public class Solution_medium
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);  
        int i, j, current, value, notif = 0;
        double median = 0;
        int n = sc.nextInt(); //days
        int d = sc.nextInt(); //trailing days
        Hashtable<Integer, Integer> tdays = new Hashtable<Integer, Integer>();
        int [] sortedDays = new int[d]; //to contain sprted trailing days
        if (d>=n) { //if no enough trailing days
            System.out.println(0);
            return;
        }
        for(i=0;i<n;i++) //reads expenditure
        {
            if(i==d) //sorts expenditure for first set of trailing days. occurs only once!
            {
                Arrays.sort(sortedDays);
            }
            if(i<d) //reads expenditure for first set of trailing days.
            {
                current = sc.nextInt();
                tdays.put(i,current);
                sortedDays[i] = current;
            }
            else //reads rest of data, computes median for all sets of trailing days
            {
                value = sc.nextInt();
                if(d%2==0) //if even number of trailing days
                {
                    median = ((double)sortedDays[d/2 -1] + (double)sortedDays[d/2])/2.0;
                }
                else //if odd number of trailing days
                {
                    median = (double)sortedDays[d/2];
                }
                if((double)value>=2.0*median)//if value to withdraw is > median
                {
                    notif++;
                }
                current = tdays.get((i)%d); 
                tdays.put(i%d,value);
                int index = Arrays.binarySearch(sortedDays, current); //binary search for location of current value to replace. binary search reduces time to O(logn)
                /*the following code replaces the oldest value in the array and still keeps it sorted*/
                if(value==current)
                {
                    sortedDays[index] = value;
                }
                else if(value>current)
                {
                    for(j=index+1;j<d;j++)
                    {
                        if(sortedDays[j]>=value)
                        {
                            sortedDays[j-1] = value;
                            break;
                        }
                        else
                        {
                            sortedDays[j-1] = sortedDays[j];
                        }
                        if(j==d-1)
                        {
                            sortedDays[j] = value;
                        }
                    }
                }
                else
                {
                    for(j=index-1;j>=0;j--)
                    {
                        if(sortedDays[j]<=value)
                        {
                            sortedDays[j+1] = value;
                            break;
                        }
                        else
                        {
                            sortedDays[j+1] = sortedDays[j];
                        }
                        if(j==0)
                        {
                            sortedDays[j] = value;
                        }
                    }
                } 
            }
        }
        System.out.println(notif);
    }
}
 /*By Issifu*/       