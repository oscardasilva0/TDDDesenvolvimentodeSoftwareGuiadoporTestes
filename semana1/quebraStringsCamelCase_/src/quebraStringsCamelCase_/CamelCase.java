package quebraStringsCamelCase_;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	public static List<String> converterCamelCase(String original) {
		validaString(original);
		List<String> lista = separaPalavras(original);
		lista = removeLetraMaiscula(lista);
		return lista;
	}
	
	public static void validaString(String stringPalavras) {
		if(Character.isDigit(stringPalavras.charAt(0))){
			throw new CamelCaseLetraInicioException("o primeiro intem deve começar com letras");
		}
		String caracterEspecial = stringPalavras.replaceAll("[\\w]", "");
		if(caracterEspecial.length()> 0){
			throw new CamelCaseCaracterEspecialException("a string não deve conter caracter especial");
		}
		
	}

	private static List<String> separaPalavras(String stringPalavras) {
		List<String> listPalavras = new ArrayList<>();
		for (int i = 0; i < stringPalavras.length(); i++) {
			listPalavras = addPalavra( proximaPalavraMinuscula(stringPalavras, i), listPalavras);
			listPalavras = addPalavra( proximaPalavraMaiscula(stringPalavras, i), listPalavras);
			listPalavras = addPalavra( proximoNumero(stringPalavras, i), listPalavras);
			i = i + (listPalavras.get(listPalavras.size()-1)).length() - 1;
		}
		return listPalavras;
	}

	private static List<String> addPalavra(String palavra , List<String> listPalavras) {
		if (palavra != null && palavra.length() > 0) {
			listPalavras.add(palavra);
		}
		return listPalavras;		
	}
	
	private static String proximoNumero(String stringPalavras, int posicao) {
		int ultimaPosicao = percorreNumero(stringPalavras, posicao);
		if (ultimaPosicao > posicao) {
			return stringPalavras.substring(posicao, ultimaPosicao);			
		}
		return null;
	}
	
	private static int percorreNumero(String stringPalavras, int posicao) {
		int ultimaPosicao = posicao;
		for (int i = posicao + 1; i < stringPalavras.length(); i++) {
			ultimaPosicao = i;
			if (!Character.isDigit(stringPalavras.charAt(i)))				
				break;
		}
		if (posicao + 1 == ultimaPosicao)
			return posicao;
		return ultimaPosicao;
	}

	private static String proximaPalavraMinuscula(String stringPalavras, int posicao) {
		int ultimaPosicao = percorreMinusculas(stringPalavras, posicao);
		if (ultimaPosicao > posicao) {
			Boolean letraMaisculaOuNumerro = Character.isUpperCase(stringPalavras.charAt(ultimaPosicao))||Character.isDigit(stringPalavras.charAt(ultimaPosicao));
			if (letraMaisculaOuNumerro)
				return stringPalavras.substring(posicao, ultimaPosicao);
			else
				return stringPalavras.substring(posicao, ultimaPosicao + 1);
		}
		return null;
	}

	private static int percorreMinusculas(String stringPalavras, int posicao) {
		int ultimaPosicao = posicao;
		for (int i = posicao + 1; i < stringPalavras.length(); i++) {
			Boolean letraMaisculaOuNumerro = Character.isUpperCase(stringPalavras.charAt(i))||Character.isDigit(stringPalavras.charAt(i));
			ultimaPosicao = i;
			if (letraMaisculaOuNumerro)
				break;
		}
		if (posicao + 1 == ultimaPosicao)
			return posicao;
		return ultimaPosicao;
	}

	private static String proximaPalavraMaiscula(String stringPalavras, int posicao) {
		int ultimaPosicao = percorreMaisculas(stringPalavras, posicao);
		if (ultimaPosicao > posicao) {
			Boolean letraMaiscula = Character.isLowerCase(stringPalavras.charAt(ultimaPosicao)) ||Character.isDigit(stringPalavras.charAt(ultimaPosicao));
			if (letraMaiscula)
				return stringPalavras.substring(posicao, ultimaPosicao - 1);
			else
				return stringPalavras.substring(posicao, ultimaPosicao + 1);
		}
		return null;
	}

	private static int percorreMaisculas(String stringPalavras, int posicao) {
		int ultimaPosicao = posicao;
		for (int i = posicao + 1; i < stringPalavras.length(); i++) {
			Boolean letraMinusculaOuNumero = Character.isLowerCase(stringPalavras.charAt(i)) ||Character.isDigit(stringPalavras.charAt(i));
			ultimaPosicao = i;
			if (letraMinusculaOuNumero)
				break;
		}
		if (posicao + 1 == ultimaPosicao)
			return posicao;
		return ultimaPosicao;

	}

	private static List<String> removeLetraMaiscula(List<String> listPalavras) {
		for (int i = 0; i < listPalavras.size(); i++) {
			String palavra = listPalavras.get(i);
			Boolean letraMaiscula = Character.isUpperCase(palavra.charAt(1));
			if (!letraMaiscula) {
				listPalavras.set(i, palavra.toLowerCase());
			}
		}
		return listPalavras;
	}

}
