import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteTradutor {

	private Tradutor t;

	@BeforeEach
	public void inicializaTradutor(){
		t = new Tradutor();
	}
	
	@Test
	public void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		t.adicinaTraducao("bom","good");
		assertEquals("good", t.traduzir("bom"));
		assertFalse(t.estaVazio());
	}
	
	@Test
	public void duasTraducao() {
		t.adicinaTraducao("bom","good");
		t.adicinaTraducao("mau","bad");
		assertEquals("good", t.traduzir("bom"));
		assertEquals("bad", t.traduzir("mau"));
		assertFalse(t.estaVazio());
	}
	
	@Test
	public void duasTraducaoMesmaPalavra() {
		t.adicinaTraducao("bom","good");
		t.adicinaTraducao("bom","nice");
		assertEquals("good, nice", t.traduzir("bom"));
	}
	
	@Test
	public void traduzirFrase() {
		t.adicinaTraducao("guerra","war");
		t.adicinaTraducao("é","is");
		t.adicinaTraducao("ruim","bad");
		assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
		assertFalse(t.estaVazio());
	}
	
	@Test
	public void traduzirFraseComDuasTraducoesMesmaPalavra() {
		t.adicinaTraducao("paz","piece");
		t.adicinaTraducao("é","is");
		t.adicinaTraducao("bom","good");
		t.adicinaTraducao("bom","nice");
		assertEquals("piece is good", t.traduzirFrase("paz é bom"));
		assertFalse(t.estaVazio());
	}

}
