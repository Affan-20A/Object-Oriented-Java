import java.util.Objects;

public class Set<T> {
    private T[] elements;
    private int size;
    
    @SuppressWarnings ("Unchecked")
    public Set(int capacity) {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    @SuppressWarnings ("Unchecked")
    public Set(Set<T> copy) {
        this.elements = (T[]) new Object[copy.elements.length];
        this.size = copy.size;

        for (int i = 0; i < copy.size; i++) {
            this.elements[i] = copy.elements[i];
        }
    }

    public void add(T value) {
        if(!contains(value)) {
            elements[size] = value;
            size++;
        }
    }

    public void add(T[] array) {
        for(int i=0 ; i<array.length ; i++) {
            add(array[i]);
        }
    }

    public boolean contains(T value) {
        for(int i=0 ; i<size ; i++) {
            if(Objects.equals(elements[i], value)) {
                return true;
            }
        }
        return false;
    }

    public void remove(T value) {
        for(int i=0 ; i<size ; i++) {
            if(Objects.equals(elements[i], value)) {
                for(int j=i ; j<size-1 ; j++) {
                    elements[j] = elements[j+1];
                }
                elements[size-1] = null;
                size--;
                return;
            }
        }
    }

    public Set<T> union(Set<T> other) {
        Set<T> result = new Set<>(this.size + other.size);
        for(int i=0 ; i< this.size ; i++) {
            result.add(this.elements[i]);
        }
        for(int i=0 ; i< other.size ; i++) {
            result.add(other.elements[i]);
        }
        return result;
    }

    public Set<T> intersection(Set<T> other) {
        Set<T> result = new Set<>(Math.min(this.size, other.size));
        for(int i=0 ; i< this.size ; i++) {
            if(other.contains(this.elements[i])) {
                result.add(this.elements[i]);
            }
        }
        return result;
    }

    public Set<T> difference(Set<T> other) {
        Set<T> result = new Set<>(this.size);
        for(int i=0 ; i< this.size ; i++) {
            if(!other.contains(this.elements[i])) {
                result.add(this.elements[i]);
            }
        }
        return result;
    }

    public Set<T> symmetricDifference(Set<T> other) {
        Set<T> result = new Set<>(this.size + other.size);
        for(int i=0 ; i< this.size ; i++) {
            if(!other.contains(this.elements[i])) {
                result.add(this.elements[i]);
            }
        }
        for(int i=0 ; i< other.size ; i++) {
            if(!this.contains(other.elements[i])) {
                result.add(other.elements[i]);
            }
        }
        return result;
    }

    public Set<T> complement(Set<T> universalSet) {
        Set<T> result = new Set<>(universalSet.size);
        for(int i=0 ; i< universalSet.size ; i++) {
            if(!this.contains(universalSet.elements[i])) {
                result.add(universalSet.elements[i]);
            }
        }
        return result;
    }

    public int cardinality() {
        return this.size;
    }

    public boolean isSubset(Set<T> other) {
        for(int i=0 ; i< this.size ; i++) {
            if(!other.contains(this.elements[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isProperSubset(Set<T> other) {
        return this.isSubset(other) && this.size < other.size;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if(this == obj)
    //         return true;
    //     if(obj == null || this.getClass() != obj.getClass())
    //         return false;
    //     Set<T> other = (Set<T>) obj;
    //     return this.size == other.size &&
    //            Objects.equals(this.elements, other.elements);
    // }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Set<T> other = (Set<T>) obj;
        if(this.size != other.size)
            return false;
        for(int i=0 ; i< this.size ; i++) {
            if(!other.contains(this.elements[i])) {
                return false;
            }
        }
        return true;
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(this.size, this.elements);
    // }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < size; i++) {
            hash += Objects.hash(elements[i]);
        }
        return hash;
    }

    public String toString() {
        String result = "{ ";
        for(int i=0 ; i<size ; i++) {
            result += elements[i] + " ";
        }
        result += "}";
        return result;
    }

    public void display() {
        System.out.println(this);
        System.out.println("Size = " + this.size);
    }

    // further methods() can be added isSuperset(), areDisjoint() and isEmpty()
    // it could be done without Generics usingg Object[] but we can lose compile-time type safety.
    // cause java then allow A.add(1) A.add(2) A.add("Hello")
}