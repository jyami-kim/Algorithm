package com.jyami.exam.programmers;

import java.util.Arrays;

public class TechWoowa5 {

    public static void main(String args[]) {
//        String[] history = {"1.0", "2.0", "1.5"};
        String[] history = {"1.0", "2.0", "0.0", "1.0"};

        Solution solution = new Solution();
        int[] result = solution.solution(history);

        for (int res : result) {
            System.out.println(res);
        }


    }

    static class Solution {

        public static Refrigerator myRefrigerator;

        public int[] solution(String[] history) {
            myRefrigerator = new Refrigerator(5, 100, 10, 5, 2);
            Refrigerator recipe = new Refrigerator(4, 50, 10, 10, 4);

            int[] result = new int[history.length];

            for (int i = 0; i < history.length; i++) {
                if (!checkInput(history[i])) {
                    int[] fail = {-1};
                    return fail;
                }
                Double amount = Double.valueOf(history[i]);
                int calculate = calculate(recipe, amount);
                result[i] = calculate;
            }

            return result;
        }

        public boolean checkInput(String input) {
            String[] condition = {"1.0", "1.5", "2.0", "2.5"};
            return Arrays.asList(condition).contains(input);
        }

        public int calculate(Refrigerator recipe, Double amount) {
            int myPayment = 0;
            myPayment = Mart.PIG.byItem(recipe, amount, myPayment);
            myPayment = Mart.ONION.byItem(recipe, amount, myPayment);
            myPayment = Mart.GREEN_ONION.byItem(recipe, amount, myPayment);
            myPayment = Mart.GARLIC.byItem(recipe, amount, myPayment);
            myPayment = Mart.PEPPER.byItem(recipe, amount, myPayment);
            return myPayment;
        }

        class Refrigerator {
            private int pig;
            private int onion;
            private int greenOnion;
            private int garlic;
            private int pepper;

            public Refrigerator(int pig, int onion, int greenOnion, int garlic, int pepper) {
                this.pig = pig;
                this.onion = onion;
                this.greenOnion = greenOnion;
                this.garlic = garlic;
                this.pepper = pepper;
            }

        }


        enum Mart {
            PIG(10, 10000) {
                int byItem(Refrigerator recipe, double amount, int myPayment) {
                    while (recipe.pig * amount > myRefrigerator.pig) {
                        myRefrigerator.pig += Mart.PIG.amount;
                        myPayment += Mart.PIG.price;
                    }
                    myRefrigerator.pig -= recipe.pig * amount;
                    return myPayment;
                }
            },
            ONION(100, 3000) {
                int byItem(Refrigerator recipe, double amount, int myPayment) {

                    while (recipe.onion * amount > myRefrigerator.onion) {
                        myRefrigerator.onion += Mart.ONION.amount;
                        myPayment += Mart.ONION.price;
                    }
                    myRefrigerator.onion -= recipe.onion * amount;
                    return myPayment;
                }
            },
            GREEN_ONION(30, 1000) {
                int byItem(Refrigerator recipe, double amount, int myPayment) {
                    while (recipe.greenOnion * amount > myRefrigerator.greenOnion) {
                        myRefrigerator.greenOnion += Mart.GREEN_ONION.amount;
                        myPayment += Mart.GREEN_ONION.price;
                    }
                    myRefrigerator.greenOnion -= recipe.greenOnion * amount;
                    return myPayment;
                }
            },
            GARLIC(50, 2000) {
                int byItem(Refrigerator recipe, double amount, int myPayment) {
                    while (recipe.garlic * amount > myRefrigerator.garlic) {
                        myRefrigerator.garlic += Mart.GARLIC.amount;
                        myPayment += Mart.GARLIC.price;
                    }
                    myRefrigerator.garlic -= recipe.garlic * amount;
                    return myPayment;
                }
            },
            PEPPER(10, 1000) {
                int byItem(Refrigerator recipe, double amount, int myPayment) {
                    while (recipe.pepper * amount > myRefrigerator.pepper) {
                        myRefrigerator.pepper += Mart.PEPPER.amount;
                        myPayment += Mart.PEPPER.price;
                    }
                    myRefrigerator.pepper -= recipe.pepper * amount;
                    return myPayment;
                }
            };

            private int amount;
            private int price;

            abstract int byItem(Refrigerator recipe, double amount, int myPayment);


            Mart(int amount, int price) {
                this.amount = amount;
                this.price = price;
            }

        }
    }


}
