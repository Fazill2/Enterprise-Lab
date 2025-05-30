package lab.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlSelectBooleanCheckbox;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

@RequestScoped
@Named
public class LoginBean {
    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public String login(){
        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activateButton(ValueChangeEvent e)
    {
        loginButton.setDisabled(!acceptCheckbox.isSelected());
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
}
