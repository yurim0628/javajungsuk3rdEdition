package exercise;

import java.io.*;

public class Exercise15_1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java FileHead 10 FILENAME");
            return;
        }

        try {
            int lineNum = Integer.parseInt(args[0]);
            String fileName = args[1];

            File f = new File(fileName);
            if (f.exists() && !f.isDirectory()) {
                BufferedReader br = new BufferedReader(new FileReader(fileName));

                String line;
                int i = 1;

                while ((line = br.readLine()) != null && i <= lineNum) {
                    System.out.println(i + ":" + line);
                    i++;
                }

                br.close();
            } else {
                System.out.println("File not found or is a directory: " + fileName);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid line number format: " + args[0]);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
