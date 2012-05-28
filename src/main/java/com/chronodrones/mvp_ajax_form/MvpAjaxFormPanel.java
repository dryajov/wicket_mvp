package com.chronodrones.mvp_ajax_form;

import com.chronodrones.model.IMvpFormModel;
import com.chronodrones.controllers.MvpFormController;
import com.chronodrones.views.IMvpFormView;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dryajov
 * Date: 8/28/11
 * Time: 12:16 PM
 */
public class MvpAjaxFormPanel extends Panel implements IMvpFormView {
    private Form form;
    private AjaxButton submit;

    private Label name;
    private TextField nameEdit;

    private Label lastName;
    private TextField lastNameEdit;

    private Label dob;
    private TextField dobEdit;

    private Label occupation;
    private TextField occupationEdit;

    private Label gender;
    private RadioChoice genderEdit;

    private List<String> genderList = Arrays.asList(new String[]{"Male", "Female"});

    private MvpFormController controller;

    public MvpAjaxFormPanel(String id, IModel<IMvpFormModel> model) {
        super(id, model);

        controller = new MvpFormController(this, model.getObject());
    }

    @Override
    public void onBeforeRender() {
        super.onBeforeRender();

        IMvpFormModel model = (IMvpFormModel) getDefaultModelObject();

        form = new Form("mvpForm", getDefaultModel());

        name = new Label("name", new PropertyModel<String>(getDefaultModel(), "name"));
        nameEdit = new TextField<String>("nameEdit", new PropertyModel<String>(getDefaultModel(), "name"));

        lastName = new Label("lastName", new PropertyModel<String>(model, "lastName"));
        lastNameEdit = new TextField<String>("lastNameEdit", new PropertyModel<String>(getDefaultModel(), "lastName"));

        dob = new Label("dob", new PropertyModel<String>(getDefaultModel(), "dob"));
        dobEdit = new TextField<Date>("dobEdit", new PropertyModel<Date>(getDefaultModel(), "DOB"));

        occupation = new Label("occupation", new PropertyModel<String>(getDefaultModel(), "occupation"));
        occupationEdit = new TextField<String>("occupationEdit", new PropertyModel<String>(getDefaultModel(), "occupation"));

        gender = new Label("gender", new PropertyModel<String>(getDefaultModel(), "gender"));
        genderEdit = new RadioChoice<String>("genderEdit", new PropertyModel<String>(getDefaultModel(), "gender"), genderList).setSuffix(" ");


        boolean selected = false;
        form.add(new AjaxCheckBox("editForm", new Model<Boolean>(selected)) {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                controller.update();
                target.addComponent(form); // repaint form
            }
        });

        submit =new AjaxButton("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                controller.submit(); // perform submit related logic
                target.addComponent(form); // repaint form
            }
        };

        form.add(submit);

        form.add(name);
        form.add(nameEdit);

        form.add(lastName);
        form.add(lastNameEdit);

        form.add(dob);
        form.add(dobEdit);

        form.add(occupation);
        form.add(occupationEdit);

        form.add(gender);
        form.add(genderEdit);

        add(form);
        controller.update();
    }

    public void showEditView() {
        name.setVisible(false);
        lastName.setVisible(false);
        dob.setVisible(false);
        occupation.setVisible(false);
        gender.setVisible(false);

        nameEdit.setVisible(true);
        lastNameEdit.setVisible(true);
        dobEdit.setVisible(true);
        occupationEdit.setVisible(true);
        genderEdit.setVisible(true);

        submit.setVisible(true);
    }

    public void showDisplayView() {
        name.setVisible(true);
        lastName.setVisible(true);
        dob.setVisible(true);
        occupation.setVisible(true);
        gender.setVisible(true);

        nameEdit.setVisible(false);
        lastNameEdit.setVisible(false);
        dobEdit.setVisible(false);
        occupationEdit.setVisible(false);
        genderEdit.setVisible(false);

        submit.setVisible(false);
    }
}
