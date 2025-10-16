public class BasicTariff extends Tariff {
    public BasicTariff(String name, int clients, int mb) {
        super(name, clients, mb);
    }
    @Override
    protected double calculateFee(int mb) {
        return mb * 0.1;
    }
}