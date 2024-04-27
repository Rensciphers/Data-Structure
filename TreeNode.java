//class for the tree nodes - should be loaded from a file
public class TreeNode {

    //nodes for answers and questions
    enum Line {
        answer, question
    }

    public static final String QuestionLine = "Q: ";
    public static final String AnswerLine = "A: ";
    public String data;
    public Line lineType;

    //if tree node is a question there are two children, yes and no
    public TreeNode yes;
    public TreeNode no;

    public TreeNode(){
    }

    public TreeNode(String data, Line lineType) {
        this.data = data;
        this.lineType = lineType;
    }

    public boolean isQuestion() {
        return Line.question.equals(lineType);
    }

    public void setData(String data) {
        lineType = Line.question;

        if (data.startsWith(AnswerLine)) {
            lineType = Line.answer;
        }

        this.data = data.substring(2); // removes question or answer line
    }

    public void addYes() {
        this.yes = yes;
    }

    public void addNo() {
        this.no = no;
    }

}
