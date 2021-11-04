package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void Write(String FileName, String Text) {
        String[] txt = Text.split("\n");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName,true))) {
            for (String s: txt) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static ArrayList<String> Read(String fn) {
        ArrayList<String> text = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "windows-1250"))) {
            String line;
            while((line = br.readLine()) != null) {
                text.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
