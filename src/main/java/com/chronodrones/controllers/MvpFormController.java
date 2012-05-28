package com.chronodrones.controllers;

import com.chronodrones.model.IMvpFormModel;
import com.chronodrones.views.IMvpFormView;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: dryajov
 * Date: 8/28/11
 * Time: 12:24 PM
 */
public class MvpFormController implements Serializable {
    private IMvpFormView view;
    private IMvpFormModel model;

    private boolean editable;

    public MvpFormController(IMvpFormView view, IMvpFormModel model) {
        this.view = view;
        this.model = model;
    }

    public void submit() {
        // perform submit related logic here
        update();
    }

    public void update() {
        if (editable) {
            view.showEditView();
        } else {
            view.showDisplayView();
        }

        editable = !editable;
    }
}
