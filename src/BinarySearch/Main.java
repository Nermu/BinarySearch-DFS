package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int num;
    static int[] arr;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 1. The Playboy Chimp
        /*
        num = input.nextInt();
        arr = new int[num];
        for (int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }

        int k = input.nextInt();
        StringBuilder sb = new StringBuilder();
        while (k --> 0){
            int x = input.nextInt();
            int a = binarySearch(x,true);
            int b = binarySearch(x,false);
            sb.append(((a!=-1)? a:"X") + " " + ((b!=-1)? b:"X") + "\n");
        }
        System.out.println(sb);

         */

        // 2. PipeLine
        /*
        long n = input.nextLong();
        long k = input.nextLong();
        if(n==1){
            System.out.println(0);
            return;
        }
        if(n<=k){
            System.out.println(1);
            return;
        }
        long l=2,r=k,ans=-1,out=k*(k+1)/2;
        out-=k;
        while(l<=r){
            long mid=l+(r-l)/2;
            long temp=out-((mid*(mid-1)/2)-mid);
            if(temp>=n){
                ans=k-(mid-1);
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.println(ans);

         */

        // 3. Burning Midnight Oil
        /*
        long n = input.nextLong();
        int k = input.nextInt();
        long high = 1000000000, low = 1, mid;
        while (high-low>1)
        {
            mid = (high+low)/2;
            if (solve(n,mid,k))
                high = mid;
            else
                low = mid;
        }
        if (solve(n,low,k))
            System.out.println(low);
        else
            System.out.println(high);

         */

        // 4. Aggressive cows
        /*
        int t = input.nextInt();

        while( t-- != 0){
            int n = input.nextInt();
            int c = input.nextInt();

            int ar[] = new int[n];
            for(int i = 0; i < n;i++){
                ar[i] = input.nextInt();
            }
            Arrays.sort(ar);

            int low = 0, high = ar[n-1], mid, max = -1;

            while(low < high){

                mid = (low + high) / 2;

                if(isPossible(ar, mid, c))
                {
                    if(max < mid){
                        max = mid;
                    }
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            System.out.println(max);

        }

         */



    }

    // 4. Aggressive cows
    /*
    public static boolean isPossible(int ar[],int d,int cows){
        int pre = ar[0],c = 1;
        for(int i = 1;i < ar.length;i++){
            if(ar[i] - pre >= d){
                pre = ar[i];
                c++;
                if(c == cows){
                    return true;
                }
            }
        }
        return false;
    }

     */

    // 3. Burning Midnight Oil
    /*
    static boolean solve(long n, long v, int k)
    {
        long lines = 0;
        long tem = 1;
        while ((v/tem) != 0)
        {
            lines += (v/tem);
            tem = tem * k;
        }
        return (lines >= n);
    }

     */
    // 1. The Playboy Chimp
    /*
    private static int binarySearch(int x, boolean b) {
        int low = 0 , height = num - 1;
        int ans = -1;
        while(low <= height)
        {
            int mid = (low + height)>>1;
            if(b)
            {
                if(arr[mid] >= x) height = mid-1;
                else
                {
                    ans = arr[mid];
                    low = mid+1;
                }
            }else
            {
                if(arr[mid] <= x) low = mid+1;
                else
                {
                    ans = arr[mid];
                    height = mid-1;
                }
            }
        }
        return ans;
    }

     */
}
