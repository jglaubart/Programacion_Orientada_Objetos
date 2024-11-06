package Parcial2.RepasoParcial2.Ej6_RateLimitedCache;

public enum QuotaType {
    LIMITED{
        @Override
        public boolean canRead(int dayReads){
            return dayReads < 2;
        }

        @Override
        public boolean canWrite(int dayWrites){
            return dayWrites == 0;
        }
    },
    UNLIMITED{
        public boolean canRead(int dayReads){
            return true;
        }
        public boolean canWrite(int dayWrites){
            return true;
        }
    };

    public abstract boolean canRead(int dayReads);
    public abstract boolean canWrite(int dayWrites);
}
