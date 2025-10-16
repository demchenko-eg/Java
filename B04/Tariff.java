public abstract class Tariff implements Comparable<Tariff> {
    private String name;
    private int clients;
    private double fee;
    private int mb;
    public Tariff(String name, int clients, int mb) {
        this.name = name;
        this.clients = clients;
        this.mb = mb;
        this.fee = calculateFee(mb);
    }
    protected abstract double calculateFee(int mb);
    public String getName() { return name; }
    public int getClients() { return clients; }
    public double getFee() { return fee; }
    public int getMb() { return mb; }
    @Override
    public int compareTo(Tariff o) {
        return Double.compare(this.fee, o.fee);
    }
    @Override
    public String toString() {
        return name + " | Клієнтів: " + clients + " | Інтернет: " + mb + "MB" + " | Плата: " + fee + " грн";
    }
}