package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.limits.SolutionCounter;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.criteria.Criterion;

import java.util.List;

/*public class Sodoku {

    public static void main(String[] args) {
        int n = 9;
        int m = (n/2) - 1;
        // key component of the library, is needed to describe any problem
        Model model = new Model("9*9" + "Sodoku");
        String[] rows = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        // VARIABLES
        IntVar[][] vars = new IntVar[n][n]; // declare an array for creating variables and their domain

        int c=0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // zu erst row, dann ueber die columns
                vars[i][j] = model.intVar("(" + i + "," + j + ")", 1, n*n);
                c++;
            }
        }

        // CONSTRAINTS
        for(int i  = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                // constraint for columns condititions: if queen i is on column k, then any other queens cannot take the value k.
                model.arithm(vars[i], "!=",vars[j]).post(); // post means activate the constraints
                // constraint for the diagonals: if queen i is on column k, the queen i+1 cannot be assigned to k+1 (queen i+m cannot be assigned to k+m)
                model.arithm(vars[i], "!=", vars[j], "-", j - i).post();
                model.arithm(vars[i], "!=", vars[j], "+", j - i).post();
            }
        }

        // Columns Vergleich pro Row
        for (int i=0; i<n-1; i++) {//rows
            for (int j=0; j<n-1; j++) {//columns
                model.arithm(vars[i][j], "!=",vars[i][j+1]).post(); // post means activate the constraints
            }
        }

        // Rows Vergleich pro Column
        for (int i=0; i<n-1; i++) {//columns
            for (int j=0; j<n-1; j++) {//rows
                model.arithm(vars[j][i], "!=",vars[j+1][i]).post();
            }
        }

        // Box Vergleich in Column Iteration
        for (int b=0; b<n; b=b+3) {
            for (int i=0; i<(b+3)-1; i++) {//columns
                for (int j=0; j<(b+3)-1; j++) {//rows
                    model.arithm(vars[i][j], "!=",vars[i][j+1]).post(); // post means activate the constraints
                }
            }
        }

        // SOLUTION
        // now the problem (n-queens) has been described into a model using VARIABLES and CONSTRAINTS, its satisfaction can be evaluated, by trying to solve it.
        Solver solver = model.getSolver();
        //solver.showStatistics();
        solver.setSearch(Search.domOverWDegSearch(vars));
        List<Solution> solutions = solver.findAllSolutions(new SolutionCounter(model, 100));
        if(solutions != null && !solutions.isEmpty()){ // if the solution exists, it is printed on the console
            for (Solution solution : solutions) {
                if (solution != null) {
                    System.out.println(solution.toString());
                }
            }
            System.out.println(solutions.size() + " Solutions found.");
        }
    }
}*/
