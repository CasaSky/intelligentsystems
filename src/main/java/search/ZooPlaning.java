package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class ZooPlaning {

    public static void main(String[] args) {
        // key component of the library, is needed to describe any problem
        Model model = new Model("Zoo Planing");
        // VARIABLES
        // declare an array for creating variables and their domain
        final IntVar EL = model.intVar("EL", 2, 4);
        final IntVar HB = model.intVar("HB", 2, 4);
        final IntVar A = model.intVar("A", 3, 4);

       IntVar[] vars = {EL, HB, A};

        // CONSTRAINTS
        final IntVar[] EL_HB = {EL, HB};
        final IntVar[] EL_A = {EL, A};

        model.post(
                model.allDifferent(EL_HB),
                model.allDifferent(EL_A),
                model.distance(EL, A, "!=", 1)
        );

        // SOLUTION
        // now the problem (map coloring) has been described into a model using VARIABLES and CONSTRAINTS, its satisfaction can be evaluated, by trying to solve it.
        Solver solver = model.getSolver();
        solver.showDecisions();
        solver.showStatistics();
        Solution solution = solver.findSolution();
        if (solution != null) {
            System.out.println(solution.toString());
        }
        //solver.setSearch(Search.domOverWDegSearch(vars));
        /*List<Solution> solutions = solver.findAllSolutions(new SolutionCounter(model, 100));
        if(solutions != null && !solutions.isEmpty()){ // if the solution exists, it is printed on the console
            for (Solution solution : solutions) {
                if (solution != null) {
                    System.out.println(solution.toString());
                }
            }
            System.out.println(solutions.size() + " Solutions found.");
        }*/
    }
}
