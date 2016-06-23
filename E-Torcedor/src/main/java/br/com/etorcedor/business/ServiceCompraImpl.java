package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.persistence.RepositorioCompra;

@Service
public class ServiceCompraImpl implements ServiceCompra {

	private static final long serialVersionUID = 5837005411992902237L;

	@Autowired
	private RepositorioCompra repCompra;
	
	@Autowired
	private ServiceJogo jogoServ;
	
	@Transactional(rollbackOn = DelitoExistenteException.class)
	public void adicionarComprar(Compra compra)throws DelitoExistenteException, JogoInexistenteException{
		
		for(Delito d : compra.getUsuario().getDelitos()) {
			if(d != null) 
				throw new DelitoExistenteException();
		}
		
		for(Ingresso i : compra.getIngressos()) {
			JogoLong jogo = this.jogoServ.findOneJogo(i.getJogo().getId());
			if(jogo.getIngressos_quantidade() != jogo.getIngressos_vendidos()) {
				jogo.setIngressos_vendidos(jogo.getIngressos_vendidos()+1);
				this.jogoServ.atualizarJogo(jogo);				
			}
			compra.setValorTotal(compra.getValorTotal()+i.getValorIngresso());		
		}
		this.repCompra.save(compra);
	}

	public void removerCompras(Compra compra) {
		this.repCompra.delete(compra);
	}

	public Compra findByOneCompra(Long id) {
		return this.repCompra.findOne(id);
	}

	public List<Compra> findByDia(Date dia) {
		return this.findByDia(dia);
	}

	public List<Compra> findByUsuario(Usuario usuario) {
		return this.repCompra.findByUsuario(usuario);
	}

	public List<Compra> findByAllCompras() {
		return (List<Compra>) this.repCompra.findAll();
	}

}
