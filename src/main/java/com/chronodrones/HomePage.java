package com.chronodrones;

import com.chronodrones.model.MvpFormModel;
import com.chronodrones.mvp_ajax_form.MvpAjaxFormPanel;
import com.chronodrones.mvp_submit_form.MvpSubmitFormPanel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        Date dob = null;
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse("19/10/1981");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final MvpFormModel model = new MvpFormModel("John", "Doe", dob, "grave digger", "Male");

        if (parameters.containsKey("p")) {
            add(new MvpAjaxFormPanel("mvpPanel", model));
        } else {
           add(new MvpSubmitFormPanel("mvpPanel", model));
        }

        add(new Link("link1") {
            @Override
            public void onClick() {
                if (!parameters.containsKey("p"))
                    parameters.add("p", String.valueOf(1));
                setResponsePage(HomePage.class, parameters);
            }
        });

        add(new Link("link2") {
            @Override
            public void onClick() {
                parameters.remove("p");
                setResponsePage(HomePage.class, parameters);
            }
        });
    }
}
