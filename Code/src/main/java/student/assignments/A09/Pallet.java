package student.assignments.A09;
public class Pallet {

    // fields (given). Every field is private.
    private int id;
    private String product;
    private int cases;
    private double weightKg;

    // TODO (a): default constructor. Give every field a value: the id 0, the
    //           product "Empty", 0 cases, and a weight of 0.0.
    public Pallet() {
        id = 0;
        product = "Empty";
        cases = 0;
        weightKg = 0.0;
    }

    // TODO (a): fully parameterized constructor. The parameters come in the same
    //           order as the fields above: id, product, cases, weightKg.
    public Pallet(int id, String product, int cases, double weightKg) {
        this.id = id;
        this.product = product;
        this.cases = cases;
        this.weightKg = weightKg;
    }

    // TODO (a): accessors.
    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getCases() {
        return cases;
    }

    public double getWeightKg() {
        return weightKg;
    }

    // TODO (a): mutator.
    public void setCases(int cases) {
        this.cases = cases;
    }

    //               Pallet 1042: 24 cases of Brake Pads, 310.5 kg
    public String toString() {
        return "Pallet " + id + ": " + cases + " cases of " + product + ", " + weightKg + " kg";
    }
}