package Guias.guia3.ej8_CellPhone;

import java.util.Arrays;

public class CellPhoneBill {
    private String number;
    protected Call[] calls;
    protected int callsIndex;

    private static final int defaultSize = 10;

    CellPhoneBill(String number) {
        this.number = number;
        this.calls = new Call[defaultSize];
    }

    public void registerCall(String toNumber, int duration) {
        addCall(new Call(number, toNumber, duration));
    }

    private void addCall(Call call) {
        if(callsIndex == calls.length) {
            resize();
        }
        calls[callsIndex++] = call;
    }

    public double processBill() {
        double total = 0;
        for (int i = 0; i < callsIndex; i++) {
            total += calls[i].getCost();
        }
        return total;
    }

    private void resize() {
        calls = Arrays.copyOf(calls, calls.length + defaultSize);
    }

}
