public class Main {
    public static void main(String[] args) {
        Set<Integer> A = new Set<>(10);
        Set<Integer> B = new Set<>(10);

        for(int i=0 ; i<10 ; i++) {
            A.add(i+1);
            A.add(i+1);
            A.add(1);
        }

        for(int i=0 ; i<20 ; i=i+2) {
            B.add(i+2);
        }

        System.out.println("A = " + A);
        System.out.println("B = " + B);

        System.out.println("\nUnion of A and B = " + A.union(B));
        System.out.println("Interscetion of A and B = " + A.intersection(B));

        Set<Character> C = new Set<>(8);
        Set<Character> D = new Set<>(8);

        Character[] arr1 = {'a','b','c','d','e','f','g','h'};
        Character[] arr2 = {'b','d','f','h','x','y','z'};

        C.add(arr1);
        D.add(arr2);

        System.out.println("\nC = " + C + " Cardinality = " + C.cardinality());
        System.out.println("D = " + D + " Cardinality = " + D.cardinality());

        System.out.println("\nC - D = " + C.difference(D));
        System.out.println("Symmetric Difference = " + C.symmetricDifference(D));

        Set<String> E = new Set<>(3);
        Set<String> F = new Set<>(E);

        String[] names = {"Affan", "Aown", "Abdul Rehman"};
        E.add(names);

        System.out.println("\nE is " + E + " Cardinality = " + E.cardinality());
        System.out.println("F is " + F + " Cardinality = " + F.cardinality());

        System.out.println("\nE is a subset of F = " + E.isSubset(F));
        System.out.println("F is a subset of E = " + F.isSubset(E));
        System.out.println("E is a proper subset of F = " + E.isProperSubset(F));
        System.out.println("E and F are equal = " + E.isSubset(F));

        F = new Set<>(E);

        System.out.println("\nE is " + E + " Cardinality = " + E.cardinality());
        System.out.println("F is " + F + " Cardinality = " + F.cardinality());

        System.out.println("\nE is a subset of F = " + E.isSubset(F));
        System.out.println("F is a subset of E = " + F.isSubset(E));
        System.out.println("E is a proper subset of F = " + E.isProperSubset(F));
        System.out.println("E and F are equal = " + E.isSubset(F));
    }
}
