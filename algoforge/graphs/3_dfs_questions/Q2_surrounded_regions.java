// https://leetcode.com/problems/surrounded-regions/description/

public class Q2_surrounded_regions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                // boundry elements to #
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O'){ 
                    changeToSymbol(i,j,n,m,board);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                } else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void changeToSymbol(int r, int c, int n, int m, char[][] board){

        board[r][c] = '#';
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir : direction){
            int x = r+ dir[0];
            int y = c+ dir[1];

            if(x>=1 && y>=1 && x<n-1 && y<m-1 && board[x][y]=='O'){
                changeToSymbol(x,y,n,m,board);
            }
        }
    }
}
