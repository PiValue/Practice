package com.other.etc;

import java.util.ArrayList;
import java.util.List;


/**
 * Generate list of all valid parenthesis of given length, example, 
 * 
 * length = 6
 * [ ((()))
 *   (()())
 *   (())()
 *   ()(())
 *   ()()()
 * ]
 * 
 * length = 4, 
 * [
 *  (())
 *  ()()
 * ]
 * */
public class AllValidParenthesis {
    public List<String> generate(int length) {
        List<String> list = new ArrayList<>();
        generate(length, 0, "", list);
        return list;
    }
    
    private void generate(int length, int openCount, String exp, List<String> collection) {
        if (length == 0 && openCount == 0) {
            collection.add(exp);
        }
        if (length == 0 || openCount > length || openCount < 0) {
            return;
        }
        generate(length - 1, openCount + 1, exp + "(", collection);
        generate(length - 1, openCount - 1, exp + ")", collection);
    }
    
    public static void main(String[] args) {
        AllValidParenthesis obj = new AllValidParenthesis();
        List<String> list = obj.generate(8);
        list.stream().forEach(System.out::println);
    }
}
