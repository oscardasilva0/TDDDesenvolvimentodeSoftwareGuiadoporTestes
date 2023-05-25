package quebraStringsCamelCase_;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TesteSeparaPalavras {

	@Test
	void palavraUnicaSemModificao() {
		String stringTeste = "nome";
		List<String> listaPalavras = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras.get(0), stringTeste);

	}

	@Test
	void retornoMinusculo() {
		String stringTeste = "nome";
		List<String> listaPalavras = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras.get(0), stringTeste);

		String stringTeste2 = "Nome";
		List<String> listaPalavras2 = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras2.get(0), "nome");

	}

	@Test
	void stringComNPalavras() {
		String stringTeste = "nomeComposto";
		List<String> listaPalavras = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras.get(0), "nome");
		assertEquals(listaPalavras.get(1), "composto");

	}

	@Test
	void palavrasComMaisDeUmaLetraMaiscula() {
		String stringTeste = "CPF";
		List<String> listaPalavras = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras.get(0), "CPF");

		String stringTeste2 = "numeroCPF";
		List<String> listaPalavras2 = CamelCase.converterCamelCase(stringTeste2);
		assertEquals(listaPalavras2.get(0), "numero");
		assertEquals(listaPalavras2.get(1), "CPF");

		String stringTeste3 = "numeroCPFContribuinte";
		List<String> listaPalavras3 = CamelCase.converterCamelCase(stringTeste3);
		assertEquals(listaPalavras3.get(0), "numero");
		assertEquals(listaPalavras3.get(1), "CPF");
		assertEquals(listaPalavras3.get(2), "contribuinte");

	}

	@Test
	void numeros() {
		String stringTeste = "recupera10Primeiros";
		List<String> listaPalavras = CamelCase.converterCamelCase(stringTeste);
		assertEquals(listaPalavras.get(0), "recupera");
		assertEquals(listaPalavras.get(1), "10");
		assertEquals(listaPalavras.get(2), "primeiros");

	}

	@Test
	void comecarComNumeros() {
		String stringTeste = "10Primeiros";
		RuntimeException runtimeException = assertThrows(RuntimeException.class,
				() -> CamelCase.converterCamelCase(stringTeste));
		assertTrue(runtimeException.getMessage().contains("o primeiro intem deve começar com letras"));



	}

	@Test
	void caracterEspecialException() {
		String stringTeste = "nome#Composto";
		RuntimeException runtimeException = assertThrows(RuntimeException.class,
				() -> CamelCase.converterCamelCase(stringTeste));
		assertTrue(runtimeException.getMessage().contains("a string não deve conter caracter especial"));

	}

}
