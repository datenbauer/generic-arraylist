public class ArrayListInt {
    private int maxSize = 1;
    private int[] values = new int[maxSize];
    private int currentSize = 0;

    /*
    Eine Liste besteht aus einem statischen Array mit begrenzter Größe (definiert über maxSize).
    Um das Fassungsvermögen einer Liste zu erhöhen, muss ein neues Array angelegt werden, in das die "alten" Werte
    hineinkopiert werden.
    Standardmäßig wird das Array bei jeder Vergrößerung verdoppelt.
     */
    private void allocateMemory() {
        maxSize *= 2;
        int[] tmp = new int[maxSize];
        for(int i=0; i<maxSize; i++) {
            tmp[i] = values[i];
        }
        values = tmp;
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
    public boolean append(int val) {
        if(currentSize == maxSize)
            allocateMemory();
        values[currentSize] = val;
        currentSize++;
        return true;
    }
}
