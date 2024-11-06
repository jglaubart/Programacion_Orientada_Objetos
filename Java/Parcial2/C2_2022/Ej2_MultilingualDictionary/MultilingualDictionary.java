package Parcial2.C2_2022.Ej2_MultilingualDictionary;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MultilingualDictionary {
    private final Language language;
    private final Map<Language, Map<String, String>> wordsPerLanguage;

    public MultilingualDictionary(Language l){
        this.language = l;
        this.wordsPerLanguage = new EnumMap<>(Language.class);   //porque las keys son de tipo enum
    }

    public MultilingualDictionary addTranslation(String word, Language newLang, String traduction){
        if(newLang.equals(this.language)){
            throw new IllegalArgumentException("Cannot add %s translations".formatted(newLang));
        }
        wordsPerLanguage.putIfAbsent(newLang, new HashMap<>());
        wordsPerLanguage.get(newLang).putIfAbsent(word, traduction);
        return this;
    }

    public String getTranslation(String word, Language language){
        if(!wordsPerLanguage.getOrDefault(language, new HashMap<>()).containsKey(word)){
            throw new NoSuchElementException("No %s translation for %s".formatted(language, word));
        }
        return wordsPerLanguage.get(language).get(word);
    }

    public int translationsCount(Language lang){
        return wordsPerLanguage.getOrDefault(lang, new HashMap<>()).size();
    }

    public int removeTranslations(Language lang){
        if(!wordsPerLanguage.containsKey(lang)){
            return 0;
        }
        int removed = wordsPerLanguage.get(lang).size();
        wordsPerLanguage.remove(lang);
        return removed;
    }
}
