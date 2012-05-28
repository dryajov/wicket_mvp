package com.chronodrones.model;

import org.apache.wicket.model.Model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: dryajov
 * Date: 8/28/11
 * Time: 12:18 PM
 */
public class MvpFormModel extends Model<IMvpFormModel> implements IMvpFormModel{
    String name;
    String lastName;
    Date dob;
    String occupation;
    String gender;

    public MvpFormModel(String name, String lastName, Date dob, String occupation, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.occupation = occupation;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return dob;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public IMvpFormModel getObject() {
        return this;
    }
}
