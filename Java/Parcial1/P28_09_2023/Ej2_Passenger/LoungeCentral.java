package Parcial1.P28_09_2023.Ej2_Passenger;

public class LoungeCentral {
    private boolean isOpen = true;

    public void openLounges() {
        isOpen = true;
    }

    public void closeLounges() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
