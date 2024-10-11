package Parcial1.P18_04_24.Ej2_PaymentPlan;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PaymentPlan implements Iterator<PaymentDetail> {
    private final PaymentPlanType planType;
    private final double feeAmount;
    private final int feesAmount;
    private int payedFees;

    public PaymentPlan(PaymentPlanType planType, double finalAmount, int feesAmount) {
        if(!planType.isValid(feesAmount) || finalAmount <= 0) {
            throw new InvalidPaymentPlanException();
        }
        this.planType = planType;
        this.feeAmount = finalAmount/feesAmount;
        this.feesAmount = feesAmount;
        this.payedFees = 0;
    }

    @Override
    public boolean hasNext() {
        return payedFees < feesAmount;
    }


    public PaymentDetail peek() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return new PaymentDetail(payedFees+1, planType.getAmount(feeAmount, payedFees+1));
    }

    @Override
    public PaymentDetail next() {
        PaymentDetail ans = peek();
        payedFees++;
        return ans;
    }
}
