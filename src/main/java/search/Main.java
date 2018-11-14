package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.limits.SolutionCounter;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.criteria.Criterion;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int n = 8;
        // key component of the library, is needed to describe any problem
        Model model = new Model(n + "-queens problem");
        // VARIABLES
        IntVar[] vars = new IntVar[n]; // declare an array for creating variables and their domain
        for(int q = 0; q < n; q++){
            // 1 queen for 1 row and question only on their column, so [1,n]
            vars[q] = model.intVar("Q_"+q, 1, n);
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
}
