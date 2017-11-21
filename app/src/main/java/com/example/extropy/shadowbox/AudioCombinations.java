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
                                        R.raw.stop_one_second,//Original
                                        R.raw.back_step,
                                        R.raw.jab_backstep,
                                        R.raw.right_hook,
                                        R.raw.ppcw,
                                        R.raw.cross_body,
                                        R.raw.left_uppercut,
                                        R.raw.close_range,
                                        R.raw.left_hook_body,
                                        R.raw.fake_cross,
                                        R.raw.left_hook_rollunder,
                                        R.raw.cross_rollingunder,
                                        R.raw.left_uppercut,
                                        R.raw.pivot_ccw_lefthook_body,
                                        R.raw.right_hook_body,
                                        R.raw.right_hook,
                                        R.raw.leanaway_cross,
                                        R.raw.rightstep,
                                        R.raw.pivot_ccw_jab,
                                        R.raw.low_righthook
                                        R.raw.slip_left,
                                        R.raw.jab_to_body,
                                        R.raw.right_hook_body,
                                        R.raw.fake_jab,
                                        R.raw.left_step,
                                        R.raw.pcw,
                                        R.raw.jab_pcw,
                                        R.raw.low_left_hook,
                                        R.raw.righthook_rollunder,
                                        R.raw.low_cross,
                                        R.raw.lean_jab,
                                        R.raw.slip_right,
                                        R.raw.left_hook_body,
                                        R.raw.righthook_pccw,
                                        R.raw.lefthook_pcw,
                                        R.raw.righthook_body_pccw
                                        };


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