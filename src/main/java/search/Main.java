package search;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;

import org.chocosolver.solver.explanations.ExplanationEngine;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.assignments.DecisionOperator;
import org.chocosolver.solver.search.strategy.assignments.DecisionOperatorFactory;
import org.chocosolver.solver.search.strategy.decision.Decision;
import org.chocosolver.solver.search.strategy.decision.IntDecision;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.search.strategy.strategy.AbstractStrategy;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.PoolManager;

import java.util.*;
import java.util.stream.IntStream;

import static org.chocosolver.solver.search.strategy.Search.intVarSearch;

public class Main {

    public static void main(String[] args) {
        int n = 6;
        Model model = new Model(n + "-queens problem");
        IntVar[] vars = new IntVar[n];
        for(int q = 0; q < n; q++){
            vars[q] = model.intVar("Q_"+q, 1, n);
        }
        for(int i  = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                model.arithm(vars[i], "!=",vars[j]).post();
                model.arithm(vars[i], "!=", vars[j], "-", j - i).post();
                model.arithm(vars[i], "!=", vars[j], "+", j - i).post();
            }
        }
        Solver solver = model.getSolver();
        solver.showDecisions();
        solver.showStatistics();
        solver.setSearch(Search.randomSearch(vars, 1));


        Solution solution = solver.findSolution();
        if(solution != null){
            System.out.println(solution.toString());
        }
    }
}