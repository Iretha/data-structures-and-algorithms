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
        List<Stack<Integer>[]> moves = solveTowerOfHanoi(new Stack(), new Stack(), initialState);
        moves.forEach(stack -> System.out.println(Arrays.toString(stack)));
    }

    public static List<Stack<Integer>[]> solveTowerOfHanoi(Stack<Stack<Integer>[]> visitedStates, Stack<Stack<Integer>[]> currentMoves, Stack<Integer>[] poles) {
        visitedStates.push(poles);
        currentMoves.push(poles);

        Set<Stack<Integer>[]> nextPossibleMoves = calcNextPossibleMoves(poles);
        for (Stack<Integer>[] move : nextPossibleMoves) {
            if (move != null && !isVisited(visitedStates, move)) {
                solveTowerOfHanoi(visitedStates, currentMoves, move);
                if (!isSolutionFound(currentMoves)) {
                    currentMoves.pop();
                } else {
                    return currentMoves;
                }
            }
        }
        return currentMoves;
    }

    private static boolean isSolutionFound(List<Stack<Integer>[]> moves) {
        Stack<Integer>[] lastMove = !moves.isEmpty() ? moves.get(moves.size() - 1) : null;
        return lastMove != null && lastMove[2].size() == 3;
    }

    private static Set<Stack<Integer>[]> calcNextPossibleMoves(Stack<Integer>[] currentState) {
        Set<Stack<Integer>[]> possibleMoves = new HashSet<>();
        possibleMoves.add(calcMove(currentState, 0, 2));
        possibleMoves.add(calcMove(currentState, 0, 1));
        possibleMoves.add(calcMove(currentState, 1, 2));
        possibleMoves.add(calcMove(currentState, 1, 0));
        possibleMoves.add(calcMove(currentState, 2, 1));
        possibleMoves.add(calcMove(currentState, 2, 0));
        return possibleMoves;
    }

    private static Stack<Integer>[] calcMove(Stack<Integer>[] initialState, int source, int target) {
        Stack<Integer> sourcePole = initialState[source];
        if (sourcePole.isEmpty()) {
            return null;
        }

        Stack<Integer>[] nextMove = null;
        Stack<Integer> targetPole = initialState[target];
        if (targetPole.isEmpty() || sourcePole.peek() < targetPole.peek()) {
            Stack<Integer> poleA = (Stack) initialState[0].clone();
            Stack<Integer> poleB = (Stack) initialState[1].clone();
            Stack<Integer> poleC = (Stack) initialState[2].clone();
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
