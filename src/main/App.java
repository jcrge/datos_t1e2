package main;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Se esperaba un argumento.");
            System.exit(1);
        }

        String targetName = args[0];
        File target = new File(targetName);

        if (!target.exists()) {
            System.err.printf("%s: no existe el archivo o directorio especificado.\n", targetName);
            System.exit(1);
        }

        printTree(target);
    }

    private static void printTree(File target) {
        System.out.println(target.getPath());

        if (target.isDirectory()) {
            for (File f: target.listFiles()) {
                printTree(f);
            }
        }
    }
}
