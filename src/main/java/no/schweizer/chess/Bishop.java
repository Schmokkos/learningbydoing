package no.schweizer.chess;

import java.util.ArrayList;

public class Bishop extends MovePiece implements CanMove {
    public boolean causesCheck() {
        return false;
    }

    public boolean legalMove() {
        return true;
    }

    @Override
    public ArrayList getValidMoves() {
        return null;
    }
}
