public class seminaroop {
    public class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        // Getters and Setters
        public double getReal() {
            return real;
        }

        public void setReal(double real) {
            this.real = real;
        }

        public double getImaginary() {
            return imaginary;
        }

        public void setImaginary(double imaginary) {
            this.imaginary = imaginary;
        }

        @Override
        public String toString() {
            return "(" + real + " + " + imaginary + "i)";
        }
    }

    public interface Calculator {
        ComplexNumber add(ComplexNumber c1, ComplexNumber c2);

        ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2);

        ComplexNumber divide(ComplexNumber c1, ComplexNumber c2);
    }

    public class ComplexCalculator implements Calculator {

        @Override
        public ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
            return new ComplexNumber(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
        }

        @Override
        public ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
            double real = c1.getReal() * c2.getReal() - c1.getImaginary() * c2.getImaginary();
            double imaginary = c1.getReal() * c2.getImaginary() + c1.getImaginary() * c2.getReal();
            return new ComplexNumber(real, imaginary);
        }

        @Override
        public ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) {
            ComplexNumber conjugate = new ComplexNumber(c2.getReal(), -c2.getImaginary());
            ComplexNumber numerator = this.multiply(c1, conjugate);
            double denominator = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
            return new ComplexNumber(numerator.getReal() / denominator, numerator.getImaginary() / denominator);
        }
    }

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComplexCalculator implements Calculator {
    private static final Logger logger = LoggerFactory.getLogger(ComplexCalculator.class);

    @Override
    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber result = new ComplexNumber(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
        logger.info("Adding {} and {} to get {}", c1, c2, result);
        return result;
    }

    // Similar for multiply and divide
}

}
