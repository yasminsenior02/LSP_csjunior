package org.howard.edu.lsp.midterm.problem51;


public class integerrange implements range {



    private int lower;

    private int upper;



    public integerrange(int lower, int upper) {

        this.lower = lower;

        this.upper = upper;

    }



    public int getLower() {

        return lower;

    }



    public int getUpper() {

        return upper;

    }



    public boolean contains(int value) {

        return value >= lower && value <= upper;

    }



    public boolean overlaps(range other) throws EmptyRangeException {

        if (other == null) {

            throw new EmptyRangeException();

        }

        return this.contains(other.getLower()) || this.contains(other.getUpper()) ||

                other.contains(this.getLower()) || other.contains(this.getUpper());

    }



    public int size() {

        return upper - lower + 1;

    }



}



