// Number of Islands
//https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int [][]dir={{-1,0},{0,1},{0,-1},{1,0}};
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
               
                if(grid[i][j]=='1'){
                dfs(grid,i,j,dir);
                     c++;
                }
            }
        }
        return c;
    }
    public void dfs(char[][] grid,int sr,int sc,int[][]dir) {
        grid[sr][sc]='0';
        for(int d=0;d<dir.length;d++)
        {
            
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
             dfs(grid,r,c,dir);
            }
        }
    }
}
//Island Perimeter
//https://leetcode.com/problems/island-perimeter/
class Solution {

    public int islandPerimeter(int[][] grid) {
        int one = 0;
        int nbr = 0;
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    one++;
                    for (int d = 0; d < dir.length; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                            nbr++;
                        }
                    }
                }
            }
        }
        return 4 * one - nbr;
    }
}

//Max Area of Island
//https://leetcode.com/problems/max-area-of-island/
class Solution {
    int max=-(int)1e9;
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                   
                    int size =dfs(grid, i, j, dir);
                    max=Math.max(max,size);
                }
            }
        }
        return max==-(int)1e9?0:max;
    }
    public int dfs(int[][] grid, int sr, int sc, int[][] dir) {
        grid[sr][sc] = 0; int size=0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                
                size+=dfs(grid, r, c, dir);
            }
        }
        return size+1;
    }
}
//Surrounded Regions
class Solution {
    public void solve(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    if (grid[i][j] == 'O') {
                        help(grid, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'v') {
                    grid[i][j] = 'O';
                } else {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public void help(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 'O') {
            return;
        }
        grid[row][col] = 'v';
        help(grid, row + 1, col);
        help(grid, row - 1, col);
        help(grid, row, col - 1);
        help(grid, row, col + 1);
    }
}
//rotten orange
//idx=r*m+c m=col hai
//r=idx/m;
//c=idx%m;
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    list.addLast(i * m + j);
                }
            }
        }
        if (fresh == 0) return 0;
        while (list.size() > 0) {
            int size = list.size();

            while (size-- > 0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        list.addLast(r * m + c);
                        fresh--;
                        if (fresh == 0) {
                            return time + 1;
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
//Shortest Path in Binary Matrix
lass Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<Integer> list = new LinkedList<>();
        int m = grid[0].length;
        int n = grid.length;
        list.add(0);
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int time = 1;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;
                if (sr == n - 1 && sc == m - 1) {
                    return time;
                }
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        list.add(r * m + c);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
//01 Matrix
//boi a zero se kitna dur hai
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        LinkedList<Integer> list = new LinkedList<>();
        int[][] visit = new int[grid.length][grid[0].length];
        int m = grid[0].length;
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    list.add(i * m + j);
                    visit[i][j] = 2;
                }
            }
        }

        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int time = 1;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;

                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && visit[r][c] != 2) {
                        grid[r][c] = grid[sr][sc] + 1;
                        visit[r][c] = 2;
                        list.add(r * m + c);
                    }
                }
            }
        }
        return grid;
    }
}
//kahs hi hai algo
//bas dekh level kar is se kya fayda ak question dekhte hai
//jase kuch machine hai series me chale ge to 10 rs pr head and parrell to jitne marji chala lo 10 hi 
//to ab level same wale ko bas ab same level walo ko parrell me or akale to series maan lo
//ans level * 10 hota
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) 
    {
       int[]count=new int[V];
       int[]ans=new int[V];
       for(int i=0;i<V;i++)
       {
           for(int nbr:graph.get(i)){
              count[nbr]++; 
           }
       }
       LinkedList<Integer>queue=new LinkedList<>();
       for(int i=0;i<count.length;i++)
       {
           if(count[i]==0)
           {
               queue.addLast(i);
           }
       }
       int idx=0;
       int level=0;
       while(queue.size()>0){
           int size=queue.size();
           while(size-->0){
           int rem=queue.removeFirst();
           ans[idx]=rem;
           idx++;
           for(int nbr:graph.get(rem)){
               count[nbr]--;
               if(count[nbr]==0)
               {
                   queue.add(nbr);
               }
           }
           }
           level++;
       }
       if(idx==V){
           return ans;
       }
       return ans=new int[V];
    }
}
//ArrayList me same level ko arraylist to
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) 
    {
       int[]count=new int[V];
       int[]ans=new int[V];
       for(int i=0;i<V;i++)
       {
           for(int nbr:graph.get(i)){
              count[nbr]++; 
           }
       }
       LinkedList<Integer>queue=new LinkedList<>();
       ArrayList<ArrayList<Integer>>list=new ArrayList<>();
       for(int i=0;i<count.length;i++)
       {
           if(count[i]==0)
           {
               queue.addLast(i);
           }
       }
       int idx=0;
       int level=0;
       while(queue.size()>0){
           int size=queue.size();
           ArrayList<Integer>Slist=new ArrayList<>();
           while(size-->0){
           int rem=queue.removeFirst();
           Slist.add(rem);
           ans[idx]=rem;
           idx++;
           for(int nbr:graph.get(rem)){
               count[nbr]--;
               if(count[nbr]==0)
               {
                   queue.add(nbr);
               }
           }
           }
           list.add(Slist);
           level++;
       }
       if(idx==V){
           return ans;
       }
       return ans=new int[V];
    }
}




