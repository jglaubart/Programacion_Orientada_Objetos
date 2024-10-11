package talleres.taller4.ej4_Comparable;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public int compareTo(PhoneNumber o) {
        int result = Integer.compare(areaCode, o.areaCode);
        if (result == 0) {
            result = Integer.compare(prefix, o.prefix);
            if (result == 0) {
                result = Integer.compare(lineNumber, o.lineNumber);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", prefix=" + prefix +
                ", lineNumber=" + lineNumber +
                '}';
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getPrefix() {
        return prefix;
    }
}
