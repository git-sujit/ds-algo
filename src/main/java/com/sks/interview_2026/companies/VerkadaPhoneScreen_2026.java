package com.sks.interview_2026.companies;

//package org.example;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;

/*
Imagine you have a camera installed in your building which is able to detect motion. The camera outputs a stream of timestamps and a value indicating the motion intensity at that time.
You collect this data and want to analyze it to determine the periods of time at which motion was at or above a certain threshold.

Write a function which takes an array of sorted (timestamp, motion_intensity) pairs and then outputs the periods of time where motion was at or above a certain threshold (which is between 0 and 1). Your output should be an array of timestamp pairs where the first value is the start of the period at or above the threshold and the last value is the end of that period (inclusive).
*/


import java.util.*;

class VerkadaPhoneScreen_2026 {

    static class Item {
        public int time;
        public double intensity;

        public Item(int time, double intensity) {
            this.time = time;
            this.intensity = intensity;
        }
    }

    static class MotionPeriod {
        public int start;
        public int end;

        public MotionPeriod(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "MotionPeriod<" + this.start + ", " + this.end + ">";
        }
    }

    public static void main(String[] args) {
        double threshold = 0.8;
    /*
    cameraOutput example: [(1, 0.4), (5, 0.2), (11, 0.9), (15, 0.9), (17, 0.8), (25, 0.5), (27, 0.8), (36, 0.9)]
    */
        List<Item> cameraOutput = new ArrayList<Item>();
        cameraOutput.add(new Item(1, 0.4));
        cameraOutput.add(new Item(5, 0.2));
        cameraOutput.add(new Item(11, 0.9));
        cameraOutput.add(new Item(15, 0.9));
        cameraOutput.add(new Item(17, 0.8));
        cameraOutput.add(new Item(25, 0.5));
        cameraOutput.add(new Item(27, 0.8));
        cameraOutput.add(new Item(36, 0.9));

        List<MotionPeriod> output = motionPeriodsForCamera(cameraOutput, threshold);

        /* Expected output: [(11, 17), (27, 36)] */
        List<MotionPeriod> expected = new ArrayList<MotionPeriod>();
        expected.add(new MotionPeriod(11,17));
        expected.add(new MotionPeriod(27,36));

        System.out.println("Output:");
        System.out.println(output);
        System.out.println("Expected:");
        System.out.println(expected);

        //testCameraIntersection();
        threshold = 0.8;
/*
      Example 1:
      [
        [(2, 0.5), (7, 0.8), (10, 0.9), (11, 0.9), (16, 0.4)], => [7, 11]
        [(5, 0.8), (8, 0.9), (9, 0.8), (13, 0.5), (20, 0.5)],  => [5, 9] => [7, 9]
        [(6, 0.1), (7, 0.8), (8, 0.9), (17, 0.8)].             => [7, 17] => [7, 9]
      ]

      Expected output: [(7, 9)]
    */

        ArrayList<ArrayList<Item>> cameraOutputs = new ArrayList<ArrayList<Item>>();
        ArrayList<Item> camera1 = new ArrayList<>();
        camera1.add(new Item(2, 0.5));
        camera1.add(new Item(7, 0.8));
        camera1.add(new Item(10, 0.9));
        camera1.add(new Item(11, 0.9));
        camera1.add(new Item(16, 0.4));

        ArrayList<Item> camera2 = new ArrayList<>();
        camera2.add(new Item(5, 0.8));
        camera2.add(new Item(8, 0.9));
        camera2.add(new Item(9, 0.8));
        camera2.add(new Item(13, 0.5));
        camera2.add(new Item(20, 0.5));

        ArrayList<Item> camera3 = new ArrayList<>();
        camera3.add(new Item(6, 0.1));
        camera3.add(new Item(7, 0.8));
        camera3.add(new Item(8, 0.9));
        camera3.add(new Item(17, 0.8));

        cameraOutputs.add(camera1);
        cameraOutputs.add(camera2);
        cameraOutputs.add(camera3);

        //List<MotionPeriod> output = motionPeriodsForCameras(cameraOutputs, threshold);
        output = motionPeriodsForCameras(cameraOutputs, threshold);

        //ArrayList<MotionPeriod> expected = new ArrayList<MotionPeriod>();
        expected = new ArrayList<MotionPeriod>();
        expected.add(new MotionPeriod(7,9));

        System.out.println("-- Example 1 --");
        System.out.println("Output:");
        System.out.println(output);
        System.out.println("Expected:");
        System.out.println(expected);

        /**
         Example 2:
         [
         [(2, 0.9), (7, 0,9), (10, 0.5), (11, 0.9), (14, 0.9)], => [[2,7], [11, 14]]
         [(5, 0.9), (11, 0.9)], => [[5, 11]] => [[5, 7], [11, 11]]
         [(1, 0.8), (8, 0.9), (11, 0.9), (21, 0.9)] => [1, 21]
         ]

         Expected output: [(5, 7), (11, 11)]
         **/

        cameraOutputs = new ArrayList<ArrayList<Item>>();
        camera1 = new ArrayList<>();
        camera1.add(new Item(2, 0.9));
        camera1.add(new Item(7, 0.9));
        camera1.add(new Item(10, 0.5));
        camera1.add(new Item(11, 0.9));
        camera1.add(new Item(14, 0.9));

        camera2 = new ArrayList<>();
        camera2.add(new Item(5, 0.9));
        camera2.add(new Item(11, 0.9));

        camera3 = new ArrayList<>();
        camera3.add(new Item(1, 0.8));
        camera3.add(new Item(8, 0.9));
        camera3.add(new Item(11, 0.9));
        camera3.add(new Item(21, 0.9));

        cameraOutputs.add(camera1);
        cameraOutputs.add(camera2);
        cameraOutputs.add(camera3);

        output = motionPeriodsForCameras(cameraOutputs, threshold);

        expected = new ArrayList<MotionPeriod>();
        expected.add(new MotionPeriod(5, 7));
        expected.add(new MotionPeriod(11, 11));

        System.out.println("-- Example 2 --");
        System.out.println("Output:");
        System.out.println(output);
        System.out.println("Expected:");
        System.out.println(expected);

    }

