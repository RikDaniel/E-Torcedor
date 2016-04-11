package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Usuario;
import java.util.List;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;

/**
 * Define todos os métodos necessários para o repositorio da entidade Usuario
 * @author layon
 *
 */
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
	
	/**
	 * 
	 * Procura um usuário pelo seu cpf.
	 * @param cpf
	 * @return Uma entidade do tipo Usuario
	 */
	public Usuario findByCpf(String cpf);
	
	/**
	 * 
	 * Procura um usuário pelo seu e-mail.
	 * @param email
	 * @return Uma entidade do tipo Usuario
	 */
	public Usuario findByEmail(String email);
	
	/**
	 * Procura todos os usuarios pelo seu nome, 
	 * ordenando de forma ascendente.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByNomeOrderByNomeAsc(String nome);
	
	/**
	 * Recupera uma lista de usuario contendo um nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByNomeContaining(String nome);
	
	/**
	 * Recupera uma lista de usuario iniciado com um nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByNomeStartingWith(String nome);
	
	/**
	 * 
	 * Procura todos os usuário que estejam em um Time,
	 * ordenando de forma ascendente, 
	 * utilizando o nome como critério.
	 * @param clube
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByClubeOrderByNomeAsc(Time clube);
	
	/**
	 * 
	 * Procura todos os usuarios que estejam em uma Torcida,
	 * ordenando de forma ascendente, utilizando o nome como critério.
	 * @param torcida
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByTorcidaOrderByNomeAsc(Torcida torcida );
	
}
