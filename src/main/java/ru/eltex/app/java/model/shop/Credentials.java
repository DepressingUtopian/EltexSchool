package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.eltex.app.java.config.View;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "credentials")
public class Credentials implements Serializable {

    static transient private int countCredentials = 1;

    private transient Scanner in = new Scanner(System.in);
    @OneToOne(mappedBy = "credential")
    private ShoppingCart shoppingCart;

    @Column(name = "families")
    @JsonView(View.Summary.class)
    private String Families;
    @Column(name = "name")
    @JsonView(View.Summary.class)
    private String Name;
    @Column(name = "ochers")
    @JsonView(View.Summary.class)
    private String Ochers;
    @Column(name = "email")
    @JsonView(View.Summary.class)
    private String email;
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Summary.class)
    private int ID;

    public Credentials() {

    }

    public Credentials(int ID, String families, String name, String ochers, String email) {
        //  ID = countCredentials;
        //  countCredentials++;
        //  this.ID = ID;
        this.Families = families;
        this.Name = name;
        this.Ochers = ochers;
        this.email = email;
    }

    public Credentials(String families, String name, String ochers, String email) {
        //  ID = countCredentials;
        //   countCredentials++;
        //  this.ID = ID;
        this.Families = families;
        this.Name = name;
        this.Ochers = ochers;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getFamilies() {
        return Families;
    }

    public String getName() {
        return Name;
    }

    public String getOchers() {
        return Ochers;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFamilies(String families) {
        Families = families;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOchers(String ochers) {
        Ochers = ochers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void Input() {
        System.out.println("------------------------------------------------");
        System.out.println("Введите ФИО");
        System.out.println("Введите Фамилию: ");
        setFamilies(in.nextLine());
        System.out.println("Введите Имя: ");
        setName(in.nextLine());
        System.out.println("Введите Отчество:");
        setOchers(in.nextLine());
        System.out.println("Введите email:");
        setEmail(in.nextLine());
    }


}
