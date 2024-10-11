package Parcial1.P18_04_24.Ej2_PaymentPlan;

public enum PaymentPlanType {
//    Un plan de pagos donde la cantidad máxima de cuotas es 12 y no se aplican bonificaciones

//    Un plan de pagos donde la cantidad máxima de cuotas es 24 y se bonifican al 100% las primeras tres cuotas
//    (Para simplificar el ejercicio no corresponde validar una cantidad mínima de cuotas,
//    si se eligen tres o menos cuotas la bonificación se aplica igual y todas las cuotas serán de $0)

//    Un plan de pagos donde la cantidad máxima de cuotas es 360 y se bonifican al 50% las cuotas pares (la cuota 2, 4, etc.)

    BASIC(12){
        @Override
        public double getAmount(double amount, int numFee){
            return amount;
        }
    },

    FIRST_THREE_FREE(24){
        public double getAmount(double amount, int numFee){
            if(numFee <= 3){
                return 0;
            }
            return amount;
        }
    },

    EVEN_HALF(360){
        public double getAmount(double amount, int numFee){
            if(numFee % 2 == 0){
                return amount/2;
            }
            return amount;
        }
    };

    private final int maxFees;

    PaymentPlanType(int maxFees) {
        this.maxFees = maxFees;
    }

    public boolean isValid(int numFee){
        return numFee>0 && numFee <= maxFees;
    }

    public abstract double getAmount(double amount, int numFee);

}
