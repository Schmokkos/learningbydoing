package no.schweizer.chess;

import java.util.ArrayList;

abstract class MovePiece extends Chess {
    MovePiece(){
        
    }
    private char locationX;
    private int locationY;

    abstract ArrayList getValidMoves();

    MovePiece(int[][] from, int[][] too){

    }

    MovePiece(int[][] from){

    }
}
