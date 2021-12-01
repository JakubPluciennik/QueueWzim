package pl.sggw;

import java.util.NoSuchElementException;

public class SimpleWzimBoundedQueue<E> implements WzimBoundedQueue<E> {

    private E[] tablica;
    private int size = 0;
    public SimpleWzimBoundedQueue(final int maxCapacity) {
        tablica = (E[])new Object[maxCapacity];
    }

    @Override
    public boolean add(E e) {
         if(size<tablica.length)
         {
             tablica[size] = e;
             size++;
             return true;
         }
         else throw new IllegalStateException("Nie ma miejsca na dodanie wartości");
    }

    @Override
    public boolean offer(E e) {
        if(size<tablica.length)
        {
            tablica[size] = e;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E remove() {
        if(size>0)
        {
            E wynik = tablica[0];
            for (int i = 0; i < tablica.length-1; i++) {      //przesunięcie elementów w lewo
                tablica[i] = tablica[i+1];
            }
            size--;
            tablica[size] = null;
            return wynik;
        }
        else throw new NoSuchElementException("Brak Elementu");


    }

    @Override
    public E poll() {
        if(size==0) return null;
        else {
            E wynik = tablica[0];
            for (int i = 0; i < tablica.length-1; i++) {      //przesunięcie elementów w lewo
                tablica[i] = tablica[i+1];
            }
            size--;
            tablica[size] = null;

            return wynik;
        }
    }

    @Override
    public E element() {

                if(size>0){
                    return tablica[0];
                }
                else throw new NoSuchElementException("Brak elementu");
    }

    @Override
    public E peek() {
        if(size==0) return null;
        else {
            return tablica[0];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return tablica.length;
    }
}
