import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Float> saltos = new ArrayList<>();
        List<String> saltosStr = new ArrayList<>();
        System.out.println("Atleta: ");
        String nome = entrada.nextLine();
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "º salto(em metros): ");
            String saltoStr = entrada.nextLine();
            saltosStr.add(saltoStr);
            Float salto = Float.parseFloat(saltoStr);
            saltos.add(salto);
        }
        Float soma = 0.0f;
        for (Float i : saltos) {
            soma += i;
        }
        Float media = soma / saltos.size(); 
        System.out.println("Resultado final: ");
        System.out.println("Atleta: " + nome);
        String saltosstr = String.join(" - ", (saltosStr));
        System.out.println("Saltos: " + saltosstr);
        System.out.println("Media dos saltos: " + media + " m");
    }
}