    //(1, 0.4), (5, 0.2), (11, 0.9), (15, 0.9), (17, 0.8), (25, 0.5), (27, 0.8), (36, 0.9)]
    public static List<MotionPeriod> motionPeriodsForCamera(List<Item> cameraOutput, double threshold) {
        List<MotionPeriod> output = new ArrayList<>();
        //Boundary condition check
        if(cameraOutput ==null || cameraOutput.size()==0 || threshold<0||threshold>1) return output;
        int start = -1;
        int end = -1;
        for(int i=0; i<cameraOutput.size(); i++){
            Item item = cameraOutput.get(i);
            if(item.intensity >= 0.8){
                if(start == -1 )start = item.time;
                end = item.time;
            }  else{
                if(start != -1 && end != -1){
                    output.add(new MotionPeriod(start, end));
                    start = -1;
                    end = -1;
                }
            }
            if(i==cameraOutput.size()-1) output.add(new MotionPeriod(start, end));

        }
        return output;
    }
    // private static void testCameraIntersection(){


    //}

    public static List<MotionPeriod> motionPeriodsForCameras(ArrayList<ArrayList<Item>> cameraOutput, double threshold) {
        // TODO: Write solution here
        System.out.println("Inside motionPeriodsForCameras");
        List<MotionPeriod> output = new ArrayList<MotionPeriod>();
        if(cameraOutput == null || cameraOutput.size() == 0 || threshold < 0 | threshold>1) return output;
        List<List<MotionPeriod>> camerasAboveThreshold = new ArrayList<>();

        for(int i =0; i<cameraOutput.size(); i++){
            camerasAboveThreshold.add(motionPeriodsForCamera(cameraOutput.get(i), threshold));
        }
        if(camerasAboveThreshold == null || camerasAboveThreshold.size()==0) return output;

        output = camerasAboveThreshold.get(0);
        if(camerasAboveThreshold.size()>1){
            for(int i=1; i< camerasAboveThreshold.size(); i++){

                output = intersectionMotions(output, camerasAboveThreshold.get(i));
            }}
        System.out.println("Inside motionPeriodsForCameras, final output = "+output);
        return output;
    }


    private static List<MotionPeriod> intersectionMotions(List<MotionPeriod> list1, List<MotionPeriod> list2){
        int i=0, j=0;
        List<MotionPeriod> output = new ArrayList<>();
        while(i<list1.size() && j<list2.size()){
            int maxStart = Math.max(list1.get(i).start, list2.get(j).start);
            int minEnd =Math.min(list1.get(i).end, list2.get(j).end);
            if(maxStart <= minEnd) output.add(new MotionPeriod(maxStart, minEnd));
            if(list1.get(i).end < list2.get(j).end) i++;
            else j++;
        }
        System.out.println("Inside intersectionMotions, output = "+output);
        return output;
    }

}
/*
Now imagine you have multiple cameras installed and you want to compute the periods of time
where the motion intensity across all of them is at or above the threshold at the same time.
Write a function which takes an array of motion data streams and outputs the periods of time
where the motion detected across ALL the data streams is at or above the threshold.
*/