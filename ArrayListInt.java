public class ArrayList<T> {
    private int maxSize = 1;        // aktuell fassbare Elemente
    private T[] values = (T[])new Object[maxSize];
    private int currentSize = 0;    // aktuell gefasste Elemente

    /*
    Eine Liste besteht aus einem statischen Array mit begrenzter Größe (definiert über maxSize).
    Um das Fassungsvermögen einer Liste zu erhöhen, muss ein neues Array angelegt werden, in das die "alten" Werte
    hineinkopiert werden.
    Standardmäßig wird das Array bei jeder Vergrößerung verdoppelt.
     */
    private void allocateMemory() {
        T[] tmp = (T[])new Object[2*maxSize];   // neues Array doppelter Größe anlegen
        for(int i=0; i<maxSize; i++) {          // Werte umspeichern
            tmp[i] = values[i];
        }
        values = tmp;
        maxSize *= 2;
    }

    /*
    Gibt die Größe der Liste zurück (Anzahl der gespeicherten Elemente).
     */
    public int size() {
        return currentSize;
    }

    /*
    Fügt ein Element hinten an die Liste an.
     */
    public boolean append(T val) {
        if(currentSize == maxSize)
            allocateMemory();
        values[currentSize] = val;
        currentSize++;
        return true;
    }

    /*
    Fügt ein Element vorne an die Liste an.
     */
    public boolean prepend(T val) {
        if(currentSize == maxSize)
            allocateMemory();
        T[] tmp = (T[])new Object[maxSize];
        tmp[0] = val;
        currentSize++;
        for(int i=1; i<currentSize; i++) {
            tmp[i] = values[i - 1];
        }
        values = tmp;
        return true;
    }

    public T get(int idx) {
        if(idx<0 || idx>=currentSize) {
            throw new IndexOutOfBoundsException();
        }
        return values[idx];
    }

    public void print(){
        for(int i=0; i<currentSize;i++)
            System.out.println(values[i]);
    }
}
