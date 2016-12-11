package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;


public class Clienti {

    private final SimpleStringProperty lName;
    private final SimpleStringProperty fName;
    private final SimpleStringProperty tel;
    private final SimpleStringProperty mail;
    private final SimpleDateFormat dataIntregistrare;
    private final SimpleIntegerProperty idClient;

    public int getIdClient() {
        return idClient.get();
    }

    public SimpleIntegerProperty idClientProperty() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
    }

    public SimpleDateFormat getDataIntregistrare() {
        return dataIntregistrare;
    }

    public void setDataIntregistrare(String dataIntregistrare) {
        this.dataIntregistrare.applyPattern(dataIntregistrare);
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getTel() {
        return tel.get();
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getfName() {
        return fName.get();
    }

    public SimpleStringProperty fNameProperty() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName.set(fName);
    }

    public String getlName() {
        return lName.get();
    }

    public SimpleStringProperty lNameProperty() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName.set(lName);
    }

    public Clienti(String idClient, String lName, String fName, String tel, String mail, String dataIntregistrare) {
        this.lName = new SimpleStringProperty(lName);
        this.fName = new SimpleStringProperty(fName);
        this.tel = new SimpleStringProperty(tel);
        this.mail = new SimpleStringProperty(mail);
        this.dataIntregistrare = new SimpleDateFormat(dataIntregistrare);
        this.idClient = new SimpleIntegerProperty(Integer.parseInt(idClient));
    }

    public Clienti() {
        this(new String("0"), null, null, null, null, new String(""));
    }

    public Clienti(String fName, String lName) {
        this(new String("0"),fName, lName,null, null,new String(""));
        // this.fName = new SimpleStringProperty(fName);
        // this.lName = new SimpleStringProperty(lName);
        //this.email = new SimpleStringProperty(email);
    }

}
