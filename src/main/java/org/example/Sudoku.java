package org.example;

import java.util.Arrays;

public class Sudoku {
    private Integer[][] s;

    public Sudoku(Integer[][] values){
        this.s = values;
    }

    public boolean isMoveValid(int i, int j, int value){
        Integer[][] copy = new Integer[9][9];
        System.arraycopy(s, 0, copy, 0, s.length);

        copy[i-1][j-1]=value;
        return new Sudoku(copy).isValid();
    }

    public boolean isValid(){
        boolean returnValue = true;
        for (int i = 0 ; i < 9 ; i ++){
            if (!isListCorrect(s[i])){
                System.out.println("   => row "+(i+1)+" is invalid");
                returnValue = false;
            }

            if (!isListCorrect(new Integer[]{
                    s[0][i],s[1][i],s[2][i],
                    s[3][i],s[4][i],s[5][i],
                    s[6][i],s[7][i],s[8][i]
            })) {
                System.out.println("   => column "+(i+1)+" is invalid");
                returnValue = false;
            }
        }

        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j ++){
                if (!isListCorrect(new Integer[]{
                        s[3 * i][3 * j], s[3 * i][3 * j + 1], s[3 * i][3 * j + 2],
                        s[3 * i + 1][3 * j], s[3 * i + 1][3 * j + 1], s[3 * i + 1][3 * j + 2],
                        s[3 * i + 2][3 * j], s[3 * i + 2][3 * j + 1], s[3 * i + 2][3 * j + 2]
                })){
                    System.out.println("   => inner square ("+(i+1)+","+(j+1)+") is invalid");
                    returnValue = false;
                }
            }
        }

        return returnValue;
    }

    public void display(){
        for (int i = 0 ; i < 9 ; i ++) {
            for (int j = 0; j < 9; j++) {
                if (s[i][j] == 0){
                    System.out.print(" . ");
                }
                else {
                    System.out.print(" " + s[i][j]+ " ");
                }
                if (j % 3 == 2) System.out.print("  ");
            }
            if (i % 3 == 2) System.out.print("\n");
            System.out.print("\n");
        }
    }

    private boolean isListValid(Integer[] list){
        var l = Arrays.asList(list);
        return l.size() == 9
                && l.stream().min(Integer::compare).get() >= 0
                && l.stream().max(Integer::compare).get() <= 9;
    }

    private boolean isListComplete(Integer[] list){
        var l = Arrays.asList(list);
        return isListValid(list) && !l.contains(0);
    }
    private boolean isListCorrect(Integer[] list){
        var l = Arrays.asList(list);
        return  l.stream().filter(integer -> integer == 1).count() <= 1
                && l.stream().filter(integer -> integer == 2).count() <= 1
                && l.stream().filter(integer -> integer == 3).count() <= 1
                && l.stream().filter(integer -> integer == 4).count() <= 1
                && l.stream().filter(integer -> integer == 5).count() <= 1
                && l.stream().filter(integer -> integer == 6).count() <= 1
                && l.stream().filter(integer -> integer == 7).count() <= 1
                && l.stream().filter(integer -> integer == 8).count() <= 1
                && l.stream().filter(integer -> integer == 9).count() <= 1
                && ( (isListComplete(list) && l.stream().mapToInt(Integer::intValue).sum() == 45)
                || !isListComplete(list));
    }
}