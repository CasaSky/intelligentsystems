package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class ZooPlaningOriginal {

    public static void main(String[] args) {
        // key component of the library, is needed to describe any problem
        Model model = new Model("Zoo Planing Original");
        // VARIABLES
        // declare an array for creating variables and their domain
        final IntVar L = model.intVar("L", 1,1);
        final IntVar HB = model.intVar("HB", 2, 4);
        final IntVar A = model.intVar("A", 3, 4);
        final IntVar EL = model.intVar("EL", 2, 4);
        final IntVar H = model.intVar("H", 2, 4);
        final IntVar M = model.intVar("M", 1, 4);
        final IntVar B = model.intVar("B", 1, 4);

        // CONSTRAINTS
        final IntVar[] EL_HB_D = {EL, HB};
        final IntVar[] EL_A_D = {EL, A};
        final IntVar[] EL_B_D = {EL, B};
        final IntVar[] EL_M_D = {EL, M};
        final IntVar[] EL_L_D = {EL, L};
        final IntVar[] M_H_D = {M, H};
        final IntVar[] B_H_D = {B, H};
        final IntVar[] HB_H_D = {HB, H};
        final IntVar[] L_H_D = {L, H};
        final IntVar[] A_H_D = {A, H};
        final IntVar[] HB_L_D = {HB, L};
        final IntVar[] L_A_D = {L, A};
        final IntVar[] M_B_E = {M, B};
        final IntVar[] EL_A_A = {EL, A};
        final IntVar[] L_A_A = {L, A};



        model.post(
                model.allDifferent(EL_HB_D),
                model.allDifferent(EL_A_D),
                model.allDifferent(EL_B_D),
                model.allDifferent(EL_M_D),
                model.allDifferent(EL_L_D),
                model.allDifferent(M_H_D),
                model.allDifferent(B_H_D),
                model.allDifferent(HB_H_D),
                model.allDifferent(L_H_D),
                model.allDifferent(A_H_D),
                model.allDifferent(HB_L_D),
                model.allDifferent(L_A_D),
                model.allEqual(M_B_E),
                model.distance(EL_A_A[0], EL_A_A[1], "!=", 1),
                model.distance(L_A_A[0], L_A_A[1], "!=", 1)
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
