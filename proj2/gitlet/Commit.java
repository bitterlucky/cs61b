package gitlet;

// TODO: any imports you need here


import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.HashMap;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    private String parentId;
    private String parentIdForMerge;
    private Long timestamp;
    private HashMap<String, String> files;
    public static Commit initialCommit = new Commit("initial commit", new Date(0).getTime());

    public Commit(String message, String parentId, String parentIdForMerge, Long timestamp) {
        this(message, parentId, timestamp);
        this.parentIdForMerge = parentIdForMerge;

    }
    public Commit(String message, String parentId, Long timestamp) {
        this(message, timestamp);
        this.parentId = parentId;

    }
    public Commit(String message, Long timestamp) {
        this.timestamp = timestamp;
        this.message = message;

    }

    /* TODO: fill in the rest of this class. */
}
