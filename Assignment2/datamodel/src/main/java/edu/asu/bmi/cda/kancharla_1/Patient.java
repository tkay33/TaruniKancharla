/**
 * Created by Taruni on 01-02-2015.
 */

package edu.asu.bmi.cda.kancharla_1;
public class Patient {

    private int id, age;
    private String name;

// constructor

    public Patient() {
        id = 0;
        age = 0;
        name = "default";
    }
//Constructor 2

    public Patient(int i, int j, String k) {
        this.id = i;
        this.age = j;
        this.name = k;
    }

    public int get() {
        System.out.println("Name = " + name + "ID = " + id + "Age = " + age);
        return 0;
    }

    public void set(int i, int j, String k) {
        this.id = i;
        this.age = j;
        this.name = k;
    }
}
