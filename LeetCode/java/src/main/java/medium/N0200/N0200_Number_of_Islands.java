package medium.N0200;

class Solution {
    public int numIslands(char[][] grid) {
        int x = 0;
        int y = 0;
        int number = 0;
        while(x < grid.length){
            y=0;
            while(y < grid[0].length){
                if(grid[x][y] == '1') {
                    number++;
                    dfs(x, y, grid);
                }
                y++;
            }
            x++;
        }
        return number;
    }

    public void dfs(int x, int y, char[][] grid){

        if(x < 0 || y < 0 || grid.length <= x || grid[0].length <= y || grid[x][y]=='0'){
            return;
        }

        grid[x][y] = '0';

        dfs(x, y-1, grid);
        dfs(x, y+1, grid);
        dfs(x-1, y, grid);
        dfs(x+1, y, grid);
    }
}

/**
 * https://www.youtube.com/watch?v=cFnUDdi6DeE&feature=emb_logo
 */
public class N0200_Number_of_Islands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char [][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
