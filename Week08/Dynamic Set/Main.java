public class Main {
    public static void main(String[] args) {
        Set<Integer> A = new Set<>();
        Set<Integer> B = new Set<>();


        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        A.add(numbers);
        B.add(100);
        B.add(200);
        B.add(300);
        B.add(400);
        B.add(500);

        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("\nA and B are disjoint: " + A.areDisjoint(B));
        System.out.println("A is empty: " + A.isEmpty());

        Set<Integer> C = new Set<>(A);
        System.out.println("\nC = " + C);
        System.out.println("\nC is a subset of A: " + C.isSubset(A));
        System.out.println("A is a subset of C: " + A.isSubset(C));
        System.out.println("C equals A: " + C.equals(A));

        System.out.println("\nIf A=C then (A Union C) = (A Intersection C)");
        System.out.println("Union: " + A.union(C));
        System.out.println("Intersection: " + A.intersection(C));
        
    }
}
