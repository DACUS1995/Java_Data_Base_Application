package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;


public class Angajati {

    private final SimpleStringProperty fName;
    private final SimpleStringProperty lName;
    private final SimpleDateFormat dataAngajare;
    private final SimpleStringProperty sex;
    private final SimpleStringProperty tel;
    private final SimpleStringProperty email;
    private final SimpleDateFormat dataNastere;
    private final SimpleStringProperty salariu;
    private final SimpleIntegerProperty idEchipa;
    private final SimpleStringProperty specializare;

    public int getIdEchipa() {
        return idEchipa.get();
    }

    public SimpleIntegerProperty idEchipaProperty() {
        return idEchipa;
    }

    public void setIdEchipa(int idEchipa) {
        this.idEchipa.set(idEchipa);
    }

    public void setDataAngajare(String dataAngajare){
        this.dataAngajare.applyPattern(dataAngajare);
    }

    public void setDataNastere(String dataNastere){
        this.dataNastere.applyPattern(dataNastere);
    }

    public String getSpecializare() {
        return specializare.get();
    }

    public SimpleStringProperty specializareProperty() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare.set(specializare);
    }

    public String getSalariu() {
        return salariu.get();
    }

    public SimpleStringProperty salariuProperty() {
        return salariu;
    }

    public void setSalariu(String salariu) {
        this.salariu.set(salariu);
    }

    public SimpleDateFormat getDataNastere() {
        return dataNastere;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
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

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public SimpleDateFormat getDataAngajare() {
        return dataAngajare;
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

    public Angajati() {
        this(null, null,new String(""), null, null, null, new String(""), null, new String("0"), null);
    }

    public Angajati(String fName, String lName, String dataAngajare, String sex, String tel, String email, String dataNastere, String salariu, String idEchipa, String specializare) {
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.dataAngajare = new SimpleDateFormat(dataAngajare);
        this.sex = new SimpleStringProperty(sex);
        this.tel = new SimpleStringProperty(tel);
        this.email = new SimpleStringProperty(email);
        this.dataNastere = new SimpleDateFormat(dataNastere);
        this.salariu = new SimpleStringProperty(salariu);
        this.idEchipa = new SimpleIntegerProperty(Integer.parseInt(idEchipa));
        this.specializare = new SimpleStringProperty(specializare);
    }

    public Angajati(String fName, String lName) {
        this(fName, lName,new String(""), null, null, null,new String(""), null, new String("0"), null);
       // this.fName = new SimpleStringProperty(fName);
       // this.lName = new SimpleStringProperty(lName);
        //this.email = new SimpleStringProperty(email);
    }


//    public String getEmail() {
//        return email.get();
//    }

//    public void setEmail(String fName) {
//        email.set(fName);
//    }

}
