package com.example.extropy.shadowbox;

import android.content.Context;
import android.media.MediaPlayer;


public class AudioCombinations {

    public MediaPlayer boxingSoundMP;

    private int[] allResourcesArray = { R.raw.jab,
                                        R.raw.cross,
                                        R.raw.left_hook,
                                        R.raw.right_uppercut,
                                        R.raw.boxingbell,
                                        R.raw.stop_one_second };


    public MediaPlayer getSound(Context currentContext, String combination){

        int playThis;

        if(combination.compareTo("1") == 0){
            playThis = allResourcesArray[0];
        }
        else if (combination.compareTo("2") == 0){
            playThis = allResourcesArray[1];
        }
        else if (combination.compareTo("3") == 0){
            playThis = allResourcesArray[2];
        }
        else if (combination.compareTo("6") == 0){
            playThis = allResourcesArray[3];
        }
        else if(combination.compareTo("START_OR_FINISH") == 0){
            playThis = allResourcesArray[4];
        }
        else {
            playThis = allResourcesArray[5];//Boxing bell
        }

        boxingSoundMP = MediaPlayer.create(currentContext, playThis);

        return boxingSoundMP;
    }

    //NOTE: Create a hash table instead of explicitly declaring each strike.
    public int[] getIntegerSound(Context currentContext, String[] combination){
        int[] playThis = new int[combination.length];

        for(int x = 0; x < combination.length; x++) {

            if (combination[x].compareTo("1") == 0) {
                playThis[x] = allResourcesArray[0];
            }
            else if (combination[x].compareTo("2") == 0) {
                playThis[x] = allResourcesArray[1];
            }
            else if (combination[x].compareTo("3") == 0) {
                playThis[x] = allResourcesArray[2];
            }
            else if (combination[x].compareTo("6") == 0) {
                playThis[x] = allResourcesArray[3];
            }
            else if(combination[x].compareTo("START_OR_FINISH") == 0){
                playThis[x] = allResourcesArray[4];
            }
            else {
                playThis[x] = allResourcesArray[5];//Boxing bell
            }
        }

        return playThis;
    }

}