package service;

import exception.ArrayIndexOutBondsException;
import exception.ElementMissingException;

import java.util.Arrays;

public class IntegerListService implements IntegerList {
    private int n = 5;
    private Integer[] integerList = new Integer[n];
    private int size = 0;
    public int index = 0;
    public Integer removeItem;
    @Override
    public Integer add(Integer item) {
        if (size == integerList.length) {
            grow();
        }
        integerList[index] = item;
        size++;
        index++;
        return integerList[index - 1];
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= size || index>=integerList.length -1){
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы массива");
        }
        for (int i = integerList.length - 1; i == index; i--) {
            integerList[i] = integerList[i - 1];
        }
        integerList[index] = item;
        size++;
        return integerList[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= size || index >= integerList.length - 1) {
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы массива");
        }
        integerList[index] = item;
        return integerList[index];
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < integerList.length - 1; i++) {
            if (integerList[i] == item) {
                removeItem = integerList[i];
                integerList[i] = 0;
                size--;
                break;
            }
            for (int j = i; j < integerList.length - 1; j++) {
                integerList[j] = integerList[i + 1];
            }
        }
        return removeItem;
    }

    @Override
    public  Integer remove(int index) {
        if (index > integerList.length - 1) {
            throw new ArrayIndexOutBondsException("Индес вышел за пределы");
        }
        if (integerList[index] == null) {
            throw new ElementMissingException("Элемент отсутствует");
        } else {
            removeItem = integerList[index];
            integerList[index] = null;
            size--;
        }
        for (int i = index; i < integerList.length - 1; i++) {
            integerList[i] = integerList[index + 1];
        }
        return removeItem ;
    }
    @Override
    public boolean contains(Integer item) {
        quickSort(integerList, 0, size - 1);
        return containsBinary(item);
    }

    @Override
    public int indexOf(Integer item) {
        int indexOf = -1;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == item) {
                indexOf = i;
            }
        }
        return indexOf;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int lastIndexOf = -1;
        for (int i = integerList.length - 1; i >=0 ; i--) {
            if (integerList[i] == item) {
                lastIndexOf = i;
                break;
            }
        }
        return lastIndexOf;
    }

    @Override
    public Integer get(int index) {
        Integer getItem = null;
        if (index > integerList.length - 1) {
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы");
        }
        getItem = integerList[index];
        return getItem;
    }
    @Override
    public boolean equals(IntegerList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    public Object clear() {
        for (int i = 0; i < integerList.length; i++) {
            integerList[i] = 0;
        }
        return null;
    }

    @Override
    public Integer[] toArray() {
        int n = integerList.length;
        Integer[] toArrayMas = null;
        Integer[] toArray = Arrays.copyOf(integerList, n);
        toArrayMas = toArray;
        return toArrayMas;
    }

    public boolean containsBinary(Integer item) {
        int min = 0;
        int max = size - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (item == integerList[mid]) {
                return true;
            }
            if (item < integerList[mid]) {
                max = mid + 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    public Integer grow() {
        n = (int) (integerList.length * 1.5);
        Integer[] integerListAdvanced = new Integer[n];
        integerListAdvanced = Arrays.copyOf(integerList, n);
        clear();
        integerList = Arrays.copyOf(integerListAdvanced, integerListAdvanced.length);
        return integerList.length;
    }

    public static void quickSort(Integer[] integerList, int begin, int end) {
        if (begin < end) {
            Integer partitionIndex = partition(integerList, begin, end);
            quickSort(integerList, begin, partitionIndex - 1);
            quickSort(integerList, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] integerList, int begin, int end) {
        Integer pivot = integerList[end];
        int i = (begin - 1);
        for (int j = begin; j < end  ; j++) {
            if (integerList[j] <= pivot) {
                i++;
                swapElements(integerList, i, j);
            }
        }
        swapElements(integerList, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] integerList, int left, int right) {
        int temp = integerList[left];
        integerList[left] = integerList[right];
        integerList[right] = temp;
    }
}
