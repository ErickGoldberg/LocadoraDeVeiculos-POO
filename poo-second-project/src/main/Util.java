package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	Scanner scanner = new Scanner(System.in);
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getString(String message) {
		String texto;

		try {
			System.out.print(message);
			texto = scanner.nextLine();
			return texto;
		} catch (Exception e) {
			System.out.println("Alguma coisa deu errado. Por favor, tente novamente");
			return null;
		}
	}
	
	public char getSexo(String message) {
		char sexo = 'M';
		do{
			try {
				System.out.print(message);
				sexo = scanner.nextLine().toUpperCase().charAt(0);
			} catch (Exception e) {
				System.out.println("Alguma coisa deu errado. Por favor, tente novamente");
			}
		} while (sexo != 'M' && sexo != 'F');
		return sexo;
	}

	public Integer getInt(String message) {
		Integer inteiro = null;
		do {
			try {
				System.out.print(message);
				inteiro = Integer.parseInt(scanner.next());
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			}catch (NumberFormatException e) {
			    System.out.println("Você não digitou um número. Por favor, digite um número.");;
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (inteiro == null);
		return inteiro;
	}

	public Float getFloat(String message) {
		Float decimal = null;
		do {
			try {
				System.out.print(message);
				decimal = scanner.nextFloat();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (decimal == null);
		return decimal;
	}

	public Date getData(String messageAno, String messageMes, String messageDia) {
		Integer ano = getAno(messageAno);
		Integer mes = getMes(messageMes);
		Integer dia = getDia(mes, ano, messageDia);
		
		Date date = null;
		try {
			date = format.parse(dia.toString()+"/"+mes.toString()+"/"+ano.toString());
		} catch (ParseException e) {
			System.out.println("Data inválida.");
		}
		
		return date;
	}
	
	public Date getData(String messageAno, String messageMes) {
		Integer ano = getAno(messageAno);
		Integer mes = getMes(messageMes);
		Integer dia = getDia(mes, ano);
		
		Date date = null;
		try {
			date = format.parse(dia.toString()+"/"+mes.toString()+"/"+ano.toString());
		} catch (ParseException e) {
			System.out.println("Data inválida.");
		}
		
		return date;
	}
	
	public Date getData(String messageAno) {
		Integer ano = getAno(messageAno);
		Integer mes = getMes();
		Integer dia = getDia(mes, ano);
		
		Date date = null;
		try {
			date = format.parse(dia.toString()+"/"+mes.toString()+"/"+ano.toString());
		} catch (ParseException e) {
			System.out.println("Data inválida.");
		}
		
		return date;
	}
	
	public Date getData() {
		Integer ano = getAno();
		Integer mes = getMes();
		Integer dia = getDia(mes, ano);
		
		Date date = null;
		try {
			date = format.parse(dia.toString()+"/"+mes.toString()+"/"+ano.toString());
		} catch (ParseException e) {
			System.out.println("Data inválida.");
		}
		
		return date;
	}

	private Integer getDia(Integer mes, Integer ano) {
		Integer dia = null;
		Integer limiteSuperiorDeDia;
		if (mes == 2)
			if (ano % 4 == 0)
				limiteSuperiorDeDia = 29;
			else
				limiteSuperiorDeDia = 28;
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
			limiteSuperiorDeDia = 30;
		else
			limiteSuperiorDeDia = 31;
		do {
			try {
				System.out.print("Digite o dia: ");
				dia = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (dia == null || dia < 1 || dia > limiteSuperiorDeDia);
		return dia;
	}
	
	private Integer getDia(Integer mes, Integer ano, String message) {
		Integer dia = null;
		Integer limiteSuperiorDeDia;
		if (mes == 2)
			if (ano % 4 == 0)
				limiteSuperiorDeDia = 29;
			else
				limiteSuperiorDeDia = 28;
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
			limiteSuperiorDeDia = 30;
		else
			limiteSuperiorDeDia = 31;
		do {
			try {
				System.out.print(message);
				dia = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (dia == null || dia < 1 || dia > limiteSuperiorDeDia);
		return dia;
	}
	
	private Integer getMes() {
		Integer mes = null;
		do {
			try {
				System.out.print("Digite o mes: ");
				mes = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (mes == null || mes < 1 || mes > 12);
		return mes;
	}
	
	private Integer getMes(String message) {
		Integer mes = null;
		do {
			try {
				System.out.print(message);
				mes = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (mes == null || mes < 1 || mes > 12);
		return mes;
	}
	
	private Integer getAno() {
		Integer ano = null;
		do {
			try {
				System.out.print("Digite o ano: ");
				ano = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (ano == null || ano < 1922);
		return ano;
	}
	
	private Integer getAno(String message) {
		Integer ano = null;
		do {
			try {
				System.out.print(message);
				ano = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException error) {
				System.out.println("Você não digitou um número. Por favor, digite um número.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (ano == null || ano < 1922);
		return ano;
	}
}
