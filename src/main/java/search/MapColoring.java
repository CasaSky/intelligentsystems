package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.limits.SolutionCounter;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

import java.util.List;

public class MapColoring {

    public static void main(String[] args) {
       // int n = 7; // Anzahl der Stats
        int m = 3; // Anzahl der Colors {1->red, 2->green, 3->blue}
        // key component of the library, is needed to describe any problem
        Model model = new Model("coloring maps");
        // VARIABLES
        // declare an array for creating variables and their domain
        final IntVar WA = model.intVar("WA", 1, m);
        final IntVar NT = model.intVar("NT", 1, m);
        final IntVar SA = model.intVar("SA", 1, m);
        final IntVar Q = model.intVar("Q", 1, m);
        final IntVar NSW = model.intVar("NSW", 1, m);
        final IntVar V = model.intVar("V", 1, m);
        final IntVar T = model.intVar("T", 1, m);

       IntVar[] vars = {WA, NT, SA, Q, NSW, V, T};

        // CONSTRAINTS
        // 9 adjacent regions, they must have different colors
        final IntVar[] WA_NT = {WA, NT};
        final IntVar[] WA_SA = {WA, SA};
        final IntVar[] NT_SA = {NT, SA};
        final IntVar[] NT_Q = {NT, Q};
        final IntVar[] SA_Q = {SA, Q};
        final IntVar[] SA_NSW = {SA, NSW};
        final IntVar[] SA_V = {SA, V};
        final IntVar[] Q_NSW = {Q, NSW};
        final IntVar[] NSW_V = {NSW, V};

        model.post(
                model.allDifferent(WA_NT),
                model.allDifferent(WA_SA),
                model.allDifferent(NT_SA),
                model.allDifferent(NT_Q),
                model.allDifferent(SA_Q),
                model.allDifferent(SA_NSW),
                model.allDifferent(SA_V),
                model.allDifferent(Q_NSW),
                model.allDifferent(NSW_V)
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
