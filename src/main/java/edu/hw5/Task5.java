package edu.hw5;

public class Task5 {
    private Task5() {
    }

    public static boolean carPlateChecker(String carPlate) {
        return carPlate.matches("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}[1-9]\\d{2}");
    }
}
