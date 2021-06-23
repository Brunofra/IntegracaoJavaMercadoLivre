import org.springframework.data.repository.CrudRepository;

import br.com.integracao.mercadolivre.Entitys.Token;

public interface TokenRepository extends CrudRepository<Token, String> {
	Iterable<Token> finByToken(Token token);
	Token findById(Long id);
}
