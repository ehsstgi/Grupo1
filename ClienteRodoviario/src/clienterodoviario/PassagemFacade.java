package clienterodoviario;

import br.com.mackenzie.fci.si.pi2.cr.business.PassagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Passagem;
import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.util.ArrayList;
import java.util.List;

public class PassagemFacade implements PassagemFacadeRemote{

    @Override
    public void create(Passagem psgm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Passagem psgm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Passagem psgm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Passagem find(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Passagem> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Passagem> findRange(int[] ints) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Passagem> listarPassagensCompradasPorViagem(Viagem viagem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Passagem> listarPassagensPorCPF(String string) {
        Passagem passagem = new Passagem();
        Usuario usuario = new Usuario();
        usuario.setCpf(string);
        usuario.setNome("Pedro");
        usuario.setId(1L);
        passagem.setId(1L);
        passagem.setNomePassageiro("Pedro");
        passagem.setUsuario(usuario);
        passagem.setDocumentoPassageiro("12345678910");
        List<Passagem> passagens = new ArrayList<Passagem>();
        passagens.add(passagem);
        return passagens;
    }
    
    
}
