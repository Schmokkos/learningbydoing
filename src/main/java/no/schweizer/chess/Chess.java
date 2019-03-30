package no.schweizer.chess;

import java.util.ArrayList;

public class Chess {

    private char[][] board = new char[8][8];
    private ArrayList<Character> deadWhite = new ArrayList<Character>();
    private ArrayList<Character> deadBlack = new ArrayList<Character>();

    public Chess(){
        resetBoard();
        printBoard();
    }

    private void printBoard(){
        System.out.println("---------------------------------");
        for (int i = 0; i < board.length; i++){
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '\u0000') {
                    System.out.print("  | ");
                }
                else System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("---------------------------------");
        }
    }

    private void resetBoard(){
        this.board[0][0] = 'R';
        this.board[0][1] = 'H';
        this.board[0][2] = 'B';
        this.board[0][3] = 'Q';
        this.board[0][4] = 'K';
        this.board[0][5] = 'B';
        this.board[0][6] = 'H';
        this.board[0][7] = 'R';
        this.board[1][0] = 'P';
        this.board[1][1] = 'P';
        this.board[1][2] = 'P';
        this.board[1][3] = 'P';
        this.board[1][4] = 'P';
        this.board[1][5] = 'P';
        this.board[1][6] = 'P';
        this.board[1][7] = 'P';
        this.board[2][0] = '\u0000';
        this.board[2][1] = '\u0000';
        this.board[2][2] = '\u0000';
        this.board[2][3] = '\u0000';
        this.board[2][4] = '\u0000';
        this.board[2][5] = '\u0000';
        this.board[2][6] = '\u0000';
        this.board[2][7] = '\u0000';
        this.board[3][0] = '\u0000';
        this.board[3][1] = '\u0000';
        this.board[3][2] = '\u0000';
        this.board[3][3] = '\u0000';
        this.board[3][4] = '\u0000';
        this.board[3][5] = '\u0000';
        this.board[3][6] = '\u0000';
        this.board[3][7] = '\u0000';
        this.board[4][0] = '\u0000';
        this.board[4][1] = '\u0000';
        this.board[4][2] = '\u0000';
        this.board[4][3] = '\u0000';
        this.board[4][4] = '\u0000';
        this.board[4][5] = '\u0000';
        this.board[4][6] = '\u0000';
        this.board[4][7] = '\u0000';
        this.board[5][0] = '\u0000';
        this.board[5][1] = '\u0000';
        this.board[5][2] = '\u0000';
        this.board[5][3] = '\u0000';
        this.board[5][4] = '\u0000';
        this.board[5][5] = '\u0000';
        this.board[5][6] = '\u0000';
        this.board[5][7] = '\u0000';
        this.board[6][0] = 'p';
        this.board[6][1] = 'p';
        this.board[6][2] = 'p';
        this.board[6][3] = 'p';
        this.board[6][4] = 'p';
        this.board[6][5] = 'p';
        this.board[6][6] = 'p';
        this.board[6][7] = 'p';
        this.board[7][0] = 'r';
        this.board[7][1] = 'h';
        this.board[7][2] = 'b';
        this.board[7][3] = 'q';
        this.board[7][4] = 'k';
        this.board[7][5] = 'b';
        this.board[7][6] = 'h';
        this.board[7][7] = 'r';
        this.deadWhite.clear();
        this.deadBlack.clear();
    }
}
