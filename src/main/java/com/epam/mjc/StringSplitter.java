package com.epam.mjc;

import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String[] dels=(String[])delimiters.toArray();
        String del=dels[0];


        for(String delimeter: dels){
            source = source.replaceAll(delimeter, del);
        }

        String[] result=source.split(del);

        return List.of(result);
    }
}
