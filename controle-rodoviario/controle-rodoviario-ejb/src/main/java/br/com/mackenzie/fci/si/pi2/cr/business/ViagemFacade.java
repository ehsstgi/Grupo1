/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
public class ViagemFacade extends AbstractFacade<Viagem> implements ViagemFacadeRemote {
    @PersistenceContext(unitName = "CRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViagemFacade() {
        super(Viagem.class);
    }
    
    public List<Viagem> listarViagens(Long idOrigem, Long idDestino, String date) {
        Query query = getEntityManager().createQuery("select v from Viagem v where v.origem.id = :idOrigem and v.destino.id = :idDestino and v.data between :dataInicioDia and :dataFinalDia");
        query.setParameter("idOrigem", idOrigem);
        query.setParameter("idDestino", idDestino);
        try {
            Date dataConvertida = null;
            if(date == null || "".equals(date.trim())) {
                dataConvertida = new Date();
            } else {
                dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataConvertida);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            
            query.setParameter("dataInicioDia", calendar.getTime());
            
            calendar.set(Calendar.HOUR, 23);
            calendar.set(Calendar.MINUTE, 59);
            query.setParameter("dataFinalDia", calendar.getTime());
        } catch (ParseException ex) {
            throw new RuntimeException("Erro ao converter a data", ex);
        }
        final List resultado = query.getResultList();
        return resultado;
    }
    
}
