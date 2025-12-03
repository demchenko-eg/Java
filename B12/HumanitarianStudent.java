public class HumanitarianStudent extends Student {
    public HumanitarianStudent(int requiredCredits, int money) {
        super("humanitarian", requiredCredits, money);
    }
    
    @Override
    public void accept(StudentActionVisitor visitor, String action, int value) {
        visitor.visit(this, action, value);
    }
}