package tech.extropy.shadowbox;

import android.content.Context;
import android.media.MediaPlayer;

import tech.extropy.shadowbox.R;


public class AudioCombinations {

    public MediaPlayer boxingSoundMP;
    public final String TAG = "TAG";

    private int[] allResourcesArray = { R.raw.jab,
                                        R.raw.cross,
                                        R.raw.left_hook,
                                        R.raw.right_uppercut,//3 and 4
                                        R.raw.boxingbell,
                                        R.raw.stop_one_second,//Original
                                        R.raw.back_step,//^
                                        R.raw.jab_backstep,//1^
                                        R.raw.right_hook,//3r
                                        R.raw.pccw,//##
                                        R.raw.cross_body,//2+
                                        R.raw.left_uppercut,//6l
                                        R.raw.close_range,//CR
                                        R.raw.left_hook_body,//4l+
                                        R.raw.fake_cross,//2&
                                        R.raw.left_hook_rollunder,//@@3@@
                                        R.raw.cross_rollingunder,//@@2@@
                                        R.raw.left_uppercut,//5
                                        R.raw.pivot_ccw_lefthook_body,//4l+#
                                        R.raw.right_hook_body,//3r+
                                        R.raw.right_hook,//4
                                        R.raw.leanaway_cross,//!2!
                                        R.raw.rightstep,//%%
                                        R.raw.pivot_ccw_jab,//1##
                                        R.raw.low_righthook,//lr
                                        R.raw.slip_left,//*
                                        R.raw.jab_to_body,//1+
                                        R.raw.right_hook_body,//4+
                                        R.raw.fake_jab,//1&
                                        R.raw.left_step,//%
                                        R.raw.pcw,//#
                                        R.raw.jab_pcw,//1#
                                        R.raw.low_left_hook,//1h
                                        R.raw.righthook_rollunder,//@@3r@@
                                        R.raw.low_cross,//lc
                                        R.raw.lean_jab,//!1!
                                        R.raw.slip_right,//**
                                        R.raw.left_hook_body,//3+
                                        R.raw.righthook_pccw,//3r##
                                        R.raw.lefthook_pcw,//3#
                                        R.raw.righthook_body_pccw,//4+##
                                        R.raw.stop_two_second
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
                playThis[x] = allResourcesArray[0];//Jab
            }
            else if (combination[x].compareTo("2") == 0) {
                playThis[x] = allResourcesArray[1];//Cross
            }
            else if (combination[x].compareTo("3") == 0) {
                playThis[x] = allResourcesArray[2];//Left Hook
            }
            else if (combination[x].compareTo("6") == 0) {
                playThis[x] = allResourcesArray[3];//Right uppercut
            }
            else if(combination[x].compareTo("START_OR_FINISH") == 0){
                playThis[x] = allResourcesArray[4];//Boxing bell
            }
            else if(combination[x].compareTo("stop_one_second") == 0){
                playThis[x] = allResourcesArray[5];//Pause one second
            }
            else if(combination[x].compareTo("^") == 0){
                playThis[x] = allResourcesArray[6];//Back Step
            }
            else if(combination[x].compareTo("1^") == 0){
                playThis[x] = allResourcesArray[7];//Jab Backstep
            }
            else if(combination[x].compareTo("3r") == 0){
                playThis[x] = allResourcesArray[8];//Right Hook
            }
            else if(combination[x].compareTo("##") == 0){
                playThis[x] = allResourcesArray[9];//Pivot Counter Clockwise
            }
            else if(combination[x].compareTo("2+") == 0){
                playThis[x] = allResourcesArray[10];//Cross body
            }
            else if(combination[x].compareTo("6l") == 0){
                playThis[x] = allResourcesArray[11];//Left Uppercut
            }
            else if(combination[x].compareTo("CR") == 0){
                playThis[x] = allResourcesArray[12];//Close Range
            }
            else if(combination[x].compareTo("4l+") == 0){
                playThis[x] = allResourcesArray[13];//Left hook to the body
            }
            else if(combination[x].compareTo("2&") == 0){
                playThis[x] = allResourcesArray[14];//Fake cross
            }
            else if(combination[x].compareTo("@@3@@") == 0){
                playThis[x] = allResourcesArray[15];//Left hook rolling under
            }
            else if(combination[x].compareTo("@@2@@") == 0){
                playThis[x] = allResourcesArray[16];//Cross while rolling under
            }
            else if(combination[x].compareTo("5") == 0){
                playThis[x] = allResourcesArray[17];//Left uppercut
            }
            else if(combination[x].compareTo("4l+#") == 0){
                playThis[x] = allResourcesArray[18];//Pivot Counter Clockwise lefthook body
            }
            else if(combination[x].compareTo("3r+") == 0){
                playThis[x] = allResourcesArray[19];//Right hook to the body
            }
            else if(combination[x].compareTo("4") == 0){
                playThis[x] = allResourcesArray[20];//Right hook
            }
            else if(combination[x].compareTo("!2!") == 0){
                playThis[x] = allResourcesArray[21];//Lean away then cross
            }
            else if(combination[x].compareTo("%%") == 0){
                playThis[x] = allResourcesArray[22];//Right step
            }
            else if(combination[x].compareTo("1##") == 0){
                playThis[x] = allResourcesArray[23];//Pivot counter clockwise then jab
            }
            else if(combination[x].compareTo("lr") == 0){
                playThis[x] = allResourcesArray[24];//Low righthook
            }
            else if(combination[x].compareTo("*") == 0){
                playThis[x] = allResourcesArray[25];//Slip left
            }
            else if(combination[x].compareTo("1+") == 0){
                playThis[x] = allResourcesArray[26];//Jab to the body
            }
            else if(combination[x].compareTo("4+") == 0){
                playThis[x] = allResourcesArray[27];//Right hook to the body
            }
            else if(combination[x].compareTo("1&") == 0){
                playThis[x] = allResourcesArray[28];//Boxing bell
            }
            else if(combination[x].compareTo("%") == 0){
                playThis[x] = allResourcesArray[29];//Left step
            }
            else if(combination[x].compareTo("#") == 0){
                playThis[x] = allResourcesArray[30];//Pivot counter clockwise
            }
            else if(combination[x].compareTo("1#") == 0){
                playThis[x] = allResourcesArray[31];//Jab then pivotcounter clockwise
            }
            else if(combination[x].compareTo("1h") == 0){
                playThis[x] = allResourcesArray[32];//Low left hook
            }
            else if(combination[x].compareTo("@@3r@@") == 0){
                playThis[x] = allResourcesArray[33];//Right hook while rolling under
            }
            else if(combination[x].compareTo("lc") == 0){
                playThis[x] = allResourcesArray[34];//Low cross
            }
            else if(combination[x].compareTo("!1!") == 0){
                playThis[x] = allResourcesArray[35];//Lean away then jab
            }
            else if(combination[x].compareTo("**") == 0){
                playThis[x] = allResourcesArray[36];//Slip right
            }
            else if(combination[x].compareTo("3+") == 0){
                playThis[x] = allResourcesArray[37];//Left hook to the body
            }
            else if(combination[x].compareTo("3r##") == 0){
                playThis[x] = allResourcesArray[38];//Right hook to the body
            }
            else if(combination[x].compareTo("3#") == 0){
                playThis[x] = allResourcesArray[39];//Left hook then pivot clockwise
            }
            else if(combination[x].compareTo("4+##") == 0){
                playThis[x] = allResourcesArray[40];//Right hook to the body then pivot counter clockwise
            }
            else if(combination[x].compareTo("stop_two_second") == 0){
                playThis[x] = allResourcesArray[41];//Pause two second
            }
            else {
                playThis[x] = allResourcesArray[5];//Stop_one_second
            }
        }

        return playThis;
    }

}