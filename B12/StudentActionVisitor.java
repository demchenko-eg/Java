public interface StudentActionVisitor {
    void visit(HumanitarianStudent student, String action, int value);
    void visit(NaturalStudent student, String action, int value);
    void visit(NaturalHumanitarianStudent student, String action, int value);
}