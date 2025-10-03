public class StudentTariff extends Tariff {
    public StudentTariff(String name, int clients, int mb) {
        super(name, clients, mb);
    }
    @Override
    protected double calculateFee(int mb) {
        return mb * 0.05 + 20;
    }
}