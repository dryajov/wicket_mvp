package com.chronodrones.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: dryajov
 * Date: 8/28/11
 * Time: 12:17 PM
 *
 * Interface defining the model that the Panel will use
 */
public interface IMvpFormModel extends Serializable {
    String getName();
    void setName(String name);
    String getLastName();
    void setLastName(String lastName);
    String getOccupation();
    void setOccupation(String occupation);
    Date getDOB();
    void setDOB(Date dob);
    String getGender();
    void setGender(String gender);
}
