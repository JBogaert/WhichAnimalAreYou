package com.jb_dev.whichanimalareyou.Model;

/**
 * Created by Dad on 9/8/2016.
 */

public class Questions {
    String[] array;

    public Questions() {
            array = new String[5];
            array[0] = "I enjoy eating plenty of greens.";
            array[1] = "I enjoy swimming.";
            array[2] = "I enjoy eating fish.";
            array[3] = "I enjoy fruit.";
            array[4] = "I like being social.";

    }

    public String getQuestion(int i) {
        String questionString = array[i];
        return questionString;
    }
}
