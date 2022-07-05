public class Horario {
	private int horas;
	private int minutos;

    //Utilização do horario: retorna apenas true ou false e um aviso de horário inválido, caso false
    //quando usamos a data, forçamos um do while que só seta o horário quando é retornado true

	// ================= Métodos da Classe
	public String criarHorario() {
		return String.format("%02d", this.horas) + ":" + String.format("%02d", this.minutos);
	}

    public static boolean validarHora(int horas) {
        if (horas >= 0 && horas <= 23) {
          return true;
        } else {
          System.out.println("\n==!== AVISO: Insira uma hora válida!\n");
          return false;
        }
      }
    
      public static boolean validarMinutos(int minutos) {
        if (minutos >= 0 && minutos <= 59) {
          return true;
        } else {
          System.out.println("\n==!== AVISO: Insira minutos válidos!\n");
          return false;
        }
      }

	// ================= Construtores
	public Horario() {
		this(0, 0);
	}

	public Horario(int horas, int minutos) {
		this.setHoras(horas);
		this.setMinutos(minutos);
	}

	// ================= Getters e Setters
	public int getHoras() {
		return this.horas;
	}

	public int getMinutos() {
		return this.minutos;
	}

	public void setHoras(int horas) {
		if (!(Horario.validarHora(horas))){
			this.horas = horas;	
		}
	}

	public void setMinutos(int minutos) {
		if (!(Horario.validarMinutos(minutos))) {
			this.minutos = minutos;
		} 
	}
}  
