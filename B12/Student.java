public abstract class Student {
    protected String major;
    protected int requiredCredits;
    protected int currentCredits;
    protected int money;
    protected boolean expelled;

    public Student(String major, int requiredCredits, int money) {
        this.major = major;
        this.requiredCredits = requiredCredits;
        this.money = money;
        this.currentCredits = 0;
        this.expelled = false;
    }

    public abstract void accept(StudentActionVisitor visitor, String action, int value);

    public void addCredits(int credits) {
        if (!expelled) {
            this.currentCredits += credits;
        }
    }

    public void addMoney(int amount) {
        if (!expelled) {
            this.money += amount;
        }
    }

    public void pay(int amount) {
        if (expelled) return;
        
        if (this.money >= amount) {
            this.money -= amount;
        } else {
            System.out.println(major + " студент відрахований через нестачу коштів. (Потрібно: " + amount + ", Має: " + money + ")");
            this.expelled = true;
        }
    }
    
    public boolean isExpelled() { 
        return expelled; 
    }

    public int getRequiredCredits() {
        return requiredCredits;
    }
    
    public int getCurrentCredits() {
        return currentCredits;
    }
    
    public boolean getsDiploma() {
        return !expelled && currentCredits >= requiredCredits;
    }
    
    @Override
    public String toString() {
        return String.format("Напрям: %s, Кредити: %d/%d, Баланс: %d, Відрахований: %b",
               major, currentCredits, requiredCredits, money, expelled);
    }
}