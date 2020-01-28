/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row;
    int col;
    int distance;
    Node(int r,int c,int d){
        row=r;
        col=c;
        distance=d;
    }
};

public class Main
{
	public static void main(String[] args) {
	    
	    int[][] grid = {{1,2,3}
	                    ,{4,8,2},{1,5,3}};
	    
		System.out.println(minCost(0,0,3,3,grid));
	}
	
	public static int minCost(int i,int j,int x,int y,int[][] grid){
	    
	  Node first = new Node(i,j,0);  
	  Queue<Node> q= new LinkedList();
	  q.add(first);
	  boolean[][] visited = new boolean[3][3];
	  visited[i][j]=true;
	  
	  while(!q.isEmpty()){
	      
	      Node p = q.poll();
	     
	     //base case
	     if(p.row==x && p.col == y){
	         
	         return p.distance;
	     }
	      
	     //Up
	     if(p.row-1>=0 && visited[p.row-1][p.col]==false){
	         q.add(new Node(p.row-1,p.col,p.distance));
	         visited[p.row-1][p.col]=true;
	     } 
	     //left
	     if(p.col-1>=0 && visited[p.row][p.col-1]==false){
	         q.add(new Node(p.row,p.col-1,p.distance));
	         visited[p.row][p.col-1]=true;
	     } 
	     //down
	     if(p.row+1<3 && visited[p.row+1][p.col]==false){
	         q.add(new Node(p.row+1,p.col,p.distance));
	         visited[p.row+1][p.col]=true;
	     }
	     //right
	     if(p.col+1<3 && visited[p.row][p.col+1]==false){
	         q.add(new Node(p.row,p.col+1,p.distance));
	         visited[p.row][p.col+1]=true;
	     }
	  }
	  return -1;
	}
}
