package Modelos;

public record CEP(String cep, String logradouro, String bairro, String localidade, String uf, int ddd) {
    @Override
    public String toString() {
        return """
                CEP: %s
                Logradouro: %s
                Bairro: %s
                Localidade: %s
                UF: %s
                DDD: %d""".formatted(this.cep, this.logradouro, this.bairro, this.localidade, this.uf, this.ddd);
    }
}
