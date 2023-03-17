package org.howard.edu.lsp.midterm.problem51;

public interface range {
    public boolean contains(int value);
    public boolean overlaps(range other) throws EmptyRangeException;
    public int size();
}