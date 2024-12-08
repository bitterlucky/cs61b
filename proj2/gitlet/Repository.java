package gitlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    public static final File OBJECT_DIR = join(GITLET_DIR, "objects");
    /** master branch*/
    private static Commit master;

    /**
     * 判断.gitlet是否存在
     * @return 存在则为true,不存在则为false
     */
    public static boolean gitLetDicExist() {
        return GITLET_DIR.exists();
    }

    /**
     * init初始化方法
     */
    public static void init() {
        if (gitLetDicExist()) {
            Utils.error("A Gitlet version-control system already exists in the current directory.");
        }
        master = Commit.initialCommit;
        GITLET_DIR.mkdir();
        OBJECT_DIR.mkdir();
        File file = new File(GITLET_DIR.getPath()+"temp");
        Utils.writeObject(file, Commit.initialCommit);
        String sha1Value = Utils.sha1(Utils.readContents(file));
        File initialCommitDict = join(OBJECT_DIR, sha1Value.substring(0, 2));
        initialCommitDict.mkdir();
        File file02 = new File(join(OBJECT_DIR, sha1Value.substring(0, 2)),sha1Value);
        Utils.writeObject(file02, Commit.initialCommit);
        Utils.restrictedDelete(file);
    }

    /**
     * 分为几种情况：
     * 第一种情况：文件被修改，与当前commit版本不同，add到暂存区
     * 第二种情况：文件已被暂存，但被修改过了，所以add到暂存区
     * 第三种情况：又分为两种小情况：（文件内容未改动，与当前提交版本相同）
     * 1.文件从未被暂存，且它与commit版本相同
     * 2.文件曾经被暂存，但后来改回了commit版本相同，gitlet add会检测到，直接暂存区不要这个文件
     * 第四种情况：文件处于“待删除状态”（gitlet rm)还没删除是因为还没有commit,因此文件恢复正常，不再标记为删除
     * 但也分为两种小情况：
     * 1.文件未修改，就不标记为删除
     * 2.文件修改了，暂存区也需要修改
     * @param fileName 文件名称
     */
    public static void add(String fileName) {
        File file = join(CWD, fileName);
        if (!file.exists()) {
            Utils.error("File does not exist.");
        }
        

    }
    /* TODO: fill in the rest of this class. */
}
