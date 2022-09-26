https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
/*
Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.

Example 1:

Input:
N=3
M=4
A=[[1,0,0,0], 
[1,1,0,1],[0,1,1,1]]
X=2
Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
Example 2:

Input:
N=3
M=4
A=[[1,1,1,1],
[0,0,0,1],[0,0,0,1]]
X=0
Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)->(0,1)->(0,2)->(0,3).

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestDistance() which takes the integer N, M, X, Y, and the 2D binary matrix A as input parameters and returns the minimum number of steps required to go from (0,0) to (X, Y).If it is impossible to go from (0,0) to (X, Y),then function returns -1. If value of the cell (0,0) is 0 (i.e  A[0][0]=0) then return -1.
*/

//bfs - faster  -> gets answer in first go as it considers all paths together

class Solution {
    class QueueNode{
        Point p;
        int dist;
        
        public QueueNode(Point p, int dist){
            this.p=p;
            this.dist=dist;
        }
    }
    class Point{
        int x,y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    boolean isSafe(int[][] A, int m, int n, int x, int y){
        return (x>=0 && x<m && y>=0 && y<n && A[x][y]==1);
        
    }
    
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0]==0)
            return -1;
        boolean[][] visited = new boolean[N][M];
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        Queue<QueueNode> q = new LinkedList<>();
        
        q.add(new QueueNode(new Point(0,0), 0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            QueueNode temp = q.poll();
            int src = temp.p.x;
            int des = temp.p.y;
            if(src == X && des == Y)
                return temp.dist;
            for(int i=0;i<dir.length;i++){
                int newS = src+dir[i][0];
                int newD = des+dir[i][1];
                if(isSafe(A, N, M, newS, newD) && !visited[newS][newD] && A[newS][newD]==1){
                visited[newS][newD] = true;
                q.add(new QueueNode(new Point(newS, newD), temp.dist+1));
                }
            }
            
        }
        return -1;
    }
}

dfs -unefficient

class Solution {
    int[][] dir = new int[][]{{0,-1}, {0,1}, {1,0},{-1,0}};
    int shortestDistance(int m, int n,int src, int des, int A[][], int X, int Y, int minCount, int count) {
        if(src<0 || src>=m || des<0 || des>=n || A[src][des]==0 || A[src][des]==-1){
            return Integer.MAX_VALUE;
        }
       if(X== src && Y==des)
        {
            minCount = Math.min(minCount, count);
            return minCount;
        }

        A[src][des] = -1;
    
        for(int i=0;i<dir.length;i++){
            int newS = src+dir[i][0];
            int newD= des+dir[i][1];
            minCount=Math.min(minCount,shortestDistance(m, n, newS, newD, A, X, Y,minCount, count+1));
        }

       A[src][des] = 1;
        return minCount;
    }
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
       int res= shortestDistance(N, M, 0, 0, A, X, Y, Integer.MAX_VALUE, 0);
       return res==Integer.MAX_VALUE?-1:res;
       }
};
