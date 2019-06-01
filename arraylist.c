#include <stdlib.h>
#include <stdio.h>

#define INITIAL_CAPACITY 10

enum STATUS {
    FAILURE,
    SUCCESS
};

struct arraylist {
    int capacity;   // how many elements can currently fit in
    int *content;   // pointer to array with content
    int size;       // current number of elements
};

/*
 * Returns pointer to freshly created arraylist which is
 * initialized with a array of size INITIAL_CAPACITY.
 */
struct arraylist* new_arraylist() {
    struct arraylist *init = (struct arraylist*)malloc(sizeof (struct arraylist));
    int *content = malloc(INITIAL_CAPACITY);

    init->capacity = INITIAL_CAPACITY;
    init->content = content;
    init->size = 0;
    
    return init;
}

/*
 * Returns size of given list.
 */
int arraylist_size(struct arraylist *list) {
    return list->size;
}

/*
 * Appends element to list (next free slot).
 * Returns SUCCESS if appending was successfull, else FAILURE.
 */
int arraylist_append(struct arraylist *list, int val) {
    list->content[list->size] = val;
    list->size++;
    return SUCCESS;
}

/*
 * Gets element from list at idx.
 */
int arraylist_get(struct arraylist *list, int idx) {
    return list->content[idx];
}

int main() {
    struct arraylist *list = new_arraylist();
    
    printf("size before insertion: %d\n", arraylist_size(list));
    arraylist_append(list, 1);
    
    printf("size after insertion: %d", arraylist_size(list));
    printf("inserted value: %d", arraylist_get(list, 0));
    
    return 0;
}