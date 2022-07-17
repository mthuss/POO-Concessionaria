public class Data
{
    private int dia, mes, ano;
  
    public static boolean validarDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            return true;
        } else {
            System.out.println("\n==!== AVISO: Insira um dia válido!\n");
            return false;
        }
    }

  public static boolean validarMes(int mes) {
    if (mes >= 1 && mes <= 12) {
      return true;
    } else {
      System.out.println("\n==!== AVISO: Insira um mês válido!\n");
      return false;
    }
  }

  public static boolean validarAno(int ano) {
    if (ano >= 1950 && ano < 2050) {
      return true;
    } else {
      System.out.println("\n==!== AVISO: Insira um ano válido!\n");
      return false;
    }
  }
  
  //imprime no formato dd/mm/aaaa
	public String criarData() {
		return String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/" + this.ano;
	}

	// =============== Construtores
        public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
        
	public Data() {
		this(0, 0, 0);
	}
  
	// =============== Getters e Setters

	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAno() {
		return this.ano;
	}

	public void setData(Data data) {
		this.setDia(data.getDia());
		this.setMes(data.getMes());
		this.setAno(data.getAno());
	}

	public void setDia(int dia) {
		if(!Data.validarDia(dia)) {
            this.dia = dia;
        }
	}

	public void setMes(int mes) {
		if (!Data.validarMes(mes)) {
			this.mes = mes;
		}
	}

	public void setAno(int ano) {
		if (!Data.validarAno(ano)) {
			this.ano = ano;
		}
	}
}


