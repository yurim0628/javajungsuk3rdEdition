package exercise;

import java.io.*;
import java.util.*;

public class Exercise15_4 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        try {
            Vector<InputStream> v = new Vector<>();
            for (int i = 1; i < args.length; i++) {
                File f = new File(args[i]);
                if (f.exists()) {
                    v.add(new FileInputStream(args[i]));
                } else {
                    System.out.println(args[i] + " - File not found.");
                    System.exit(0);
                }
            }

            Enumeration<InputStream> inputStreams = v.elements();
            SequenceInputStream input = new SequenceInputStream(inputStreams);
            FileOutputStream output = new FileOutputStream(args[0]);

            int data = 0;
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            input.close();
            output.close();
            System.out.println("Files merged successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

