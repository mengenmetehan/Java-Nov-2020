/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.collection;

public class CSDArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message)
    {
        throw new IllegalArgumentException(message);
    }

    private static void doWorkForIndexOutOfBoundsException(String message)
    {
        throw new IndexOutOfBoundsException(message);
    }

    private static void checkCapacityValue(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity can not be negative");
    }

    private void checkIndex(int index)
    {
        if (index < 0 || index >= m_index)
            doWorkForIndexOutOfBoundsException("Index out of bounds");
    }

    private void changeCapacity(int capacity)
    {
        Object [] temp = new Object[capacity];

        System.arraycopy(m_elems, 0, temp, 0, m_index);

        m_elems = temp;
    }

    public CSDArrayList()
    {
        m_elems = new Object[DEFAULT_CAPACITY];
    }

    public CSDArrayList(int capacity)
    {
        checkCapacityValue(capacity);
        m_elems = new Object[capacity];
    }

    public boolean add(Object elem)
    {
        if (m_elems.length == m_index)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, Object elem)
    {
        //TODO:
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int capacity)
    {
        if (capacity < m_elems.length)
            return;

        changeCapacity(Math.max(m_elems.length * 2, capacity));
    }

    public Object get(int index)
    {
        checkIndex(index);

        return m_elems[index];
    }

    public Object set(int index, Object elem)
    {
        checkIndex(index);
        Object oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }


    private Object remove(int index)
    {
        //TODO:
        Object oldVal = m_elems[index];

        //TODO:

        return oldVal;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        if (m_index != m_elems.length)
            changeCapacity(m_index);
    }

    public String toString()
    {
        String str = "[";

        for (int i = 0; i < m_index; ++i) {
            if (str.length() != 1)
                str += ", ";

            str += m_elems[i];
        }

        return str + "]";
    }
}
