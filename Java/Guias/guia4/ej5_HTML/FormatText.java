package Guias.guia4.ej5_HTML;

public class FormatText extends BasicText{

    protected HTMLText elem;    //puede ser o
    protected String format;

    public FormatText(HTMLText elem, String format) {
        this.elem = elem;
        this.format = format;
    }

    @Override
    public String source(){
        return "<%s>%s<%s>".formatted(format, elem.source(), format);
    }
}
