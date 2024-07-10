import java.util.Scanner;

public class Carro {

    // Atributo privado que armazena o consumo de combustível do carro em km/l
    private Float consumo;
    
    // Atributo privado que armazena a quantidade de combustível no tanque do carro
    private int combustivel;

    // Construtor da classe Carro que recebe o consumo de combustível como parâmetro
    public Carro(Float consumo) {
        // Inicializa o consumo de combustível com o valor passado como parâmetro
        this.consumo = consumo;
        // Inicializa a quantidade de combustível no tanque com 0
        this.combustivel = 0;
    }

    // Método que simula o carro andando uma determinada distância
    public void andar(int distancia) {
        // Calcula a quantidade de combustível gasto com base na distância e no consumo
        Float combustivel_gasto = distancia / this.consumo;
        // Subtrai a quantidade de combustível gasto do tanque
        this.combustivel -= combustivel_gasto;
        // Verifica se o carro não conseguiu completar o trajeto devido à falta de combustível
        if (this.combustivel < 0) {
            // Calcula a distância máxima que o carro conseguiu percorrer com o combustível disponível
            Float distancia_maxima = (this.combustivel + combustivel_gasto) * this.consumo;
            // Calcula a distância restante para completar o trajeto
            Float distancia_restante = distancia - distancia_maxima;
            // Exibe mensagem informando que o carro não conseguiu completar o trajeto
            System.out.println("Você não conseguiu completar o trajeto, com a quantidade de combustivel que você possuia, só conseguiu percorrer " + distancia_maxima + "km, lhe faltando " + distancia_restante + "km para chegar ao final do percurso!");
            // Modifica o combustivel para torna-lo zerado
            this.combustivel = 0;
            // Define um método para evitar erros na hora de calcular os km's
        } else if (this.combustivel == 0) {
            // Exibe uma mensagem dizendo que não é possivel viajar
            System.out.println("Você não possui nenhum pingo de gasolina no tanque, não consegue viajar!");
        }
    }

    // Método que retorna a quantidade de combustível no tanque do carro
    public int obterGasolina() {
        return this.combustivel;
    }

    // Método que adiciona combustível ao tanque do carro
    public void adicionarGasolina(int adicional) {
        // Verifica se a quantidade de combustível adicionada não ultrapassa a capacidade máxima do tanque (55 litros)
        if (this.combustivel + adicional > 55) {
            // Exibe mensagem informando que o carro não comporta mais de 55 litros
            System.out.println("O carro não comporta mais de 55 litros, coloque menos! ");
        } else {
            // Adiciona a quantidade de combustível ao tanque
            this.combustivel += adicional;
            // Exibe mensagem informando a quantidade de combustível atual no tanque
            System.out.println("Você tem agora " + this.combustivel + " litros de gasolina!");
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception{
        // Cria um objeto Scanner para ler entrada do usuário
        Scanner entrada = new Scanner(System.in);
        
        // Exibe mensagem de boas-vindas ao usuário
        System.out.println("Bem vindo ao simulador de carro simplificado!");
        
        // Variável que armazena a quantidade de combustível inicial do carro
        int combustivel;
        
        // Loop que pede ao usuário a quantidade de combustível inicial do carro
        for (;;) {
            // Exibe mensagem pedindo ao usuário a quantidade de combustível inicial
            System.out.println("Quanto de combustivel tem no carro? ");
            // Lê a entrada do usuário
            int combustivel_teste = entrada.nextInt();
            // Verifica se a quantidade de combustível é válida (menor ou igual a 55 litros)
            if (combustivel_teste > 55) {
                // Exibe mensagem informando que o carro não comporta mais de 55 litros
                System.out.println("O carro não comporta mais de 55 litros, coloque menos!");
            } else {
                // Armazena a quantidade de combustível inicial válida
                combustivel = combustivel_teste;
                // Sai do loop
                break;
            }
        }
        
        // Exibe mensagem pedindo ao usuário o consumo de gasolina do carro
        System.out.println("Quantos km o automovel percorre por litro? ");
        // Lê a entrada do usuário
        String consumostr = entrada.next();
        // Converte a entrada em um valor float
        Float consumo = Float.parseFloat(consumostr);
        
        // Cria um objeto Carro com o consumo de gasolina informado
        Carro carro = new Carro(consumo);
        
        // Adiciona a quantidade de combustível inicial ao tanque do carro
        carro.adicionarGasolina(combustivel);
        
        // Loop que permite ao usuário interagir com o carro
        for (;;) {
            // Exibe menu de opções ao usuário
            System.out.println("Digite 1 para viajar ");
            System.out.println("Digite 2 para ver a gasolina ");
            System.out.println("Digite 3 para abastecer ");
            System.out.println("Digite 4 para sair");
            System.out.println("O que vai fazer? ");
            // Lê a escolha do usuário
            int escolha = entrada.nextInt();
            
            // Verifica a escolha do usuário e executa a ação correspondente
            if (escolha == 1) {
                // Pede ao usuário a distância que deseja viajar
                System.out.println("Quantos km vai viajar? ");
                int km = entrada.nextInt();
                // Chama o método andar do carro com a distância informada
                carro.andar(km);
            } else if (escolha == 2) {
                // Exibe a quantidade de combustível atual no tanque do carro
                System.out.println("Você tem " + carro.obterGasolina() + " litros de gasolina no tanque!");
            } else if (escolha == 3) {
                // Pede ao usuário a quantidade de combustível que deseja adicionar
                System.out.println("Quanto de gasolina deseja adicionar agora? ");
                int gasolina = entrada.nextInt();
                // Chama o método adicionarGasolina do carro com a quantidade informada
                carro.adicionarGasolina(gasolina);
            } else if (escolha == 4) {
                // Exibe mensagem de despedida ao usuário e sai do loop
                System.out.println("Volte sempre!");
                break;
            } else {
                // Exibe mensagem informando que a escolha é inválida
                System.out.println("Digite um numero que esteja entre as opções!");
            }
        }
    }
}
