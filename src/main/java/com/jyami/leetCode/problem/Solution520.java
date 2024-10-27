package com.jyami.leetCode.problem;

import java.util.function.Predicate;

/**
 * Created by jyami on 2020/08/01
 */
public class Solution520 {
    public boolean detectCapitalUse(String word) {
        Predicate<Character> characterFilter;

        if(word.length() == 1)
            return true;

        if(Character.isUpperCase(word.charAt(0))){
            if(Character.isUpperCase(word.charAt(1)))
                characterFilter = Character::isUpperCase;
            else{
                characterFilter = Character::isLowerCase;
            }
        }else {
            characterFilter = Character::isLowerCase;
        }

        for(int i = 1; i< word.length(); i++){
            if(!characterFilter.test(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
