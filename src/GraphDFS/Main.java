package GraphDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 1. The Seasonal War
    /*
    static int n,
            dx[] = { 0, 0, 1, -1, -1, 1, -1, 1 },
            dy[] = { 1, -1, 0, 0, -1, 1, 1, -1 };
    static boolean visited[][], war[][];
    
     */
    
    // 2. Marcus
    /*
    static char[][] grid;
    static int[] dx = {-1, 0, 0};
    static int[] dy = {0, 1, -1};
    static String[] steps = {"forth", "right" , "left"};
    static char[] iEhova = "IEHOVA#".toCharArray();
    static int n;
    static int m;
    static boolean answer;

     */

    // 3. Battleships
    /*
    static int[] xx = {1,0,0,-1};
    static int[] yy = {0,1,-1,0};
    static char[][] arr;

     */

    // 4. Forming Teams
    /*
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

     */

    // 5. MakeTree - Hierarchy
    static int[] inDegree = new int[100005];
    static int[] parent = new int[100005];
    public static void main(String[] args) throws IOException {

        // 1. The Seasonal War
        /*
        Scanner input = new Scanner(System.in);
        int t = 1;
        while (true) {
            n = input.nextInt();
            visited = new boolean[n][n];
            war = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String s = input.next();
                for (int j = 0; j < n; j++)
                    war[i][j] = s.charAt(j) == '1';
            }
            int ans = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (!visited[i][j] && war[i][j]) {
                        ans++;
                        dfs(i, j);
                    }
            System.out.printf("Image number %d contains %d war eagles.\n", t++, ans);
        }

         */

        // 2. Marcus
        /*
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] read;
        int tests = Integer.parseInt(in.readLine());
        boolean first = true;
        while(tests-->0)
        {
            read = in.readLine().split("[ ]+");
            n = Integer.parseInt(read[0]);
            m = Integer.parseInt(read[1]);
            grid = new char[n][m];
            for(int i=0;i<n;i++)
                grid[i] = in.readLine().toCharArray();
            answer = false;
            for(int i=0;i<m;i++)
                if(grid[n-1][i] == '@'){
                    bT("", n-1, i, 0);
                    break;
                }
        }

         */

        // 3. Battleships
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int cases = 1;
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            arr = new char[n][n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = br.readLine().toCharArray();
            int ans = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if(arr[i][j] == 'x')
                    {
                        floodFill(i, j);
                        ans++;
                    }
                }
            }
            System.out.print("Case " + cases++ + ": " + ans + "\n");

        }

         */

        // 4. Forming Teams
        /*
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer b= new StringTokenizer(in.readLine());
            int n = Integer.parseInt(b.nextToken());
            int m = Integer.parseInt(b.nextToken());

            graph= new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i]=new ArrayList<>();
            }

            visited= new boolean[n];

            for (int i = 0; i < m; i++) {
                b = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(b.nextToken())-1;
                int y = Integer.parseInt(b.nextToken())-1;
                graph[x].add(y);
                graph[y].add(x);
            }

            int ans=0;

            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    cnt=0;
                    if (dfs(i,-1)&&cnt%2==1)++ans;
                }
            }
            if (((n-ans)&1)!=0)++ans;
        System.out.println(ans);

         */

        // 5. MakeTree - Hierarchy

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int w ,u ,mb = -1;
        for(int i = 1; i <= k; i++){
            w = input.nextInt();
            while(w-- > 0){
                u = input.nextInt();
                inDegree[u]++;
                parent[u] = i;
            }
        }
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0 && mb == -1){
                mb = i;
            }
            else if(inDegree[i] == 0)
                parent[i] = mb;
                System.out.println("value of i : "+parent[i]);
        }
        for(int i = 1;i <= n;++i)
            System.out.println("Value : "+parent[i]);



        // 6. Ordering Tasks
        /*
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int v=in.nextInt();
            int e=in.nextInt();
            if(v == 0 && e == 0)
                break;

            List<Integer>[] g = new List[v];
            int[] ind = new int[v];
            for(int y = 0; y < g.length; y++){
                g[y] = new ArrayList();
            }

            while(e-- > 0){
                int a=in.nextInt()-1;

                int b=in.nextInt()-1;

                g[a].add(b);

                ind[b]++;
            }
            Queue <Integer> q =new LinkedList();

            for(int i = 0; i < ind.length; i++){
                if(ind[i] == 0)
                    q.add(i);
            }
            StringBuilder sb = new StringBuilder();
            boolean t=true;
            int count=0;

            while(!q.isEmpty()){
                int p=q.remove();
                count++;
                if(t){
                    sb.append(p+1);
                    t=false;
                }else
                    sb.append(" "+(p+1));
                for(int y=0;y<g[p].size();y++){
                    int c=g[p].get(y);
                    ind[c]--;
                    if(ind[c] == 0)
                        q.add(c);
                }
            }
            if(count==v)
                System.out.println(sb);
            else
                System.out.println("Impossible");
        }

         */

    }

    // 1. The Seasonal War
    /*
    static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || !war[i][j] || visited[i][j])
            return;
        visited[i][j] = true;
        for (int x = 0; x < 8; x++)
            dfs(i + dx[x], dy[x] + j);

    }

     */

    // 2. Marcus
    /*
    private static void bT(String toPrint, int i, int j, int k) {
        if(answer)return;
        if(k == 7){
            System.out.println(toPrint.trim());
            answer = true;
            return;
        }
        for(int ii=0;ii<dx.length;ii++)
        {
            int uu = i+dx[ii];
            int jj = j+dy[ii];
            if(forContinue(uu, jj, iEhova[k]))
            {
                bT(toPrint+" "+steps[ii], uu, jj, k+1);
                break;
            }
        }
    }

    public static boolean forContinue(int i, int j, char x){
        return i>=0 && i<n && j>=0 && j<m && grid[i][j] == x;
    }

     */

    // 3. Battleships
    /*
    static void floodFill(int x,int y)
    {
        if(!isValid(x, y))
            return;
        if(arr[x][y]!='.')
        {
            arr[x][y] = '.';
            for(int i = 0;i<xx.length;i++)
            {
                floodFill(x+xx[i], y+yy[i]);
            }
        }
    }
    static boolean isValid(int i,int j)
    {
        return i>=0 && j>=0 && i<arr.length && j<arr.length;
    }

     */

    // 4. Forming Teams
    /*
    static boolean dfs(int u, int p){
        visited[u] = true;
        cnt++;
        for(int v:graph[u])
            if(v != p){
                if(visited[v]) return true;
                else if(dfs(v, u))
                    return true;
            }
        return false;
    }

     */

}
