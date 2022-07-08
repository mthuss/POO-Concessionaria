package javaapplication1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Motocicleta extends Veiculo
{
    private int cilindradas;
    private String tipo;
    Scanner input = new Scanner(System.in);
    ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
    //Parte de arquivos 
    String arquivoMotocicletas = "motocicletas.txt";
    File arq = new File(arquivoMotocicletas);
 
    //Construtor
    public Motocicleta(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, boolean status, int cilindradas, String tipo) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }
    
    public Motocicleta(){
        this(0, "", "", 0, 0, "", 0, false, 0, "");
    }
    
    //Getters e setters    
    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    // Métodos da classe
    public void menuMotocicletaGerente(){
        //o Gerente pode alterar
        int op;
       
        do{
            System.out.println("Menu Motocicleta");
            System.out.println("1 - Cadastrar motocicleta");
            System.out.println("2 - Visualizar motocicletas");
            System.out.println("3 - Alterar informações de motocicletas");
            System.out.println("4 - Excluir motocicleta");
            System.out.println("5 - Sair");

            op = input.nextInt();
            input.nextLine();
        
        
            switch(op){
                case 1: 
                    cadastrarMotocicletas();
                break;
                case 2:
                    visualizarMotocicletas();
                break;
                case 3:
                    alterarMotocicletas();
                case 5:
                break;               
                default: 
                    System.out.println("Digite uma opção válida!");
                break;
            }
        }while(op != 5);      
    }
    
    
    public void cadastrarMotocicletas(){
        int ano;
        Motocicleta novaMotocicleta = new Motocicleta();
        
        System.out.println("Digite as cilidradas: ");
        novaMotocicleta.setCilindradas(input.nextInt());
        input.nextLine();
        
        System.out.println("Digite o tipo: ");
        novaMotocicleta.setTipo(input.nextLine());       
        
        System.out.println("Digite o número do chassi: ");
        novaMotocicleta.setNumChassi(input.nextInt());
        input.nextLine();
        
        System.out.println("Digite a marca: ");
        novaMotocicleta.setMarca(input.nextLine());
        
        System.out.println("Digite o modelo: ");
        novaMotocicleta.setModelo(input.nextLine());
        
        do {
            System.out.println("Digite o ano: ");
            ano = input.nextInt();
            input.nextLine();
        } while(!Data.validarAno(ano));
        
        novaMotocicleta.setAno(ano);
       
        
        System.out.println("Digite a kilometragem: ");
        novaMotocicleta.setKilometragem(input.nextInt());
        input.nextLine();
        
        System.out.println("Digite o tipo de combustível: ");
        novaMotocicleta.setTipoCombustivel(input.nextLine());
        
        System.out.println("Digite o peso: ");
        novaMotocicleta.setPeso(input.nextFloat());
        input.nextLine();
        
        System.out.println("Digite o status: ");
        novaMotocicleta.setStatus(input.nextBoolean());
        
        
        listaMotocicletas.add(novaMotocicleta);
        escreverMotosNoArquivo();  
    }

    public void escreverMotosNoArquivo(){
        try{            
            
            FileWriter escritor = new FileWriter(arq, true);
            //lembrar que a escrita do arquivo prossegue do ponto que parou
            for(int i = 0; i < listaMotocicletas.size(); i++){
                escritor.write(listaMotocicletas.get(i).getCilindradas() + "\n");
                escritor.write(listaMotocicletas.get(i).getTipo() + "\n");
                escritor.write(listaMotocicletas.get(i).getNumChassi() + "\n");
                escritor.write(listaMotocicletas.get(i).getMarca() + "\n");
                escritor.write(listaMotocicletas.get(i).getModelo() + "\n");
                escritor.write(listaMotocicletas.get(i).getAno() + "\n");
                escritor.write(listaMotocicletas.get(i).getKilometragem() + "\n");
                escritor.write(listaMotocicletas.get(i).getTipoCombustivel() + "\n");
                escritor.write(listaMotocicletas.get(i).getPeso() + "\n");
                escritor.write(listaMotocicletas.get(i).isStatus() + "\n");
                escritor.write("\n");
            }                    
            escritor.close();                        
        }
        catch(IOException e)
        {
            System.out.println("Erro" + e);
        }
    }


    public void visualizarMotocicletas(){
        for(int i = 0; i < listaMotocicletas.size(); i++){
            System.out.printf("\nMotocicleta %d\n", i+1);
            System.out.println("Cilidradas: " + listaMotocicletas.get(i).getCilindradas());
            System.out.println("Tipo: " + listaMotocicletas.get(i).getTipo());
            System.out.println("Número do chassi: " + listaMotocicletas.get(i).getNumChassi());
            System.out.println("Marca: " + listaMotocicletas.get(i).getMarca());
            System.out.println("Modelo: " + listaMotocicletas.get(i).getModelo());
            System.out.println("Ano: " + listaMotocicletas.get(i).getAno());
            System.out.println("Kilometragem: " + listaMotocicletas.get(i).getKilometragem());
            System.out.println("Tipo de Combustível: " + listaMotocicletas.get(i).getTipoCombustivel());
            System.out.println("Peso: " + listaMotocicletas.get(i).getPeso());
            System.out.println("Status: " + listaMotocicletas.get(i).isStatus());
        }
    }
    
    public void alterarMotocicletas(){
        Scanner input = new Scanner(System.in);
        int moto;
        int opMenu;
        int ano;
        visualizarMotocicletas();
        System.out.println("Qual motocicleta deseja alterar?");
        moto = (input.nextInt() - 1);
        
        if (listaMotocicletas.size() == 0) 
            System.out.println("\nNão há motocicletas cadastradas.");
        else{
            do {                                     
                System.out.println("\nQual dado deseja alterar?");
                System.out.println("(1) Alterar cilindradas");
                System.out.println("(2) Alterar tipo");
                System.out.println("(3) Alterar número do chassi");
                System.out.println("(4) Alterar marca");
                System.out.println("(5) Alterar modelo");
                System.out.println("(6) Alterar ano");
                System.out.println("(7) Alterar kilometragem");
                System.out.println("(8) Alterar tipo de combustível");
                System.out.println("(9) Alterar peso");
                System.out.println("(10) Alterar status");
                System.out.println("(11) Sair");
                System.out.println("\nDigite a opção desejada: ");
                opMenu = input.nextInt();
                input.nextLine();
    
                switch (opMenu) {
                    case 1:
                        System.out.print("\nDigite as novas cilindradas: ");
                        listaMotocicletas.get(moto).setCilindradas(input.nextInt());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 2:
                        System.out.print("\nDigite o novo tipo: ");
                        listaMotocicletas.get(moto).setTipo(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 3:
                        System.out.print("\nDigite o novo número de chassi: ");
                        listaMotocicletas.get(moto).setNumChassi(input.nextLong());    
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 4:
                        System.out.print("\nDigite a nova marca: ");
                        listaMotocicletas.get(moto).setMarca(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 5:
                        System.out.print("\nDigite o novo modelo: ");
                        listaMotocicletas.get(moto).setModelo(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 6:
                        do {
                            System.out.print("\nDigite o novo ano: ");
                            ano = input.nextInt();
                            input.nextLine();
                        } while(!Data.validarAno(ano));                    
                        listaMotocicletas.get(moto).setAno(input.nextInt());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 7:
                        System.out.print("\nDigite a nova kilometragem: ");
                        listaMotocicletas.get(moto).setKilometragem(input.nextFloat());   
                        input.nextLine();   
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 8:
                        System.out.print("\nDigite o novo tipo de combustível: ");
                        listaMotocicletas.get(moto).setTipoCombustivel(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 9:
                        System.out.print("\nDigite o novo peso: ");
                        listaMotocicletas.get(moto).setPeso(input.nextFloat()); 
                        input.nextLine();     
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 10:
                        System.out.print("\nDigite o novo status: ");
                        listaMotocicletas.get(moto).setStatus(input.nextBoolean());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                    break;
                }
            } while(opMenu != 11);
        }

        visualizarMotocicletas();
        arq.delete();
        escreverMotosNoArquivo();
       
        //leitura do arquivo
        /* 
        try{
            FileReader arq_leitor = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arq_leitor);
            //sobrescrever uma linha do arquivo
            
            while(leitor.ready()){
                System.out.println(leitor.readLine());
            }
            leitor.close();
        }
        catch(IOException e){
            System.out.println("Erro" + e);
        }
        */    
    }   
}
