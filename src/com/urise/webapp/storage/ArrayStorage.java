package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */


public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    public void update(Resume r){
        for (int i = 0; i < size; i++) {
            if (r.getUuid() == storage[i].getUuid()) {
                storage[i] = r;
                System.out.println("Элемент с UUID = " + r.getUuid() + " обновлен.");
            }
        }
    }

    public void save(Resume r) {
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                storage[i] = storage[size - 1];
                storage[i] = null;
                size--;
                System.out.println("Элемент с UUID = " + uuid + " удален.");
                System.out.println("Новый размер массива - " + size );
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume result[] = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    public int size() {
        return size;
    }
}
