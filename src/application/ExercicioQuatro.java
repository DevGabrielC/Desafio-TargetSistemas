package src.application;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ExercicioQuatro {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Map<String, Double> faturamentoPorEstado = new HashMap<>();

        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        double total = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Percentual de representação por estado:");

        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            double percentual = (entry.getValue() * 100) / total;
            System.out.println(entry.getKey() + ": " + df.format(percentual) + "%");
        }
    }
}