package Guias.guia4.ej5_HTML;

public class LinkText extends FormatText{

    public LinkText(HTMLText elem, String format) {
        super(elem, format);
    }

    @Override
    public String toString() {
        return "<a href: %s>%s</a>".formatted(format, elem.source());
    }
}
