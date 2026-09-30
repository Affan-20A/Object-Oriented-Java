public class Matrix implements Cloneable {
    private int rows;
    private int columns;
    private int[] data;

    public Matrix(int rows, int columns, int[] source) {
        if(rows <=0 || columns <=0 || source == null || source.length != rows*columns)
            throw new IllegalArgumentException("Invalid Data");
        this.rows = rows;
        this.columns = columns;
        this.data = new int[source.length];
        for(int i=0 ; i< source.length ; i++) {
            this.data[i] = source[i];
        }
    }

    public int get(int row, int column) {
        return this.data[row * columns + column];
    }

    public void set(int row, int column, int value) {
        this.data[row * columns + column] = value;
    }

    @Override 
    public Matrix clone() throws CloneNotSupportedException {
        return (Matrix) super.clone();
    }

    public Matrix deepCopy() {
        Matrix m = new Matrix(this.rows, this.columns, this.data);
        return m;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < rows; i++) {
            result.append("[");
            for (int j = 0; j < columns; j++) {
                result.append(data[i * columns + j]);
                if (j < columns - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
            if (i < rows - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    // @Override 
    // public String toString() {
    //     StringBuilder result = new StringBuilder();
    //     for(int i=0 ; i< this.data.length ; i++) {
    //         result.append(this.data[i]);
    //         result.append(",");
    //     }
    //     return "[" + result.toString() + "]";
    // }

    public Matrix add(Matrix other) {
        if(this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("The order of matrices is not same.");
        }
        int[] result = new int[this.rows * this.columns];
        for(int i=0 ; i<this.data.length ; i++) {
            result[i] = this.data[i] + other.data[i];
        }
        return new Matrix(this.rows, this.columns, result);
    }

    public Matrix subtract(Matrix other) {
        if(this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("The order of matrices is not same.");
        }
        int[] result = new int[this.rows * this.columns];
        for(int i=0 ; i<this.data.length ; i++) {
            result[i] = this.data[i] - other.data[i];
        }
        return new Matrix(this.rows, this.columns, result);
    }

    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Multiplication is not possible.");
        }
        int[] result = new int[this.rows * other.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result[i * other.columns + j] += 
                    this.data[i * this.columns + k] *
                    other.data[k * other.columns + j];
                }
            }
        }
        return new Matrix(this.rows, other.columns, result);
    }

    public Matrix transpose() {
        int[] result = new int[this.rows * this.columns];
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.columns ; j++) {
                result[j * this.rows + i] = this.data[i * this.columns + j];
            }
        }
        return new Matrix(this.columns, this.rows, result);
    }

    // public Matrix transpose() {
    //     int[] result = new int[this.rows * this.columns];
    //     for (int i=0 ; i<this.columns ; i++) {
    //         for (int j=0 ; j<this.rows ; j++) {
    //             result[i * this.rows + j] = this.data[j * this.columns + i];
    //         }
    //     }
    //     return new Matrix(this.columns, this.rows, result);
    // }
}