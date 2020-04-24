package br.com.teste.watson.configuration;

public enum ConfigurationEnum {
	
	API_KEY("g854TOjoPWkcPxpSHSrTGGePijCnd6lLERUcw3z9MJnd"),
	VERSION("2020-04-20"),
	URL("https://api.eu-gb.assistant.watson.cloud.ibm.com/instances/8b4c38e7-e1a0-474f-9b7e-6babb6ed553a"),
	ASSISTANT_ID("ad000f87-0260-4923-af2e-5929e304b474");
		
	public String value;
	
	ConfigurationEnum (String value) {
		this.value = value;
    }

}
