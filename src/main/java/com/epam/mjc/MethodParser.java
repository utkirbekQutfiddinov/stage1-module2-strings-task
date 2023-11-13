package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] a=signatureString.split("[(]");
        String[] a1=a[0].split(" ");
        String[] a2=a[1].substring(0,a[1].length()-1).split(", ");

        List<MethodSignature.Argument> arguments=new ArrayList<>();
        MethodSignature.Argument arg;
        String[] list;

        if (!signatureString.contains("()")){
            for(String s: a2){
                list=s.split(" ");
                arg=new MethodSignature.Argument(list[0],list[1]);
                arguments.add(arg);
            }
        }


        String methodName=a1[a1.length-1];

        MethodSignature result=new MethodSignature(methodName,arguments);

        String returnType=a1[a1.length-2];
        result.setReturnType(returnType);

        if(a1.length>2){
            String accessModifier=a1[0];
            result.setAccessModifier(accessModifier);
        }


        return result;
    }
}
