//package  com.rensciphers.twentyquestionsgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//start of the tree for the Game
public class Tree {
    //root of the tree
    public TreeNode root;

    public Tree() {
        root = new TreeNode();
    }

    //load data from file for Tree instance
    public void loadTree(String filename) {
        File file = new File(filename);
        FileReader fileReader = null;
        BufferedReader buffer = null;

        try {
            fileReader = new FileReader(file);
            buffer = new BufferedReader(fileReader);
            buildTree(root, buffer);
        } catch (Exception e) {
            System.out.println("Error during tree building: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    buffer.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception e) {

            }
        }
    }

//    private void writeToFile(FileWriter file, String fileName) {
//        file.write(fileName);
//    }

    //build three from buffer reader with breadth first search strategy
    private void buildTree(TreeNode currentNode, BufferedReader buffer) throws Exception {
        String line = buffer.readLine();

        if (line != null) {
            currentNode.setData(line);

            if (currentNode.isQuestion()) {
                TreeNode yesNode = new TreeNode();
                TreeNode noNode = new TreeNode();
                currentNode.yes = yesNode;
                currentNode.no = noNode;
                buildTree(yesNode, buffer);
                buildTree(noNode, buffer);
            }
        }
    }
}
