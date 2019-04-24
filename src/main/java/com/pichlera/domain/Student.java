package com.pichlera.domain;



import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Student.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matrikelnummer")
    private Long matrikelnummer;

    @NotNull
    @Column(name = "nachname", nullable = false)
    private String nachname;

    @NotNull
    @Column(name = "vorname", nullable = false)
    private String vorname;

    @NotNull
    @Column(name = "strasse_hausnummer", nullable = false)
    private String strasse_hausnummer;

    @NotNull
    @Column(name = "postleitzahl", nullable = false)
    private Integer postleitzahl;

    @NotNull
    @Column(name = "ort", nullable = false)
    private String ort;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatrikelnummer() {
        return matrikelnummer;
    }

    public Student matrikelnummer(Long matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
        return this;
    }

    public void setMatrikelnummer(Long matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getNachname() {
        return nachname;
    }

    public Student nachname(String nachname) {
        this.nachname = nachname;
        return this;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Student vorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse_hausnummer() {
        return strasse_hausnummer;
    }

    public Student strasse_hausnummer(String strasse_hausnummer) {
        this.strasse_hausnummer = strasse_hausnummer;
        return this;
    }

    public void setStrasse_hausnummer(String strasse_hausnummer) {
        this.strasse_hausnummer = strasse_hausnummer;
    }

    public Integer getPostleitzahl() {
        return postleitzahl;
    }

    public Student postleitzahl(Integer postleitzahl) {
        this.postleitzahl = postleitzahl;
        return this;
    }

    public void setPostleitzahl(Integer postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public Student ort(String ort) {
        this.ort = ort;
        return this;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        if (student.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", matrikelnummer=" + getMatrikelnummer() +
            ", nachname='" + getNachname() + "'" +
            ", vorname='" + getVorname() + "'" +
            ", strasse_hausnummer='" + getStrasse_hausnummer() + "'" +
            ", postleitzahl=" + getPostleitzahl() +
            ", ort='" + getOrt() + "'" +
            "}";
    }
}
