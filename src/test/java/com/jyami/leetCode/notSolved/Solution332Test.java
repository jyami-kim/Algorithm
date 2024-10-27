package com.jyami.leetCode.notSolved;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution332Test {
    @Test
    void findItineraryTest() {
        List<List<String>> input = Arrays.asList(
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("ORD", "PHL"),
            Arrays.asList("JFK", "ORD"),
            Arrays.asList("PHX", "LAX"),
            Arrays.asList("LAX", "JFK"),
            Arrays.asList("PHL", "ATL"),
            Arrays.asList("ATL", "PHX"));

        //["JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"]


//        List<List<String>> input = Arrays.asList(
//                Arrays.asList("JFK", "SFO"),
//                Arrays.asList("JFK", "ATL"),
//                Arrays.asList("SFO", "ATL"),
//                Arrays.asList("ATL", "JFK"),
//                Arrays.asList("ATL", "SFO"));

        //["JFK","ATL","JFK","SFO","ATL","SFO"]

//        List<List<String>> input = Arrays.asList(
//                Arrays.asList("MUC", "LHR"),
//                Arrays.asList("JFK", "MUC"),
//                Arrays.asList("SFO", "SJC"),
//                Arrays.asList("LHR", "SFO"));
        // ["JFK", "MUC", "LHR", "SFO", "SJC"]

        System.out.println(new Solution332().findItinerary(input));
    }

}
