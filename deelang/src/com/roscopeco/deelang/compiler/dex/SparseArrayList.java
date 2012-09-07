// copyright 2009 ActiveVideo; license: MIT; see license.txt
package com.roscopeco.deelang.compiler.dex;

import java.util.Arrays;

class SparseArrayList<T> {
    // the size of leaf elements, their mask, and 2 power
    static final int leafPower = 6;
    static final int leafSize  = twoN(leafPower);
    static final int leafMask  = leafSize - 1;

    // from a regular index, calculate the root index, and leaf index resp
    private static int rootix(int i) { return i >> leafPower; }
    private static int leafix(int i) { return i &  leafMask;  }

    // helpers around power of two's
    private static int twoN(int n) { return 1 << (n & 0x1f); }
    private static int roundToPower(int n) {
        if (n <= 2) return 1;
        for (int p = 0; p < 32; p++) if ((1 << p) >= n) return p;
        throw new AssertionError("illegal val: "+ n);
    }

    private int last;        // always the highest inserted index
    private Object[][] root; // root array with nulls or arrays with values

    public SparseArrayList() { this(1024); }
    public SparseArrayList(int cap) {
        init(cap);
    }

    private void init(int cap) {
        if (cap <= leafSize) cap = leafSize;

        int power = roundToPower(cap);
        int size  = twoN(power);

        root = new Object[rootix(size)][];
        last = -1;
    }

    private void resize(int cap) {
        if (cap <= leafSize) cap = leafSize;

        int power = roundToPower(cap);
        int size  = twoN(power);

        root = Arrays.copyOf(root, rootix(size));
        if (get(last) == null) findLast();
    }

    private void findLast() {
        for (int ri = root.length - 1; ri >= 0; ri--) {
            Object[] leaf = root[ri];
            if (leaf == null) continue;

            for (int li = leaf.length - 1; li >= 0; li--) {
                if (leaf[li] != null) {
                    last = leafSize * ri + li;
                    return;
                }
            }
            root[ri] = null; // if there is a leaf full of nulls, delete it
        }
        last = -1;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) throw new IndexOutOfBoundsException(""+ index);
        if (index > last) return null;

        Object[] leaf = root[rootix(index)];
        if (leaf == null) return null;

        return (T) leaf[leafix(index)];
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0) throw new IndexOutOfBoundsException(""+ index);
        if (index > last) {
            if (value == null) return null;
            last = index;
        }

        if (rootix(index) >= root.length) resize(index + 1);

        Object[] leaf = root[rootix(index)];
        if (leaf == null) {
            if (value == null) return null;
            leaf = new Object[leafSize];
            root[rootix(index)] = leaf;
        }

        Object old = leaf[leafix(index)];
        leaf[leafix(index)] = value;

        if (value == null && index == last) findLast();

        return (T) old;
    }

    public boolean add(T value) {
        set(last + 1, value);
        return true;
    }

    public T del(int index) throws IndexOutOfBoundsException {
        return set(last, null);
    }

    public int size() { return last + 1; }

    public boolean isEmpty() { return last < 0; }

    public void clear() { init(-1); }
}