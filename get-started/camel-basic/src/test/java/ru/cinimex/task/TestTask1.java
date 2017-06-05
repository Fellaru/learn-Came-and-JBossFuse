package ru.cinimex.task;


import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;


/**
 * Created by efischenko on 05.06.2017.
 */

public class TestTask1 {
    @Before
    public void setUp() throws IOException{
        String customDir = "C:/D/";
        String fileName = "test.txt";
        File dir = new File(customDir);
        File test = new File(dir,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        test.createNewFile();
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(test));
        outStream.writeChars("Hello World!");}
     @Test
    public void fileMove() throws IOException{
              File message = new File("C:/Hi/test.txt");
         assertTrue(message.exists());
}

}

