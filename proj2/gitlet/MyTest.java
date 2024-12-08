package gitlet;

import java.io.File;

import static gitlet.Utils.join;

public class MyTest {
    public static void main(String[] args) {
        File CWD = new File(System.getProperty("user.dir"));
        File file = join(CWD, "syx");
        System.out.println(file.getPath());
    }
}
