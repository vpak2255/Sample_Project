package com.company.utilities;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.company.utilities.ConfigurationReader.logfile;

public class NetworkLogs {
    public static OutputStream logfile;
    public static InputStream inputStream;
    public static PrintStream printLog;

    static {
        try {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
//            Files.newBufferedWriter(Paths.get("src/network-logs/network-logs-" + ldt + ".txt"), StandardOpenOption.TRUNCATE_EXISTING);
//            logfile = new FileOutputStream("src/network-logs/network-logs-" + ldt + ".txt", true);
            Files.newBufferedWriter(Paths.get("src/network-logs/network-logs-current.txt"), StandardOpenOption.TRUNCATE_EXISTING);
            logfile = new FileOutputStream("src/network-logs/network-logs-current.txt", true);
            printLog = new PrintStream(logfile);
//            inputStream = new FileInputStream("src/network-logs/network-logs-current.txt");
//            File file = new File("src/network-logs/network-logs-current.txt");
//            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("src/network-logs/network-logs-current.txt");
//        String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
//    }

}
