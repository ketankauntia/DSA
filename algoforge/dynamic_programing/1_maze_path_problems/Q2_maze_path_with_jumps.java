package algoforge.dynamic_programing.1_maze_path_problems;

public class Q2_maze_path_with_jumps {
    

    public static int totalMazePathsWithJumps_rec(int row, int col, int dr, int dc){

        if(row == dr && col == dc){
            return 1;
        }

        int totalWays = 0;
        //vertical jumps
        for(int jump=1; jump<=dr-row; jump++){
            totalWays += totalMazePathsWithJumps_rec(row+jump, col, dr, dc);
        }

        //horizontal jumps
        for(int jump=1; jump>=dc-col; jump++){
            totalWays += totalMazePathsWithJumps_rec(row, col+jump, dr, dc);
        }

        // diagonal jumps
        for(int jump=1; jump <= Math.min(dr-row, dc-col); jump++){
            totalWays += totalMazePathsWithJumps_rec(row+jump, col+jump, dr, dc);
        }

        return totalWays;
    }
}
