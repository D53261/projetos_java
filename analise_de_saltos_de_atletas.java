//Projeto criado a partir do site de atividades em Python, adaptado para Java
//Link do site: https://wiki.python.org.br/ExerciciosListas
//Biblioteca para criar variaveis que recebem informação, ou "input's"
import java.util.Scanner;
//Duas bibliotecas usadas para criar listas em Java
import java.util.ArrayList;
import java.util.List;

//Criando a classe inicial para que o código funcione
public class App {
    //Criando o método principal, que sempre será o primeiro a rodar quando o programa começar
    public static void main(String[] args) {
        //Definindo a variável scanner que irá receber informações
        Scanner entrada = new Scanner(System.in);
        //Definindo uma lista de Floats(Numeros quebrados)
        List<Float> saltos = new ArrayList<>();
        //Definindo uma lista de Strings(Letras no geral destacadas com "")
        List<String> saltosStr = new ArrayList<>();
        //Perguntando qual o nome do atleta
        System.out.println("Atleta: ");
        //Guardando a resposta com a variável anteriormente criada Scanner em uma variável nova
        String nome = entrada.nextLine();
        //Economizando linhas de código usando uma estrutura de repetição para mostrar informações na tela e guardar itens nas listas criadas
        for (int i = 1; i <= 5; i++) {
            //Perguntando quantos metros saltados por rodada
            System.out.println(i + "º salto(em metros): ");
            //Guardando os saltos numéricos na lista de Strings para facilitar na hora de mostrar a lista com um separador personalisado
            String saltoStr = entrada.nextLine();
            saltosStr.add(saltoStr);
            //Convertendo a informação dada na resposta(Que por padrão sera String) para Float para que seja guardado na lista de Floats
            Float salto = Float.parseFloat(saltoStr);
            saltos.add(salto);
        }
        //Criando uma variável de soma com o padrão de nossos numeros que são Floats
        Float soma = 0.0f;
        //Adicionando na variável recentemente criada de soma todos os valores presentes na lista de Floats com uma estrutura de repetição já usada
        for (Float i : saltos) {
            soma += i;
        }

        //Definindo a média dividindo a soma de todos os itens da lista pela sua quantidade
        Float media = soma / saltos.size(); 
        //Mostrando na tela todos os valores recolhidos durante o andamento do projeto
        System.out.println("Resultado final: ");
        System.out.println("Atleta: " + nome);
        //Definindo um separador personalisado para melhor vsualização do projeto a partir da lista de numeros em String pela viabilidade e facilidade
        String saltosstr = String.join(" - ", (saltosStr));
        System.out.println("Saltos: " + saltosstr);
        System.out.println("Media dos saltos: " + media + " m");
    }
}
