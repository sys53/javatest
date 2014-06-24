package com.company.io;

import java.io.*;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-12 上午9:36
 * version $Id:BufferedInputFile.java,v 0.1.Exp $
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuffer sb = new StringBuffer();
        while ((s = reader.readLine()) != null) {
            sb.append(s);
            sb.append('\n');
        }
        reader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/Shared/shenys/javatest/src/com/company/io/BufferedInputFile.java"));

        StringReader reader = new StringReader(BufferedInputFile.read("/Users/Shared/shenys/javatest/src/com/company/io/BufferedInputFile.java"));
        int c;
        while ((c = reader.read()) != -1) {

            System.out.print((char) c);
            System.out.print(c);
        }


        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("/Users/Shared/shenys/javatest/src/com/company/io/BufferedInputFile.java").getBytes()));

        while (in.available()!=0){
            System.out.print((char) in.readByte());
        }
    }
}
