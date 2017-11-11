package com.example.extropy.shadowbox;


import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class BoxingCombinations {
    public final String TAG = "TAG";

    //ORIGINAL ARRAY
    private String[] easyCombinations = {"1-1",
            "1-1-2",
            "1-2",
            "1-2-1",
            "1-2-1-2",
            "1-2-3-2",
            "1-6-3-2"};
    //View all unique orthodox strikes within log
    String[] allComponents = {
            "1", "2", "lc", "3", "lh", "4", "5", "6", "#", "##", "%",
            "%%", "^", "1^", "1-^", "1&", "2&", "*", "**", "1-**", "1-*", "**-1", "*-1",
            "1", "2", "lc", "3r", "lr", "4l", "5r", "6l", "#", "##", "%",
            "%%", "^", "1^", "1-^", "1&", "2&", "*", "**", "1-**", "1-*", "**-1", "*-1",//Training Components SP
            "1-1", "1-2", "1-1-2", "1-2-1", "1-2-1-2", "1-2-3-2", "1-6-3-2",
            "1-3", "6-3", "5-2", "5-2-3", "1-2-3", "1-1-2-3", "1-1-2-3-2",
            "1-3r", "6l-3r", "5r-2", "5r-2-3r", "1-2-3r", "1-1-2-3r", "1-1-2-3r-2",
            "1-1", "1-2", "1-1-2", "1-2-1", "1-2-1-2", "1-2-3r-2", "1-6l-3r-2",//Easy Combinations SP
            "1-1-4+", "1-1+-4", "3-3+-4", "1-3-3-5", "1-1-3-1-2",
            "1-1-3-4+", "2-3+-4+-3", "1-1+-1-2", "1-3-2-3+", "1-6-3-2", "1-2-5-3-2",
            "1-1-4l+", "1-1+-4l", "3r-3r+-4l", "1-3r-3r-5r", "1-1-3r-1-2",
            "1-1-3r-4l+", "2-3r+-4l+-3r", "1-1+-1-2", "1-3r-2-3r+", "1-6l-3r-2", "1-2-5r-3r-2",//Medium SP
            "1-2-!1!-2", "1-2-!1!-2-3-2", "1-2-@@3@@-2", "1-2-@@3@@-!2!-3-2", "1-2-@@3@@-3-2-3",
            "1-2-3-@@2@@-3-2", "1-!1!-2-1-1", "1-!1!-2-3-2", "1#", "1+-^", "4+##", "3#", "2-#-2", "1#-2",
            "1-3-2", "1+-2", "1-2+", "1-2+-3", "4-1+", "^-2", "1&-3", "6-2", "2-2", "CR-6-5-2-1#", "CR-6-3", "CR-6-3#", "CR-4+-3+-2-1-2",
            "CR-rs-5", "CR-1-2-3+-#-4+-4-1", "CR-1-4+-3+-6-1", "CR-4+-6-3-2", "1-^-1","1-^-1-2",
            "1-2-!1!-2", "1-2-!1!-2-3r-2", "1-2-@@3r@@-2", "1-2-@@3r@@-!2!-3r-2",
            "1-2-@@3r@@-3r-2-3r", "1-2-3r-@@2@@-3r-2", "1-!1!-2-1-1", "1-!1!-2-3r-2", "1##",
            "1+-^", "4l+#", "3r##", "2-##-2", "1##-2", "1-3r-2", "1+-2", "1-2+", "1-2+-3r", "4l-1+",
            "4l+-6l-3r-2", "^-2", "1&-3r", "6l-2", "2-2", "CR-6l-5r-2-1##", "CR-6l-3r", "CR-6l-3r##", "CR-4l+-3r+-2-1-2",
            "CR-%%-5r", "CR-1-2-3r+-##-4l+-4l-1", "CR-1-4l+-3r+-6l-1", "1-^-1", "1-^-1-2"//Hard SP
    };

    //Training
    String[] trainingComponents = {"1", "2", "lc", "3", "lh", "4", "5", "6", "#", "##", "%",
            "%%", "^", "1^", "1-^", "1&", "2&", "*", "**", "1-**", "1-*", "**-1", "*-1"};

    //Training Southpaw
    String[] trainingComponentsSP = {"1", "2", "lc", "3r", "lr", "4l", "5r", "6l", "#", "##", "%",
            "%%", "^", "1^", "1-^", "1&", "2&", "*", "**", "1-**", "1-*", "**-1", "*-1"};

    //Easy Combinations
    String[] easyCombinations2 = {"1-1", "1-2", "1-1-2", "1-2-1", "1-2-1-2", "1-2-3-2", "1-6-3-2",
            "1-3", "6-3", "5-2", "5-2-3", "1-2-3", "1-1-2-3", "1-1-2-3-2"};

    //Easy Combinations Southpaw
    String[] easyCombinationsSP = { "1-3r", "6l-3r", "5r-2", "5r-2-3r", "1-2-3r", "1-1-2-3r", "1-1-2-3r-2",
            "1-1", "1-2", "1-1-2", "1-2-1", "1-2-1-2", "1-2-3r-2", "1-6l-3r-2" };

    //Medium Combinations
    String[] mediumCombinations = { "1-1-4+", "1-1+-4", "3-3+-4", "1-3-3-5", "1-1-3-1-2",
            "1-1-3-4+", "2-3+-4+-3", "1-1+-1-2", "1-3-2-3+", "1-6-3-2", "1-2-5-3-2"	};

    //Medium Combinations Southpaw
    String[] mediumCombinationsSP = { "1-1-4l+", "1-1+-4l", "3r-3r+-4l", "1-3r-3r-5r", "1-1-3r-1-2",
            "1-1-3r-4l+", "2-3r+-4l+-3r", "1-1+-1-2", "1-3r-2-3r+", "1-6l-3r-2", "1-2-5r-3r-2" };

    //Hard Combinations
    String[] hardCombinations = { "1-2-!1!-2", "1-2-!1!-2-3-2", "1-2-@@3@@-2", "1-2-@@3@@-!2!-3-2", "1-2-@@3@@-3-2-3",
            "1-2-3-@@2@@-3-2", "1-!1!-2-1-1", "1-!1!-2-3-2", "1#", "1+-^", "4+##", "3#", "2-#-2", "1#-2",
            "1-3-2", "1+-2", "1-2+", "1-2+-3", "4-1+", "^-2", "1&-3", "6-2", "2-2", "CR-6-5-2-1#", "CR-6-3", "CR-6-3#", "CR-4+-3+-2-1-2",
            "CR-%%-5", "CR-1-2-3+-#-4+-4-1", "CR-1-4+-3+-6-1", "CR-4+-6-3-2", "1-^-1","1-^-1-2" };

    //Hard Combinations Southpaw
    String[] hardCombinationsSP = {"1-2-!1!-2", "1-2-!1!-2-3r-2", "1-2-@@3r@@-2", "1-2-@@3r@@-!2!-3r-2",
            "1-2-@@3r@@-3r-2-3r", "1-2-3r-@@2@@-3r-2", "1-!1!-2-1-1", "1-!1!-2-3r-2", "1##",
            "1+-^", "4l+#", "3r##", "2-##-2", "1##-2", "1-3r-2", "1+-2", "1-2+", "1-2+-3r", "4l-1+",
            "4l+-6l-3r-2", "^-2", "1&-3r", "6l-2", "2-2", "CR-6l-5r-2-1##", "CR-6l-3r", "CR-6l-3r##", "CR-4l+-3r+-2-1-2",
            "CR-%%-5r", "CR-1-2-3r+-##-4l+-4l-1", "CR-1-4l+-3r+-6l-1", "1-^-1", "1-^-1-2"};

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
//String[] oneHundredCombinations = new String[202];
        String[] oneHundredCombinations = new String[10002];
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
//                int randomNumber = randomGenerator.nextInt(easyCombinations.length);
//                oneHundredCombinations[count] = easyCombinations[randomNumber];
                int randomNumber = randomGenerator.nextInt(allComponents.length);
                oneHundredCombinations[count] = allComponents[randomNumber];
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

    public void logPrint(String[] test){

        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
        for(String str: test){
            int x = 1;
            if(numbers.get(str) == null) {
                numbers.put(str, x);
            } else {
                x = numbers.get(str);
                numbers.put(str, ++x);
            }
        }
        Set<String> keys = numbers.keySet();
        for(String key: keys){
            Log.d(TAG,"Value of "+key+" is: "+numbers.get(key));
        }
    }
}