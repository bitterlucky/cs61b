package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            System.exit(0);
        }
        //TODO:If a user inputs a command with the wrong number or format
        // of operands, print the message Incorrect operands. and
        // exit.
        String firstArg = args[0];
        if (!firstArg.equals("init") && !Repository.gitLetDicExist()) {
            System.out.println("Not in an initialized Gitlet directory.");
            System.exit(0);
        }
        switch(firstArg) {
            case "init":
                if (args.length != 1) {
                    System.out.println("Incorrect operands.");
                    System.exit(0);
                }
                Repository.init();
                break;
            case "add":
                if (args.length != 2) {
                    System.out.println("Incorrect operands.");
                    System.exit(0);
                }
                Repository.add(args[1]);
                break;
            default:
                System.out.println("No command with that name exists.");
                System.exit(0);
            // TODO: FILL THE REST IN
        }
    }
}
