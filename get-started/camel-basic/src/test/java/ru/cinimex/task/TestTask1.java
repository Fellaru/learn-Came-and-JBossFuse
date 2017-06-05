package ru.cinimex.task;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import org.apache.log4j.LogManager;


import static org.junit.Assert.assertTrue;


/**
 * Created by efischenko on 05.06.2017.
 */

public class TestTask1 {
    private static final Logger log = Logger.getLogger(TestTask1.class);

   private static String sourceDir = "C:/D/";
   private static String fileName = "test.txt";
   private static String targetDir = "C:/G/";
   private static String inContents ="Hello World";
   private static String outContents;

    @Before
    public void setUp() throws IOException {
        File dir = new File(sourceDir);
        File test = new File(dir, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        test.createNewFile();
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(test));
        outStream.writeChars(inContents);
    }

  /*  @Test
    public void isFileMove() throws IOException {
        assertTrue(fileMove());
    }*/

    public boolean fileMove() throws IOException {
        boolean answer;
        BufferedReader reader = null;
        File message = new File(targetDir + fileName);
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(message), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                outContents ="" + line;
            }
            System.out.println(inContents.equals(outContents));
        } catch (IOException e) {
            log.info("BufferedReader");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("BufferedReader is not close");
                }
            }
        }


        if (message.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(message));
            String Contents;
            while((Contents = bufferedReader.readLine())!= null){
                String outContents = "";
                outContents = outContents + Contents;
                System.out.println(Contents);
            }
            if(inContents.equals(Contents)){answer = true;} else answer = false;
        } else answer = false;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        boolean answer;
        BufferedReader reader = null;
        File message = new File(targetDir + fileName);
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(message), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                outContents ="" + line;
            }
            System.out.println(inContents == outContents);
        } catch (IOException e) {
            log.info("BufferedReader");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("BufferedReader is not close");
                }
            }
        }

    }

    }


