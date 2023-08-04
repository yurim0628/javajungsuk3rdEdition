package exercise;

import java.io.*;

public class Exercise15_2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer FILENAME");
            System.exit(0);
        }

        String inputFile = args[0];
        try (FileInputStream input = new FileInputStream(inputFile)) {
            PrintStream output = new PrintStream(System.out);
            int data;
            int i = 0;
            while ((data = input.read()) != -1) {
                output.printf("%02X ", data);
                if (++i % 16 == 0) {
                    output.println();
                }
            }
            output.println();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

