package basic.recursiveprogramming;

import java.io.File;

/**
 * Recursively Explore Files and Directories in Java
 */
public class DirectoryExplorer {
    //use DFS to explore files, pre-order
    static void explore(File file) {
        try {
            if (file != null)
                System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    explore(f);
                }
            }
        } catch (Exception e) {
            //ignore exception
        }
    }

    public static void main(String[] args) {
        File root = new File("/Users/hxu");  // Change this to your directory
        explore(root);
    }
}
