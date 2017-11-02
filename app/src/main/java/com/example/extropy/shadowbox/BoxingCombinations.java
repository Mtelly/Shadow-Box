package com.example.extropy.shadowbox;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoxingCombinations {
    //Fields
    private String[] easyCombinations = {"1-1",
                                          "1-1-2",
                                          "1-2",
                                          "1-2-1",
                                          "1-2-1-2",
                                          "1-2-3-2",
                                          "1-6-3-2"};
    //southPawEasyCombo = 1-1, ....., "1-2-[3]-2", "1-[6]-3-2"

    //mediumCombinations
    //southPawMediumCombo

    //hardCombinations
    //southPawHardCombo
    private String startOrFinishBell = "START_OR_FINISH";

    private String[] restTime = {"stop_one_second",
                                 "stop_two_second",
                                 "stop_three_second",
                                 "stop_four_second",
                                 "stop_five_second",
                                 "stop_ten_second" };

    private int difficulty = 0;
    private Random randomGenerator = new Random();
    public int[] combinationLengthInt;

    //Methods
    /*Returns an String array with each individual punch and restTime for every element element*/
    public String[] splitPunchString(String[] combination) {

        String[] containsHyphen;
        String bellOrStop;
        List<String> removedHyphenList = new ArrayList<String>();
        String[] removedHyphenArray;
        int iterateStringArray = 0;
        ArrayList<Integer> combinationLength = new ArrayList<Integer>();

        while(iterateStringArray < combination.length) {

            int testBell = combination[iterateStringArray].compareTo("START_OR_FINISH");
            int testRest = combination[iterateStringArray].compareTo("stop_one_second");

            if((testBell != 0) && (testRest != 0)) {

                containsHyphen = combination[iterateStringArray].split("-");
                int count = 0;

                do {
                    if (containsHyphen[count].compareTo("-") != 0) {

                        removedHyphenList.add(containsHyphen[count]);

                    }

                    count++;

                } while (count < containsHyphen.length);

                iterateStringArray++;
                combinationLength.add(removedHyphenList.size());

            }
            else {

                bellOrStop = combination[iterateStringArray];
                removedHyphenList.add(bellOrStop);
                combinationLength.add(1);
                iterateStringArray++;

            }
        }

        removedHyphenArray = removedHyphenList.toArray(new String[0]);
        combinationLengthInt = convertIntegers(combinationLength);

        return removedHyphenArray;
    }

    public String[] getManyCombinations() {

        String[] oneHundredCombinations = new String[202];
        int count = 0;

        while(count < oneHundredCombinations.length){

            if(count == 0){

                oneHundredCombinations[count] = startOrFinishBell;
                count += 1;

            }
            else if(count == oneHundredCombinations.length - 1){

                oneHundredCombinations[count] = startOrFinishBell;
                count += 1;

            }
            else {
                /*Assigns a random combo. Then gives a rest time afterward.*/
                int randomNumber = randomGenerator.nextInt(easyCombinations.length);
                oneHundredCombinations[count] = easyCombinations[randomNumber];
                oneHundredCombinations[count + 1] = restTime[0];
                count += 2;
            }
        }

        return oneHundredCombinations;
    }

    public static int[] convertIntegers(List<Integer> integers)
    {

        int[] ret = new int[integers.size()];

        for (int i=0; i < ret.length; i++)
        {

            ret[i] = integers.get(i).intValue();

        }

        return ret;
    }

}