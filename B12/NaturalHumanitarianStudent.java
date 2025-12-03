public class NaturalHumanitarianStudent extends Student {
    public NaturalHumanitarianStudent(int requiredCredits, int money) {
        super("natural-humanitarian", requiredCredits, money);
    }
    
    @Override
    public void accept(StudentActionVisitor visitor, String action, int value) {
        visitor.visit(this, action, value);
    }
}