/******************************************************************************
 *
 * Blauäugige Umsetzung einer Arrayliste.
 *
 * Folgende Operationen stehen zur Verfügung:
 *   - Größe ermitteln
 *   - Element hinten anhängen
 *   - Element vorne anhängen
 *   - Element an beliebiger Stelle ermitteln
 *   - Element an beliebiger Stelle entfernen
 *
 *****************************************************************************/


public class ArrayList<T> {
    private int maxSize = 1;        // aktuell fassbare Elemente
    private T[] values = (T[])new Object[maxSize];
    private int currentSize = 0;    // aktuell gefasste Elemente

    /*
    Eine Liste besteht aus einem statischen Array mit begrenzter Größe (definiert über maxSize).
    Um das Fassungsvermögen einer Liste zu erhöhen, muss ein neues Array angelegt werden, in das die "alten" Werte
    hineinkopiert werden.
    Standardmäßig wird das Array bei jeder Vergrößerung verzehnfacht.
     */
    private void allocateMemory() {
        T[] tmp = (T[])new Object[10*maxSize];   // neues Array zehnfacher Größe anlegen
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

    /*
    Gibt das Element an der Stelle idx zurück (beginnend bei 0).
     */
    public T get(int idx) {
        if(idx<0 || idx>=currentSize) {
            throw new IndexOutOfBoundsException();
        }
        return values[idx];
    }

    public boolean remove(int idx) {
        T[] tmp = (T[]) new Object[currentSize-1];
        for(int i=0; i<currentSize-1; i++)
            tmp[i] = values[i<idx ? i : i+1];   // bis zum (idx-1). Element kopieren, danach eine Stelle überspringen
        values = tmp;
        currentSize--;
        return true;
    }

    public void print(){
        for(int i=0; i<currentSize;i++)
            System.out.println(values[i]);
    }
}
