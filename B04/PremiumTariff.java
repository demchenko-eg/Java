public class PremiumTariff extends Tariff {
    public PremiumTariff(String name, int clients, int mb) {
        super(name, clients, mb);
    }
    @Override
    protected double calculateFee(int mb) {
        return mb * 0.08 + 50;
    }
}
