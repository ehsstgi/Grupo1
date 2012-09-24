package clienterodoviario;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class CidadeFacade implements CidadeFacadeRemote {

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Cidade cidade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Cidade cidade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cidade find(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cidade> findAll() {
        Cidade cidade = new Cidade();
        cidade.setEstado("SP");
        cidade.setNome("Cubatão");
        cidade.setId(Long.parseLong("1"));
        List<Cidade> cidades = new ArrayList<Cidade>();
        cidades.add(cidade);
        cidade = new Cidade();
        cidade.setEstado("RJ");
        cidade.setNome("Niterói");
        cidade.setId(Long.parseLong("2"));
        cidades.add(cidade);
        cidade = new Cidade();
        cidade.setEstado("MG");
        cidade.setNome("Belo Horizonte");  
        cidade.setId(Long.parseLong("3"));
        cidades.add(cidade);
        return cidades;
    }

    @Override
    public List<Cidade> findRange(int[] ints) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Cidade cidade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
