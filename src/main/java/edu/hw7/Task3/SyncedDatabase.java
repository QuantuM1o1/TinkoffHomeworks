package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncedDatabase implements PersonDatabase {
    private final Map<String, List<Person>> nameMap;
    private final Map<String, List<Person>> addressMap;
    private final Map<String, List<Person>> phoneNumberMap;
    private final Map<Integer, Person> idMap;

    public SyncedDatabase() {
        nameMap = new HashMap<>();
        addressMap = new HashMap<>();
        phoneNumberMap = new HashMap<>();
        idMap = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        idMap.put(person.id(), person);
        nameMap.putIfAbsent(person.name(), new ArrayList<>());
        nameMap.get(person.name()).add(person);
        addressMap.putIfAbsent(person.address(), new ArrayList<>());
        addressMap.get(person.address()).add(person);
        phoneNumberMap.putIfAbsent(person.phoneNumber(), new ArrayList<>());
        phoneNumberMap.get(person.phoneNumber()).add(person);
    }

    @Override
    public synchronized void delete(int id) {
        nameMap.get(idMap.get(id).name()).remove(idMap.get(id));
        addressMap.get(idMap.get(id).address()).remove(idMap.get(id));
        phoneNumberMap.get(idMap.get(id).phoneNumber()).remove(idMap.get(id));
        idMap.remove(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return nameMap.get(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressMap.get(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return phoneNumberMap.get(phone);
    }
}
