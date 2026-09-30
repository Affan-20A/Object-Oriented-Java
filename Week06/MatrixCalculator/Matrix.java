import java.util.Arrays;
import java.util.Objects;

public class Matrix implements Cloneable{
    private double[][] data;
    private final int rows;
    private final int cols;

    private static int objectCount;

    public Matrix(int rows, int cols) {
        if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and Columns must be greater than zero.");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
        objectCount++;
    }

    public Matrix(double[][] data) {
        this.valiadte(data);
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                this.data[i][j] = data[i][j];
            }
        }
        objectCount++;
    }

    public Matrix(Matrix copy) {
        this(copy.data);
    }

    private void valiadte(double[][] data) {
        if(data == null || data.length == 0){
            throw new IllegalArgumentException("Matrix must have atleast one row.");
        }
        if(data[0] == null || data[0].length == 0) {
            throw new IllegalArgumentException("Matrix must have atleast ne column.");
        }

        int rows = data.length;
        int cols = data[0].length;
        for(int i=0 ; i<rows ; i++) {
            if(data[i] == null) {
                throw new IllegalArgumentException("Rows cannot be null.");
            }
            if(data[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }
        }
    }

    public void set(double[][] data) {
        this.valiadte(data);
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public int getRows() {
        return this.rows;
    }
    public int getColumns() {
        return this.cols;
    }

    public Matrix add(Matrix other) {
        if(this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("The order of matrices is not same.");
        }
        Matrix mtrx = new Matrix(this.rows, this.cols);
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.cols ; j++) {
                mtrx.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return mtrx;
    }
    
    public Matrix subtract(Matrix other) {
        if(this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("The order of matrices is not same.");
        }
        Matrix mtrx = new Matrix(this.rows, this.cols);
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.cols ; j++) {
                mtrx.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return mtrx;
    }

    public Matrix multiply(Matrix other) {
        if(this.cols != other.rows) {
            throw new IllegalArgumentException("Multiplication is not possible.");
        }
        Matrix mtrx = new Matrix(this.rows, other.cols);
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<other.cols ; j++) {
                for(int k=0 ; k<this.cols ; k++) {
                    mtrx.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return mtrx;
    }

    public Matrix multiply(double scalar) {
        Matrix mtrx = new Matrix(this.rows, this.cols);
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.cols ; j++) {
                mtrx.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return mtrx;
    }

    public Matrix divide(double scalar) {
        if(scalar == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        Matrix mtrx = new Matrix(this.rows, this.cols);
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.cols ; j++) {
                mtrx.data[i][j] = Math.round((this.data[i][j] / scalar) * 100.0) / 100.0;
            }
        }
        return mtrx;
    }

    public Matrix transpose() {
        Matrix mtrx = new Matrix(this.cols, this.rows);
        for(int i=0 ; i<this.cols ; i++) {
            for(int j=0 ; j<this.rows ; j++) {
                mtrx.data[i][j] = this.data[j][i];
            }
        }
        return mtrx;
    }

    public static Matrix scalarMatrix(int num, int order) {
        Matrix mtrx = new Matrix(order, order);
        for(int i=0 ; i<order ; i++) {
            mtrx.data[i][i] = num;
        }
        return mtrx;
    }

    // removes (row, col)
    public Matrix minor(int row, int col) {
        // creates a new matrix of order - 1
        Matrix mtrx = new Matrix(this.rows - 1, this.cols - 1);
        int minorRow = 0;
        for (int i = 0; i < this.rows; i++) {
            // skips the intented row
            if (i == row) {
                continue;
            }
            int minorCol = 0;
            for (int j = 0; j < this.cols; j++) {
                // skips the intented column
                if (j == col) {
                    continue;
                }
                // i and j have the track of original matrix,
                // whereas minorRow and minorCol keeps track of minor matrix
                mtrx.data[minorRow][minorCol] = this.data[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return mtrx;
    }

    public double determinant() {
        if(this.rows != this.cols) {
            throw new IllegalArgumentException("Determinant does not exist.");
        }
        // 1x1 matrix
        if(this.rows == 1) {
            return this.data[0][0];
        }
        // 2x2 matrix (ad - bc)
        if(this.rows == 2) {
            return (this.data[0][0] * this.data[1][1]) - (this.data[0][1] * this.data[1][0]);
        }
        double det = 0;
        // expanding through first row
        for(int j=0 ; j<this.cols ; j++) {
            // now we have minor
            Matrix minorM = this.minor(0, j);
            // recursion ... calculates determinant of minor
            double cofactor = minorM.determinant();
            // keeping the order of + and -
            if(j % 2 == 0) {
                det += this.data[0][j] * cofactor;
            }
            else {
                det -= this.data[0][j] * cofactor;
            }
        }
        return det;
    }

    public Matrix adjoint() {
        if(this.rows != this.cols) {
            throw new IllegalArgumentException("Adjoint does not exist.");
        }
        // 1x1 matrix
        if(this.rows == 1) {
            Matrix mtrx = new Matrix(1, 1);
            mtrx.data[0][0] = 1;
            return mtrx;
        }
        // 2x2 matrix
        if(this.rows == 2) {
            Matrix mtrx = new Matrix(this.rows, this.cols);
            mtrx.data[0][0] = this.data[1][1];
            mtrx.data[0][1] = -this.data[0][1];
            mtrx.data[1][0] = -this.data[1][0];
            mtrx.data[1][1] = this.data[0][0];
            return mtrx;
        }
        // creates a new matrix
        Matrix mtrx = new Matrix(this.rows, this.cols);
        // iteration through each element
        for(int i=0 ; i<this.rows ; i++) {
            for(int j=0 ; j<this.cols ; j++) {
                // creates a minor
                Matrix minorM = this.minor(i, j);
                double cofactor = minorM.determinant();
                if((i+j) % 2 == 0) {
                    mtrx.data[i][j] = cofactor;
                }
                else {
                    mtrx.data[i][j] = -cofactor;
                }
            }
        }
        // returns the transpose
        return mtrx.transpose();
    }

    public Matrix inverse() {
        double det = this.determinant();
        if(det == 0) {
            throw new IllegalArgumentException("Inverse does not exist.");
        }
        Matrix adj = this.adjoint();
        return adj.divide(det);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Matrix other = (Matrix) obj;
        return this.rows == other.rows && this.cols == other.cols
               && Arrays.deepEquals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rows, this.cols, Arrays.deepHashCode(this.data));
    }

    @Override
    public Matrix clone() {
        try {
            Matrix copy = (Matrix) super.clone();
            copy.data = this.data.clone();
            for(int i=0 ; i<this.rows ; i++) {
                copy.data[i] = this.data[i].clone();
            }
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.data);
    }

    public void display() {
        for(int i=0 ; i<this.rows ; i++) {
			for(int j=0 ; j<this.cols ; j++) {
				System.out.print(this.data[i][j] + " ");
			}
			System.out.println();
		}
    }
}