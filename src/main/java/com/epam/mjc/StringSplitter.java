package com.epam.mjc;

import java.util.ArrayList;
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
        String del=null;
        int i=0;

        for(String delimeter: delimiters){
            if(i==0){
                del=delimeter;
                i++;
            }
            source = source.replaceAll(delimeter, del);
        }

        assert del != null;
        String[] result=source.split(del);
        List<String> res=new ArrayList<>();

        for (String s:result){
            if(!s.trim().equals("")){
                res.add(s.trim());
            }
        }

        return res;
    }
}
