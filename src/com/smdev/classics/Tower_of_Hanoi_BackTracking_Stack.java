package com.smdev.classics;

import java.util.*;

public class Tower_of_Hanoi_BackTracking_Stack {

    public static void main(String[] args) {
        Stack<Integer> poleA = new Stack();
        poleA.push(3);
        poleA.push(2);
        poleA.push(1);
        Stack<Integer> poleB = new Stack();
        Stack<Integer> poleC = new Stack();

        Stack<Integer>[] initialState = new Stack[]{poleA, poleB, poleC};
        Stack<Stack<Integer>[]> moves = solveTowerOfHanoi(new Stack(), new Stack(), initialState);
        moves.forEach(stack -> System.out.println(Arrays.toString(stack)));
    }

    public static Stack<Stack<Integer>[]> solveTowerOfHanoi(Stack<Stack<Integer>[]> visitedStates, Stack<Stack<Integer>[]> currPath, Stack<Integer>[] state) {
        visitedStates.push(state); // add to history
        currPath.push(state); // add to current path

        List<Stack<Integer>[]> nextStates = calcNextStates(state);
        for (Stack<Integer>[] nextState : nextStates) {
            if (nextState != null && !isVisited(visitedStates, nextState)) {
                solveTowerOfHanoi(visitedStates, currPath, nextState);
                if (isSolved(currPath)) {
                    return currPath; // solution found
                } else {
                    currPath.pop(); // remove from current path
                }
            }
        }
        return currPath;
    }

    private static boolean isSolved(List<Stack<Integer>[]> moves) {
        Stack<Integer>[] lastMove = !moves.isEmpty() ? moves.get(moves.size() - 1) : null;
        return lastMove != null && lastMove[2].size() == 3; // 3 disks on the last pole => solved
    }

    private static List<Stack<Integer>[]> calcNextStates(Stack<Integer>[] currentState) {
        List<Stack<Integer>[]> nextStates = new ArrayList<>();
        nextStates.add(makeMove(currentState, 0, 2));
        nextStates.add(makeMove(currentState, 0, 1));
        nextStates.add(makeMove(currentState, 1, 2));
        nextStates.add(makeMove(currentState, 1, 0));
        nextStates.add(makeMove(currentState, 2, 1));
        nextStates.add(makeMove(currentState, 2, 0));
        return nextStates;
    }

    private static Stack<Integer>[] makeMove(Stack<Integer>[] state, int source, int target) {
        Stack<Integer> sourcePole = state[source];
        if (sourcePole.isEmpty()) {
            return null;
        }

        Stack<Integer>[] nextMove = null;
        Stack<Integer> targetPole = state[target];
        if (targetPole.isEmpty() || sourcePole.peek() < targetPole.peek()) {
            Stack<Integer> poleA = (Stack) state[0].clone();
            Stack<Integer> poleB = (Stack) state[1].clone();
            Stack<Integer> poleC = (Stack) state[2].clone();
            nextMove = new Stack[]{poleA, poleB, poleC};
            nextMove[target].push(nextMove[source].pop());
        }
        return nextMove;
    }

    private static boolean isVisited(List<Stack<Integer>[]> allMoves, Stack<Integer>[] nextMove) {
        for (Stack<Integer>[] move : allMoves) {
            if (Arrays.equals(move, nextMove)) {
                return true;
            }
        }
        return false;
    }
}
