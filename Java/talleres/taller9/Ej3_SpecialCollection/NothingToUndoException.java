package talleres.taller9.Ej3_SpecialCollection;

public class NothingToUndoException extends RuntimeException {
  private static final String MESSAGE = "Nothing to undo";
    public NothingToUndoException() {
        super(MESSAGE);
    }
}
