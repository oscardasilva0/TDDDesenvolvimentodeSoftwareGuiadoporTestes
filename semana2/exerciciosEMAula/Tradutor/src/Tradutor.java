import java.util.HashMap;

public class Tradutor {

	HashMap <String, String> traducaoList = new HashMap <String, String>();
	public Boolean estaVazio() {
		return (traducaoList.size()==0);
	}

	public String traduzir(String palavra) {
		// TODO Auto-generated method stub
		
		return traducaoList.get(palavra);
	}

	public void adicinaTraducao(String palavra, String traducao) {
		if(traducaoList.containsKey(palavra)) {
			traducao = traduzir(palavra) + ", " + traducao; 
		}
		traducaoList.put(palavra,traducao);
		
	}

	public String traduzirFrase(String frases) {
		// TODO Auto-generated method stub
		String[] palavras = frases.split("\s");
		String fraseTraduzida = "";
		for (String palavra : palavras) {
			String traducao = primeiraTraducao(palavra);
			fraseTraduzida = fraseTraduzida + traducao + "\s" ;
			
		}		
		return fraseTraduzida.trim();
	}

	private String primeiraTraducao(String palavra) {
		String traducao = traduzir(palavra);
		if(traducao.contains(",")) {
			traducao = traducao.substring(0, traducao.indexOf(","));
		}
		return traducao;
	}

}
