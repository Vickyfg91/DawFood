/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawfood;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victoria
 */
public class PasarelaDePago {

    private Map<TarjetaCredito, Integer> tarjetas;
   

    public PasarelaDePago() {
        this.tarjetas = new HashMap<>();
        inicializarTarjetas();
    }

    public PasarelaDePago(Map<TarjetaCredito, Integer> tarjetas) {
        this.tarjetas = new HashMap<>(tarjetas);
        inicializarTarjetas();
    }

    

    public Map<TarjetaCredito, Integer> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Map<TarjetaCredito, Integer> tarjetas) {
        this.tarjetas = tarjetas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PasarelaDePago{");
        tarjetas.forEach((tarjeta, cantidad) -> {
            sb.append(tarjeta.toString()).append(", Cantidad: ").append(cantidad).append("; \n");
        });
        sb.append('}');
        return sb.toString();
    }
    
    private void inicializarTarjetas() {
        TarjetaCredito tarjeta1 = new TarjetaCredito("Juan Carlos Vico", "4444785", "123", 11,2024, "1234", 15000);
        tarjetas.put(tarjeta1, 1);
        TarjetaCredito tarjeta2 = new TarjetaCredito("Victoria Fernandez", "357891", "456",8,2026, "1234", 1800);
        tarjetas.put(tarjeta2, 2);
        TarjetaCredito tarjeta3 = new TarjetaCredito("Rocío Alcalá", "78149564", "789", 7, 2023, "1234", 0);
        tarjetas.put(tarjeta3, 3);
    }
    

}
