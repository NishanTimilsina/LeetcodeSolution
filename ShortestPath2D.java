//

import java.util.Queue;
  import java.util.LinkedList;
  
  class Node{
    int row;
    int column;
    int distance;
    
     Node(int r,int c,int d){
        row=r;
        column=c;
        distance=d;
    }
};

 

public class Main {
    
    public static void main(String[] args) {
        
        int[][] grid  = {
        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
    };
        System.out.println(getMinDistance(0,0,7,5,grid));
    }
    
    public static int getMinDistance(int i,int j, int x,int y,int[][] grid){
    
        Node firstNode = new Node(i,j,0);
        
        boolean[][] visited = new boolean[10][10];
    
        Queue<Node> q= new LinkedList();
        q.add(firstNode);
        visited[i][j]=true;
        
        while(!q.isEmpty()){
            
            Node p = q.poll();
            
            if(p.row==x && p.column==y){
                return p.distance;
            }
            
            //up
            if((p.row-1>=0)&& (visited[p.row-1][p.column]==false)){
                q.add(new Node(p.row-1,p.column,p.distance+1));
                visited[p.row-1][p.column]=true;
            }
            //down
            if((p.row+1<10) && (visited[p.row+1][p.column]==false)){
                q.add(new Node(p.row+1,p.column,p.distance+1));
                visited[p.row+1][p.column]=true;
            }
            //left
            if((p.column-1>=0) && (visited[p.row][p.column-1]==false)){
                q.add(new Node(p.row,p.column-1,p.distance+1));
                visited[p.row][p.column-1]=true;
            }
            
            //right
            if((p.column+1<10) && (visited[p.row][p.column+1]==false)){
                q.add(new Node(p.row,p.column+1,p.distance+1));
                visited[p.row][p.column+1]=true;
            }
        }
        
        
        return -1;
    }
}
 
