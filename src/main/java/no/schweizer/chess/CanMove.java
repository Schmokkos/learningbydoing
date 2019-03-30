package no.schweizer.chess;

public interface CanMove {
    boolean causesCheck();
    boolean legalMove();
}
