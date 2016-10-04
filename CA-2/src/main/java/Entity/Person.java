/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Thesoap
 */
@Entity
public class Person extends InfoEntity {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String fn;
    private String ln;
    @ManyToMany
    @JoinTable(
            name = "PersonHobbyList",
            joinColumns = @JoinColumn(name = "PersonID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "HobbyID", referencedColumnName = "id"))
    List<Hobby> hobby = new ArrayList();

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }

}
