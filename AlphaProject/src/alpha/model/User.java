/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.model;

/**
 *
 * @author RunEvil
 */
public class User {
    public String name;
    public Stash stash;

    public User() {
    }

    public User(String name, Stash stash) {
        this.name = name;
        this.stash = stash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stash getStash() {
        return stash;
    }

    public void setStash(Stash stash) {
        this.stash = stash;
    }
}