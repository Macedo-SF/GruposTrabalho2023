package com.sfm.grupostrabalho2023;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class ConsultaService implements ConsultaServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    //<editor-fold defaultstate="collapsed" desc="Consulta 1">
    @Override
    public List<Pessoa> findAllPessoaQuerry() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaTypedQuery() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 2">
    @Override
    public List<String> findNomeQuery() {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }

    @Override
    public List<String> findNomeTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return q.getResultList();
    }

    @Override
    public List<String> findNomeNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNome", String.class).getResultList();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 3">
    @Override
    public List<Object[]> fiindNomeEnderecoQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> fiindNomeEnderecoTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> fiindNomeEnderecoNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNomeEndereco", Object[].class).getResultList();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 4">
    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaQuery() {

        Query q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE p.endereco.tipoLogradouro = 1", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findPessoaQueMoramEmAvenida", Pessoa.class).getResultList();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 5">
    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaQuery() {
        Query q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE NOT p.endereco.tipoLogradouro = 2");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE NOT p.endereco.tipoLogradouro = 2", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findPessoaQueNaoMoramEmPraca", Pessoa.class).getResultList();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 6">
    @Override
    public List<Object[]> findNomeTelefoneQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p "
                + "JOIN p.telefones t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findNomeTelefoneTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t ", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findNomeTelefoneNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNomeTelefones", Object[].class).getResultList();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 7">
    
    @Override
    public List<Pessoa> consulta7(LocalDate beginDate, LocalDate endDate) {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :beginDate AND :endDate").setParameter("beginDate", beginDate).setParameter("endDate", endDate);
        return (List<Pessoa>) q.getResultList();
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 8">

    @Override
    public List<Pessoa> consulta8() {
        TypedQuery<Pessoa> query = entityManager.createQuery(
                "SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd IN (21, 41)", //testei com 22 e 44, ninguém tem 21 e 41, fiquei horas nisso...
                Pessoa.class
        );
        return query.getResultList();
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 9">
    
    @Override
    public List<Pessoa> consulta9() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY");
        return (List<Pessoa>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 10">
    
    @Override
    public List<Object[]> consulta10() {
        Query q = entityManager.createQuery("SELECT p.nome, count(t.id) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome");
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 11">
    
    @Override
    public List<Grupo> findGruposNaoAtivos() {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g WHERE g.ativo=false");
        return (List<Grupo>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 12">
    
    @Override
    public List<Object[]> findLiderENomeGrupo() {
        Query q = entityManager.createQuery("SELECT g.nome, l.nome FROM Grupo g JOIN g.lider l");
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 13">
    
    @Override
    public List<String> consulta13(String nomeGrupo) {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p JOIN p.atuacoes a WHERE a.grupo.nome =:nomeGrupo ORDER BY p.nome DESC").setParameter("nomeGrupo", nomeGrupo);
        return (List<String>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 14">
    
    @Override
    public List<Grupo> consulta14(String nomeLider) {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g JOIN g.lider l WHERE l.nome=: nomeLider").setParameter("nomeLider", nomeLider);
        return (List<Grupo>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 15">
    
    @Override
    public List<Object[]> consulta15(String nomeMembro) {
        Query q = entityManager.createQuery("SELECT g.nome,a.inicio,a.termino FROM Grupo g JOIN g.atuacoes a  WHERE a.pessoa.nome=:nomeMembro").setParameter("nomeMembro", nomeMembro);
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 16">
    
    @Override
    public List<Grupo> consulta16(String str) {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g WHERE g.nome LIKE :str ").setParameter("str", '%' + str + '%');
        return (List<Grupo>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 17">
    
    @Override
    public List<Object[]> consulta17() {
        Query q = entityManager.createQuery("SELECT g.nome,count(DISTINCT a.pessoa) FROM Grupo g JOIN g.atuacoes a GROUP BY g");
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 18">
    
    @Override
    public List<Object[]> consulta18(long qtd) {
        Query q = entityManager.createQuery("SELECT g.nome, COUNT(a.id) FROM Grupo g JOIN g.atuacoes a GROUP BY g HAVING COUNT(a.id) >= :qtd").setParameter("qtd", qtd);
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 19">
    
    @Override
    public List<String> consulta19(String nomeGrupo, LocalDate data) {
        Query q = entityManager.createQuery("SELECT DISTINCT a.pessoa.nome FROM Grupo g JOIN g.atuacoes a WHERE g.nome =:nomeGrupo AND a.inicio>=: data").setParameter("nomeGrupo", nomeGrupo).setParameter("data", data);
        return (List<String>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 20">
    
    @Override
    public List<Object[]> consulta20(LocalDate data) {
        Query q = entityManager.createQuery("SELECT g.nome, a.pessoa.nome, a.inicio FROM Grupo g JOIN g.atuacoes a WHERE a.inicio>=:data ORDER BY g.nome").setParameter("data", data);
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 21">
    
    @Override
    public List<Object[]> consulta21() {
        Query q = entityManager.createQuery("SELECT g.nome, a.pessoa.nome FROM Grupo g JOIN g.atuacoes a WHERE a.termino IS NULL");
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consulta 22">
    
    @Override
    public List<Object[]> consulta22() {
        Query q = entityManager.createQuery("SELECT g.nome, g.lider.nome, a.pessoa.nome FROM Grupo g JOIN g.atuacoes a ORDER BY g.nome, g.lider.nome, a.pessoa.nome");
        return (List<Object[]>) q.getResultList();
    }
    
    //</editor-fold>
    
}