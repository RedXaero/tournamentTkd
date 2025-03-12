package com.tournament.tournament.entities;

import com.tournament.tournament.utils.Grades;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String aPaterno;
    private String aMaterno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fech_nac")
    private LocalDateTime fechaNacimiento;


    private Float altura;
    private Float peso;
    private String sexo;

    @Enumerated(EnumType.STRING)
    private Grades grado;

    public Player() {
    }

    public Player(UUID id, String name, String aPaterno, String aMaterno, LocalDateTime fechaNacimiento, Float altura, Float peso, String sexo, String grado) {
        this.id = id;
        this.name = name;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.grado = Grades.valueOf(grado);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Grades getGrado() {
        return grado;
    }

    public void setGrado(Grades grado) {
        this.grado = grado;
    }
}
