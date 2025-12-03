public class NaturalStudent extends Student {
    public NaturalStudent(int requiredCredits, int money) {
        super("natural", requiredCredits, money);
    }
    
    @Override
    public void accept(StudentActionVisitor visitor, String action, int value) {
        visitor.visit(this, action, value);
    }
}