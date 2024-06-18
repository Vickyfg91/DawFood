/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawfood;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Victoria
 */
public class TarjetaCredito {

    private String titular;
    private String numTarjeta;
    private String cvv;
    private int mesCaducidad;
    private int anyoCaducidad;
    private String pin;
    private double saldo;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String titular, String numTarjeta, String cvv, int mesCaducidad, int anyoCaducidad, String pin, double saldo) {
        this.titular = titular;
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.mesCaducidad = mesCaducidad;
        this.anyoCaducidad = anyoCaducidad;
        this.pin = pin;
        this.saldo = saldo;
    }

    

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public int getAnyoCaducidad() {
        return anyoCaducidad;
    }

    public void setAnyoCaducidad(int anyoCaducidad) {
        this.anyoCaducidad = anyoCaducidad;
    }

    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarjetaCredito{");
        sb.append("titular=").append(titular);
        sb.append(", numTarjeta=").append(numTarjeta);
        sb.append(", cvv=").append(cvv);
        sb.append(", mesCaducidad=").append(mesCaducidad);
        sb.append(", anyoCaducidad=").append(anyoCaducidad);
        sb.append(", pin=").append(pin);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titular);
        hash = 89 * hash + Objects.hashCode(this.numTarjeta);
        hash = 89 * hash + Objects.hashCode(this.cvv);
        hash = 89 * hash + this.mesCaducidad;
        hash = 89 * hash + this.anyoCaducidad;
        hash = 89 * hash + Objects.hashCode(this.pin);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TarjetaCredito other = (TarjetaCredito) obj;
        if (this.mesCaducidad != other.mesCaducidad) {
            return false;
        }
        if (this.anyoCaducidad != other.anyoCaducidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        if (!Objects.equals(this.numTarjeta, other.numTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.cvv, other.cvv)) {
            return false;
        }
        return Objects.equals(this.pin, other.pin);
    }

    

    
}
