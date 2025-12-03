public class LifeAndStudyVisitor implements StudentActionVisitor {

    @Override
    public void visit(HumanitarianStudent student, String action, int value) {
        if (student.isExpelled()) return;

        switch (action) {
            case "teach humanitarian":
                student.addCredits(value);
                break;
            case "teach natural":
                System.out.println("Помилка (правило): Гуманітарний студент не може вивчати природничі дисципліни.");
                break;
            case "obtain scholarship":
            case "obtain help":
                student.addMoney(value);
                break;
            case "pay hostel":
            case "pay canteen":
                student.pay(value);
                break;
            default:
                System.out.println("Невідома дія: " + action);
        }
    }

    @Override
    public void visit(NaturalStudent student, String action, int value) {
        if (student.isExpelled()) return;

        switch (action) {
            case "teach natural":
                student.addCredits(value);
                break;
            case "teach humanitarian":
                System.out.println("Помилка (правило): Природничий студент не може вивчати гуманітарні дисципліни.");
                break;
            case "obtain scholarship":
            case "obtain help":
                student.addMoney(value);
                break;
            case "pay hostel":
            case "pay canteen":
                student.pay(value);
                break;
            default:
                System.out.println("Невідома дія: " + action);
        }
    }

    @Override
    public void visit(NaturalHumanitarianStudent student, String action, int value) {
        if (student.isExpelled()) return;

        switch (action) {
            case "teach humanitarian":
            case "teach natural":
                student.addCredits(value);
                break;
            case "obtain scholarship":
            case "obtain help":
                student.addMoney(value);
                break;
            case "pay hostel":
            case "pay canteen":
                student.pay(value);
                break;
            default:
                System.out.println("Невідома дія: " + action);
        }
    }
}