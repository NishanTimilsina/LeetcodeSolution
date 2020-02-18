class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        
        fillColor(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    public void fillColor(int[][] image,int i ,int j, int color,int newColor){
        
        if(i<0 || j<0 || i>=image.length || j>=image[i].length || image[i][j]!=color){
            return;
        }
        image[i][j] = newColor;
        fillColor(image,i+1,j,color,newColor);
        fillColor(image,i-1,j,color,newColor);
        fillColor(image,i,j+1,color,newColor);
        fillColor(image,i,j-1,color,newColor);
    }
}
