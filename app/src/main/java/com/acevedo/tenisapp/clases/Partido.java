package com.acevedo.tenisapp.clases;

public class Partido {
    int id;
    String fechaPartido;
    String horaPartido;
    int cancha;
    String jugador1;
    String jugador2;


    public Partido() {
    }

    public Partido(int id, String fechaPartido, String horaPartido, int cancha, String jugador1, String jugador2) {
        this.id = id;
        this.fechaPartido = fechaPartido;
        this.horaPartido = horaPartido;
        this.cancha = cancha;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getHoraPartido() {
        return horaPartido;
    }

    public void setHoraPartido(String horaPartido) {
        this.horaPartido = horaPartido;
    }

    public int getCancha() {
        return cancha;
    }

    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
}
