/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Passagem;
import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
public class PassagemFacade extends AbstractFacade<Passagem> implements PassagemFacadeRemote {
    @PersistenceContext(unitName = "CRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassagemFacade() {
        super(Passagem.class);
    }
    
    public List<Passagem> listarPassagensCompradasPorViagem(Viagem viagem) {
        BigDecimal distanciaPontoInicialParaOrigem = recuperarDistanciaPontoInicialParaOrigem(viagem);
        BigDecimal distanciaPontoInicialParaDestino = recuperarDistanciaPontoInicialParaDestino(viagem);
        
        Query query = em.createQuery("select p from Passagem p where p.viagem.id in (select v.id from Viagem v where v.linha.id = :idLinha and v.destino.id in (select vi.destino.id from Viagem vi where vi.linha.id = :idLinha and vi.distancia between :distanciaOrigem and :distanciaDestino))");
        query.setParameter("idLinha", viagem.getLinha().getId());
        query.setParameter("distanciaOrigem", distanciaPontoInicialParaOrigem);
        query.setParameter("distanciaDestino", distanciaPontoInicialParaDestino);
        
        return query.getResultList();
    }

    private BigDecimal recuperarDistanciaPontoInicialParaOrigem(Viagem viagem) {
        if(viagem.getOrigem().getId().equals(viagem.getLinha().getOrigem().getId())) {
          return BigDecimal.ZERO;
        } 
        Query query = em.createQuery("select v from Viagem v where v.linha.id = :idLinha and v.origem.id = v.linha.origem.id and v.destino.id = :idDestino");
        query.setParameter("idLinha", viagem.getLinha().getId());
        query.setParameter("idDestino", viagem.getOrigem().getId());
        Viagem viagemTemp = (Viagem) query.getSingleResult();
        return viagemTemp.getDistancia();
    }
    
    private BigDecimal recuperarDistanciaPontoInicialParaDestino(Viagem viagem) {
        Query query = em.createQuery("select v from Viagem v where v.linha.id = :idLinha and v.origem.id = v.linha.origem.id and v.destino.id = :idDestino");
        query.setParameter("idLinha", viagem.getLinha().getId());
        query.setParameter("idDestino", viagem.getDestino().getId());
        Viagem viagemTemp = (Viagem) query.getSingleResult();
        return viagemTemp.getDistancia();
    }
    
    public List<Passagem> listarPassagensPorCPF(String cpf) {
        Query query = em.createQuery("select p from Passagem p where p.documentoPassageiro = :cpf");
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }
    
    public Passagem buscarPassagemPorViagemEAssento(Long idViagem, Integer assento) {
        Query query = em.createQuery("select p from Passagem p where p.viagem.id = :idViagem and p.assento = :assento");
        query.setParameter("idViagem", idViagem);
        query.setParameter("assento", assento);
        return (Passagem) query.getSingleResult();
    }
    
}
