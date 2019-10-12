/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDefs({
	@FilterDef(name = "filterByBMWMake", parameters={@ParamDef(name = "make", type = "string")})
})
@Filter(name = "filterByBMWMake",condition="make = :make")
public class Car{

	@Id
	@GeneratedValue
    private int id;
    private String name = null;
    private String color = null;
    private String make = null;
    private String model = null;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", make=" + make
				+ ", model=" + model + "]";
	}
    
}
