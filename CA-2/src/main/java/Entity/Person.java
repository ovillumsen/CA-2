/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thesoap
 */
@Entity
@XmlRootElement
@Table(name = "PERSON")
public class Person extends InfoEntity {
    
    private String fn;
    private String ln;
    
    @ManyToMany
    List<Hobby> hobby = new ArrayList();
    
    public Person(){
        
    }
    
    public Person(String fn,String ln){
        this.fn = fn;
        this.ln = ln;
    }
    
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

}
