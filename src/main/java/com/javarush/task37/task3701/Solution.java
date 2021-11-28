package com.javarush.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;


/*
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {


    @Override
    public Iterator<T> iterator() {
        return new RoundIterator(super.iterator());
    }

    public static void main(String[] args) {


        Solution<Integer> list = new Solution<>();

        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;

        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;

            }
        }
    }

    public class RoundIterator implements Iterator<T> {

       private Iterator<T> itr;

        public RoundIterator(Iterator<T> itr) {
            this.itr = itr;
        }


        @Override
        public boolean hasNext() {
            return Solution.this.size() > 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                return null;
            if (!itr.hasNext())
                itr = Solution.super.iterator();
            return itr.next();
        }

        @Override
        public void remove() {
            itr.remove();
        }
    }
}


