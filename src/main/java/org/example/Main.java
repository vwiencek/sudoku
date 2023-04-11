package org.example;

public class Main {
    public static void main(String[] args) {
        Sudoku s = new Sudoku(new Integer[][]{
                {9,4,2,1,6,3,8,5,7},
                {5,3,6,2,8,7,9,4,1},
                {8,7,1,9,5,4,2,3,6},
                {3,2,7,8,1,9,4,6,5},
                {1,5,4,3,2,6,7,9,8},
                {6,9,8,7,4,5,1,2,3},
                {2,6,5,4,7,1,3,8,9},
                {7,8,9,6,3,2,5,1,4},
                {4,1,3,5,9,8,6,7,2}
        });

        System.out.println(s.isValid());
        s.display();

        s = new Sudoku(new Integer[][]{
                {1,2,3,0,0,0,0,0,0},
                {4,5,6,0,0,0,0,0,0},
                {7,8,9,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        });

        System.out.println(s.isValid());
        System.out.println(s.isMoveValid(4,4,8));
    }
}