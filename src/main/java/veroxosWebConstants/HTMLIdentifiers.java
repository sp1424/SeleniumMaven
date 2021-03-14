package veroxosWebConstants;

public class HTMLIdentifiers {

    private HTMLIdentifiers(){

    }

    //Contact button has no Id and its css class has been used mutliple times so find link by text seems safer
    public static final String HOME_CONTACT_LINK_TEXT = "Contact";

    public static final String CONTACT_FULL_NAME_FIELD_ID = "form-field-name";

    public static final String CONTACT_JOB_TITLE_FIELD_ID = "form-field-field_958ec42";

    public static final String CONTACT_ORGANISATION_FIELD_ID = "form-field-field_f16ac5a";

    //It seems that the html within the web page has the id of the phone input field as form-field-email
    public static final String CONTACT_PHONE_FIELD_ID = "form-field-email";

    public static final String CONTACT_EMAIL_FIELD_ID = "form-field-field_1";

    public static final String CONTACT_MESSAGE_FIELD_ID = "form-field-message";

    //Not selecting the button - this span is within the submit button so clicking on this would submit form
    public static final String CONTACT_SUBMIT_FORM_SPAN_IDENTIFIER = "//span[@class='elementor-align-icon-right elementor-button-icon']";
}
