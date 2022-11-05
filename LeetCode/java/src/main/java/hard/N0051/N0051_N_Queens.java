package hard.N0051;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int rows[];
    int dig1[];
    int dig2[];
    int n;
    List<List<String>> output = new ArrayList();
    int queens[];

    public boolean isNotUnderAttack(int row, int col){
        int res = rows[col] + dig1[row + col] + dig2[row - col + n];
        return res==0 ? true : false;
    }

    public void placeQueen(int row, int col){
        queens[row] = col;
        rows[col] = 1;
        dig1[row + col] = 1;
        dig2[row - col + n] = 1;
    }

    public void removeQueen(int row, int col){
        queens[row] = 0;
        rows[col] = 0;
        dig1[row + col] = 0;
        dig2[row - col + n] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0 ; i < n ; i++){
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col ; j++){
                sb.append(".");
            }
            sb.append("Q");
            for(int j = 0 ; j < n - col - 1 ; j++){
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row){
        for(int col = 0 ; col < n ; col++){
            if(isNotUnderAttack(row, col)){
                placeQueen(row, col);
                if(row + 1 == n){
                    addSolution();
                }else{
                    backtrack(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n){
        this.n = n;
        rows = new int[n];
        dig1 = new int[2 * n - 1];
        dig2 = new int[2 * n ];
        queens = new int[n];
        backtrack(0);
        return output;
    }
}

public class N0051_N_Queens {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> results = solution.solveNQueens(8);
        for(int i = 0 ; i < results.size() ; i++ ){
            List<String> result = results.get(i);
            System.out.println("Solution " + (i+1));
            for(int j = 0 ; j < result.size() ; j++){
                System.out.println(result.get(j));
            }
            System.out.println();
        }
    }
}
