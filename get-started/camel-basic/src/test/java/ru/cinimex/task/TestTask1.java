package ru.cinimex.task;



import org.junit.Before;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.Assert.assertTrue;


/**
 * Created by efischenko on 05.06.2017.
 */

public class TestTask1 {


    private static final String SOURCE_DIR = "C:/D/";
    private static final String FILE_NAME = "test.txt";
    private static final String TARGET_DIR = "C:/G/";
    private static final String IN_CONTENTS = "Hello World";
    private static String OUT_CONTENTS;

    @Before
    public void setUp() throws IOException {
        File dir = new File(SOURCE_DIR);
        File test = new File(dir, FILE_NAME);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        test.createNewFile();
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(test));
        outStream.writeChars(IN_CONTENTS);
    }

    @Test
    public void isFileMove() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(TARGET_DIR + FILE_NAME), StandardCharsets.UTF_16);
        for (String line : lines) {
            sb.append(line);
        }
        OUT_CONTENTS = sb.toString();

        assertTrue(IN_CONTENTS.equals(OUT_CONTENTS));
    }

}








