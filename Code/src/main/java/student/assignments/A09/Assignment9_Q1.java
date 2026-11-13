package student.assignments.A09;
public class Assignment9_Q1 {

    // ===================== YOUR RECORDED RESULTS =====================
    //
    // (b) THE RUN: record the full console output of the finished program.
    //
    // Pallet 0: 0 cases of Empty, 0.0 kg
    // Pallet 1042: 24 cases of Brake Pads, 310.5 kg
    // Pallet 1043: 60 cases of Oil Filters, 275.0 kg
    // After setCases: Pallet 1042: 20 cases of Brake Pads, 310.5 kg
    // Product of p2: Oil Filters
    // Cases on both pallets: 80
    // Weight of both pallets: 585.5 kg
    // Id of p1: 1042
    //
    // ================================================================

    public static void main(String[] args) {

        Pallet blank = new Pallet();
        Pallet p1 = new Pallet(1042, "Brake Pads", 24, 310.5);
        Pallet p2 = new Pallet(1043, "Oil Filters", 60, 275.0);

        System.out.println(blank);
        System.out.println(p1);
        System.out.println(p2);

        p1.setCases(20);
        System.out.println("After setCases: " + p1);

        System.out.println("Product of p2: " + p2.getProduct());
        System.out.println("Cases on both pallets: " + (p1.getCases() + p2.getCases()));
        System.out.println("Weight of both pallets: " + (p1.getWeightKg() + p2.getWeightKg()) + " kg");
        System.out.println("Id of p1: " + p1.getId());
    }
}