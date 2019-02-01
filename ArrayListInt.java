public class ArrayListInt {
    private int maxSize = 1;        // aktuell fassbare Elemente
    private int[] values = new int[maxSize];
    private int currentSize = 0;    // aktuell gefasste Elemente

    /*
    Eine Liste besteht aus einem statischen Array mit begrenzter Größe (definiert über maxSize).
    Um das Fassungsvermögen einer Liste zu erhöhen, muss ein neues Array angelegt werden, in das die "alten" Werte
    hineinkopiert werden.
    Standardmäßig wird das Array bei jeder Vergrößerung verdoppelt.
     */
    private void allocateMemory() {
        int[] tmp = new int[2*maxSize];     // neues Array doppelter Größe anlegen
        for(int i=0; i<maxSize; i++) {      // Werte umspeichern
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
    public boolean append(int val) {
        if(currentSize == maxSize)
            allocateMemory();
        values[currentSize] = val;
        currentSize++;
        return true;
    }

    /*
    Fügt ein Element vorne an die Liste an.
    todo: prepend überschreibt alles nach dem 1. Wert mit Nullen :(
     */
    public boolean prepend(int val) {
        if(currentSize == maxSize)
            allocateMemory();
        int[] tmp = new int[maxSize];
        tmp[0] = val;
        for(int i=1; i==currentSize; i++) {
            tmp[i] = values[i - 1];
        }
        values = tmp;
        return true;
    }

    public void print(){
        for(int i=0; i<currentSize;i++)
            System.out.println(values[i]);
    }
}
