package edu.hm.gaertner.simon.lab23.a63;

/**
 * @version 2023-05-30
 */
public record Scaler(double fromX, double fromY, double toX, double toY) {
    double map(double x) {
        return (x - fromX)/(toX - fromX)*(toY - fromY) + fromY;
    }
}
