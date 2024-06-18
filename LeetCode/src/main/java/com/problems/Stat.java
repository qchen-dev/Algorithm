package com.problems;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Stat {

    public static void main(String[] args) {
        String[] paths = {"LeetCode/src/main/java/com/problems/top_100_liked", "LeetCode/src/main/java/com/problems/leetcode_75"};

        int count, total = 0;
        for (String path : paths) {
            count = countFiles(path);
            System.out.printf("\nThere are %d files under directory %s.\n", count, path);
            total += count;
            System.out.println();
        }
        System.out.printf("The total number of files: %d.\n", total);
    }

    private static class MyFile {
        File file;
        int level;

        MyFile(File file, int level) {
            this.file = file;
            this.level = level;
        }
    }

    private static int countFiles(String path) {
        File filePath = new File(path);
        int count = 0;

        if (filePath.isFile()) {
            count++;
            System.out.println(filePath.getName());
        } else if (filePath.isDirectory()) {
            Queue<MyFile> queue = new LinkedList<>();
            // Stack<MyFile> stack = new Stack<>();
            queue.add(new MyFile(filePath, 0));

            int level;
            String tab = "\t";
            MyFile directory;
            while (!queue.isEmpty()) {
                directory = queue.poll();
                File[] files = directory.file.listFiles();
                level = directory.level;
                assert files != null;

                System.out.print(tab.repeat(level));
                System.out.println("Dir: " + directory.file.getName());
                for (File file : files) {
                    if (file.isDirectory()) {
                        queue.add(new MyFile(file, level + 1));
                    } else if (file.isFile()) {
                        System.out.print(tab.repeat(level + 1));
                        System.out.printf("%s%d.%s\n", ++count <= 9 ? "0" : "", count, file.getName());
                    }
                }
            }
        }
        return count;
    }
}
