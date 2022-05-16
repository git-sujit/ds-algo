package com.sks.interview2022.FBprep;

public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        System.out.println("\ninput = " + input + ", rotationFactor = " + rotationFactor);
        String cipher = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            cipher += rotate(c, rotationFactor);
        }
        return cipher;
    }

    char rotate(char c, int rotationFactor) {
        if (c >= 'A' && c <= 'Z')
            return (char) (('A' - 1) + (c - ('A' - 1) + rotationFactor) % 27);
        else if (c >= 'a' && c <= 'z')
            return (char) (('a' - 1) + (c - ('a' - 1) + rotationFactor) % 27);
        else if(c >= '0' && c <= '9')
            return (char) (('0' - 1) + (c - ('0' - 1) + rotationFactor) % 10);
        else return c;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        RotationalCipher rc = new RotationalCipher();
        System.out.println(rc.rotate('A', 4));
        System.out.println(rc.rotate('a', 4));
        System.out.println(rc.rotate('x', 4));
        System.out.println(rc.rotate('Y', 4));
        System.out.println(rc.rotate('v', 4));
        System.out.println(rc.rotate('Z', 4));
        new RotationalCipher().run();
    }
}
