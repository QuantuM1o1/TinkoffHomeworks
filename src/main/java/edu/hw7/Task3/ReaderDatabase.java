package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderDatabase implements PersonDatabase {
    private final Map<String, List<Person>> nameMap;
    private final Map<String, List<Person>> addressMap;
    private final Map<String, List<Person>> phoneNumberMap;
    private final Map<Integer, Person> idMap;
    private final ReadWriteLock lock;

    public ReaderDatabase() {
        nameMap = new HashMap<>();
        addressMap = new HashMap<>();
        phoneNumberMap = new HashMap<>();
        idMap = new HashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            idMap.put(person.id(), person);
            nameMap.putIfAbsent(person.name(), new ArrayList<>());
            nameMap.get(person.name()).add(person);
            addressMap.putIfAbsent(person.address(), new ArrayList<>());
            addressMap.get(person.address()).add(person);
            phoneNumberMap.putIfAbsent(person.phoneNumber(), new ArrayList<>());
            phoneNumberMap.get(person.phoneNumber()).add(person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            nameMap.get(idMap.get(id).name()).remove(idMap.get(id));
            addressMap.get(idMap.get(id).address()).remove(idMap.get(id));
            phoneNumberMap.get(idMap.get(id).phoneNumber()).remove(idMap.get(id));
            idMap.remove(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return nameMap.get(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return addressMap.get(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return phoneNumberMap.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
